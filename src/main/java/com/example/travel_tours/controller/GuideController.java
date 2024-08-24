package com.example.travel_tours.controller;

import com.example.travel_tours.dao.repository.GuideRepository;
import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.request.GuideRequest;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.model.response.GuideResponse;
import com.example.travel_tours.service.abstraction.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/guide")
public class GuideController {
    private final GuideService guideService;


    @PostMapping
    @ResponseStatus(CREATED)
    public void addGuide(@RequestBody GuideRequest guideRequest){
        guideService.addGuide(guideRequest);

    }
    @GetMapping("{id}")
    public GuideResponse getGuide(@PathVariable Long id){
        return guideService.getGuide(id);
    }
    @GetMapping
    public List<GuideResponse> getAllGuide(){
        return guideService.getAllGuide();
    }

    @GetMapping("/status")
    public List<GuideResponse> gelAllGuideByStatus(@RequestParam GuideStatus guideStatus){
        return guideService.searchGuide(guideStatus);
    }



    @PutMapping("/update-passport/{id}")
    public void updateGuidePassport(@PathVariable Long id,@RequestBody PassportRequest passportRequest){
        guideService.updateGuidePassport(id,passportRequest);
    }




}
