package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.model.response.DestinationResponse;

import java.util.List;

public interface DestinationService {

    void addDestination(TourEntity tourEntitya,DestinationRequest destinationRequest);
    void updateDestination(Long id,DestinationRequest destinationRequest);



}
