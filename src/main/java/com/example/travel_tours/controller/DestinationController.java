package com.example.travel_tours.controller;

import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.service.abstraction.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/destination")
public class DestinationController {
    private final DestinationService destinationService;

    @PutMapping("/update/{id}")
    public void updateDestination(@PathVariable Long id,@RequestBody DestinationRequest destinationRequest) {
        destinationService.updateDestination(id, destinationRequest);
    }



}
