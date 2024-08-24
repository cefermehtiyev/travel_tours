package com.example.travel_tours.controller;

import com.example.travel_tours.model.request.TravelerRequest;
import com.example.travel_tours.service.abstraction.TourService;
import com.example.travel_tours.service.abstraction.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/traveler")
public class TravelerController {
    private final TravelerService travelerService;

    @PutMapping("/update/{id}")
    public void updateTraveler(@PathVariable Long id, @RequestBody TravelerRequest travelerRequest){
        travelerService.updateTraveler(id, travelerRequest);
    }

    @PostMapping
    public void addTraveler(@RequestBody TravelerRequest travelerRequest){
        travelerService.addTraveler(travelerRequest);
    }

    @PostMapping(("{tourId}/{travelerId}"))
    public void addTravelerToTour(@PathVariable Long tourId,@PathVariable Long travelerId){
        travelerService.addTravelerToTour(tourId, travelerId);
    }

}
