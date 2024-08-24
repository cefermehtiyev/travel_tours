package com.example.travel_tours.controller;

import com.example.travel_tours.model.criteria.PageCriteria;
import com.example.travel_tours.model.criteria.TourCriteria;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.model.request.TourRequest;
import com.example.travel_tours.model.request.TravelerRequest;
import com.example.travel_tours.model.response.DestinationResponse;
import com.example.travel_tours.model.response.GuideResponse;
import com.example.travel_tours.model.response.PageableTourResponse;
import com.example.travel_tours.model.response.PassportResponse;
import com.example.travel_tours.model.response.TravelerResponse;
import com.example.travel_tours.service.abstraction.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/tour")
public class TourController {

    private final TourService tourService;

    @PostMapping
    public  void addTour(@RequestBody TourRequest tourRequest) {
        tourService.addTour(tourRequest);

    }


    @PostMapping("/destination/{id}")
    public void addTourDestination(@PathVariable Long id,@RequestBody DestinationRequest destinationRequest) {
        tourService.addDestinationToTour(id,destinationRequest);

    }

    @GetMapping("/get-destination/{id}")
    public List<DestinationResponse> getTourDestination(@PathVariable Long id){
        return tourService.getTourDestinations(id);
    }



    @PostMapping("/assign-guide/{id}")
    public void assignGuideToTour(@PathVariable Long id){
        tourService.assignGuideToTour(id);
    }
    @GetMapping("/get-guides/{id}")
    public List<PassportResponse> getTourGuides(@PathVariable Long id){
        return tourService.getTourGuides(id);
    }

    @GetMapping
    public PageableTourResponse getTours(PageCriteria pageCriteria, TourCriteria tourCriteria){
        return tourService.tours(pageCriteria,tourCriteria);
    }





    @GetMapping("/get-traveler/{id}")
    public List<TravelerResponse> getTourTraveler(@PathVariable Long id){
        return tourService.getTourTravelers(id);
    }







}
