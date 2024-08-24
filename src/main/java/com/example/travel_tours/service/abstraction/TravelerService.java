package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.entity.TravelerEntity;
import com.example.travel_tours.model.request.TravelerRequest;

public interface TravelerService {
    void addTraveler(TravelerRequest travelerRequest);
    void addTravelerToTour(Long tourId,Long travelerId);
    void updateTraveler(Long id, TravelerRequest travelerRequest);

}
