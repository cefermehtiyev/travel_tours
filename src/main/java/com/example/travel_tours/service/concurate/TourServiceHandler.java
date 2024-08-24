package com.example.travel_tours.service.concurate;

import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.repository.DestinationRepository;
import com.example.travel_tours.dao.repository.GuideRepository;
import com.example.travel_tours.dao.repository.TourRepository;
import com.example.travel_tours.dao.repository.TravelerRepository;
import com.example.travel_tours.exception.NotFuondException;
import com.example.travel_tours.mapper.PassportMapper;
import com.example.travel_tours.model.criteria.PageCriteria;
import com.example.travel_tours.model.criteria.TourCriteria;
import com.example.travel_tours.model.enums.ExceptionConstants;
import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.model.request.TourRequest;
import com.example.travel_tours.model.response.DestinationResponse;
import com.example.travel_tours.model.response.GuideScheduleResponse;
import com.example.travel_tours.model.response.PageableTourResponse;
import com.example.travel_tours.model.response.PassportResponse;
import com.example.travel_tours.model.response.TourResponse;
import com.example.travel_tours.model.response.TravelerResponse;
import com.example.travel_tours.service.EntityFetchService;
import com.example.travel_tours.service.abstraction.DestinationService;
import com.example.travel_tours.service.abstraction.GuideScheduleService;
import com.example.travel_tours.service.abstraction.TourService;
import com.example.travel_tours.service.abstraction.TravelerService;
import com.example.travel_tours.service.specification.TourSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.travel_tours.mapper.DestinationMapper.DESTINATION_MAPPER;
import static com.example.travel_tours.mapper.GuideMapper.GUIDE_MAPPER;
import static com.example.travel_tours.mapper.PassportMapper.PASSPORT_MAPPER;
import static com.example.travel_tours.mapper.TourMapper.TOUR_MAPPER;
import static com.example.travel_tours.mapper.TravelerMapper.TRAVELER_MAPPER;
import static com.example.travel_tours.model.enums.ExceptionConstants.GUIDE_NOT_FOUND;
import static com.example.travel_tours.model.enums.ExceptionConstants.TOUR_NOT_FOUND;
import static com.example.travel_tours.model.enums.GuideStatus.AVAILABLE;
import static com.example.travel_tours.model.enums.GuideStatus.BUSY;

@RequiredArgsConstructor
@Service
public class TourServiceHandler implements TourService {

    private final TourRepository tourRepository;
    private final DestinationService destinationService;
    private final GuideScheduleService guideScheduleService;
    private final EntityFetchService entityFetchService;


    @Override
    public void addTour(TourRequest tourRequest) {
        tourRepository.save(TOUR_MAPPER.buildTourEntity(tourRequest));
    }

    @Override
    @Transactional
    public void addDestinationToTour(Long id,DestinationRequest destinationRequest) {
        var tour = entityFetchService.fetchTourExist(id);
        destinationService.addDestination(tour,destinationRequest);
    }


    @Override
    public void assignGuideToTour(Long id){
        var guideSchedules = guideScheduleService.getGuideSchedules();

        var guideId = guideSchedules.stream()
                .filter( g -> g.getGuideStatus().equals(AVAILABLE))
                .min(Comparator.comparing(GuideScheduleResponse::getWorkDay))
                .orElseThrow(()-> new NotFuondException(GUIDE_NOT_FOUND.getCode(),GUIDE_NOT_FOUND.getMessage())).getId();

        var tour = entityFetchService.fetchTourExist(id);
        var guideSchedule = entityFetchService.fetchGuideScheduleExist(guideId);

        guideSchedule.setWorkDay(guideSchedule.getWorkDay()+(tour.getEndDate().getTime()-tour.getStartDate().getTime())/86400000L );
        guideSchedule.setGuideStatus(BUSY);
        guideScheduleService.addGuideSchedule(guideSchedule);
        var guides = tour.getGuides();
        guides.add(entityFetchService.fetchGuideExist(guideId));
        tourRepository.save(tour);

    }

    @Override
    public List<PassportResponse> getTourGuides(Long id){

        return tourRepository.findPassportsByTourId(id)
                .stream().map(PASSPORT_MAPPER::buildPassportResponse).toList();
    }

    @Override
    public PageableTourResponse tours(PageCriteria pageCriteria, TourCriteria tourCriteria) {
        var tour = tourRepository.findAll(
                new TourSpecification(tourCriteria),
                PageRequest.of(pageCriteria.getPage(),pageCriteria.getCount(), Sort.by("id").descending())

        );
        return TOUR_MAPPER.buildPageableTourResponse(tour);

    }


    @Override
    public TourResponse getTour(Long id) {
        var tour = entityFetchService.fetchTourExist(id);
        return TOUR_MAPPER.buildTourResponse(tour);
    }

    @Override
    public List<DestinationResponse> getTourDestinations(Long id) {
        var tour = entityFetchService.fetchTourExist(id);
        return tour.getDestinations().stream().map(DESTINATION_MAPPER::buildDestinationResponse).toList();
    }

    @Override
    public List<TravelerResponse> getTourTravelers(Long id) {
        return tourRepository.findTravelersByTourId(id).stream().map(TRAVELER_MAPPER::buildTravelerResponse).toList();
    }




}
