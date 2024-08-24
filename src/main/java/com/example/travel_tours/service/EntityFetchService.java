package com.example.travel_tours.service;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.dao.entity.GuideScheduleEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.entity.TravelerEntity;
import com.example.travel_tours.dao.repository.DestinationRepository;
import com.example.travel_tours.dao.repository.GuideRepository;
import com.example.travel_tours.dao.repository.GuideScheduleRepository;
import com.example.travel_tours.dao.repository.TourRepository;
import com.example.travel_tours.dao.repository.TravelerRepository;
import com.example.travel_tours.exception.NotFuondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.travel_tours.model.enums.ExceptionConstants.DESTINATION_NOT_FOUND;
import static com.example.travel_tours.model.enums.ExceptionConstants.GUIDE_NOT_FOUND;
import static com.example.travel_tours.model.enums.ExceptionConstants.TOUR_NOT_FOUND;
import static com.example.travel_tours.model.enums.ExceptionConstants.TRAVELER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class EntityFetchService {
    private final TourRepository tourRepository;
    private final GuideRepository guideRepository;
    private final GuideScheduleRepository guideScheduleRepository;
    private final TravelerRepository travelerRepository;
    private final DestinationRepository destinationRepository;

    public TourEntity fetchTourExist(Long id) {
        return tourRepository.findById(id).orElseThrow(
                () -> new NotFuondException(TOUR_NOT_FOUND.getCode(), TOUR_NOT_FOUND.getMessage())
        );
    }
    public GuideEntity fetchGuideExist(Long id) {
        return guideRepository.findById(id).orElseThrow(
                ()->new NotFuondException(GUIDE_NOT_FOUND.getCode(), GUIDE_NOT_FOUND.getMessage())
        );
    }
    public GuideScheduleEntity fetchGuideScheduleExist(Long id) {
        return guideScheduleRepository.findById(id).orElseThrow(
                ()->new NotFuondException(GUIDE_NOT_FOUND.getCode(), GUIDE_NOT_FOUND.getMessage())
        );
    }
    public TravelerEntity fetchTravelerExist(Long id) {
        return travelerRepository.findById(id).orElseThrow(
                ()->new NotFuondException(TRAVELER_NOT_FOUND.getCode(),TRAVELER_NOT_FOUND.getMessage())
        );
    }
    public DestinationEntity fetchDestinationExist(Long id) {
        return destinationRepository.findById(id).orElseThrow(
                ()-> new NotFuondException(DESTINATION_NOT_FOUND.getCode(), DESTINATION_NOT_FOUND.getMessage() )
        );
    }

}
