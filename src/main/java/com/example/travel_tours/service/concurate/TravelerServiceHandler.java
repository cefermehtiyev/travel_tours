package com.example.travel_tours.service.concurate;

import com.example.travel_tours.dao.repository.TourRepository;
import com.example.travel_tours.dao.repository.TravelerRepository;
import com.example.travel_tours.model.request.TravelerRequest;
import com.example.travel_tours.service.EntityFetchService;
import com.example.travel_tours.service.abstraction.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.travel_tours.mapper.TravelerMapper.TRAVELER_MAPPER;

@RequiredArgsConstructor
@Service
public class TravelerServiceHandler implements TravelerService {
    private final TravelerRepository travelerRepository;
    private final TourRepository tourRepository;
    private final EntityFetchService entityFetchService;




    @Override
    public void updateTraveler(Long id, TravelerRequest travelerRequest) {
        var traveler = entityFetchService.fetchTravelerExist(id);
        var updateTraveler = TRAVELER_MAPPER.updateTraveler(traveler, travelerRequest);
        travelerRepository.save(updateTraveler);

    }

    public void addTraveler(TravelerRequest travelerRequest) {
        travelerRepository.save(TRAVELER_MAPPER.buildTravelerEntity(travelerRequest));
    }

    public void addTravelerToTour(Long tourId,Long travelerId){
        var tour = entityFetchService.fetchTourExist(tourId);
        var traveler = entityFetchService.fetchTravelerExist(travelerId);
        var allTourTravelers = tour.getTravelers();
        allTourTravelers.add(traveler);
        tour.setTravelers(allTourTravelers);
        tourRepository.save(tour);

    }





}
