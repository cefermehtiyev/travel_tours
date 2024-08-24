package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.request.GuideRequest;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.model.response.GuideResponse;

import java.util.List;

public interface GuideService {
    void addGuide(GuideRequest guideRequest);
    GuideResponse getGuide(Long id);
    List<GuideResponse> getAllGuide();
    void updateGuidePassport(Long id, PassportRequest passportRequest);
    List<GuideResponse> searchGuide(GuideStatus guideStatus);
    void updateGuideStatus();
}
