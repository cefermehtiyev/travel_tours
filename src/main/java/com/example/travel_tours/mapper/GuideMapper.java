package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.dao.entity.PassportEntity;
import com.example.travel_tours.model.request.GuideRequest;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.model.response.GuideResponse;

public enum GuideMapper {
    GUIDE_MAPPER;

    public GuideEntity buildGuideEntity(GuideRequest guideRequest) {
        return GuideEntity.builder()
                .name(guideRequest.getName())
                .email(guideRequest.getEmail())
                .phoneNumber(guideRequest.getPhoneNumber())
                .build();

    }

    public GuideResponse buildGuideResponse(GuideEntity guideEntity) {
        return GuideResponse.builder()
                .id(guideEntity.getId())
                .name(guideEntity.getName())
                .email(guideEntity.getEmail())
                .phoneNumber(guideEntity.getPhoneNumber())
                .build();

    }


}
