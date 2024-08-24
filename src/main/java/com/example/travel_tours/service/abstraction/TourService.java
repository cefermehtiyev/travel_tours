package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.model.criteria.PageCriteria;
import com.example.travel_tours.model.criteria.TourCriteria;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.model.request.TourRequest;
import com.example.travel_tours.model.request.TravelerRequest;
import com.example.travel_tours.model.response.DestinationResponse;
import com.example.travel_tours.model.response.GuideResponse;
import com.example.travel_tours.model.response.PageableTourResponse;
import com.example.travel_tours.model.response.PassportResponse;
import com.example.travel_tours.model.response.TourResponse;
import com.example.travel_tours.model.response.TravelerResponse;

import java.util.List;

public interface TourService {
    void addTour(TourRequest tourRequest);
    TourResponse getTour(Long id);
    List<DestinationResponse> getTourDestinations(Long id);
    List<TravelerResponse> getTourTravelers(Long id);
    void addDestinationToTour(Long id,DestinationRequest destinationRequest);
    void assignGuideToTour(Long id);
    List<PassportResponse> getTourGuides(Long id);
    PageableTourResponse tours(PageCriteria pageCriteria, TourCriteria tourCriteria);

}
