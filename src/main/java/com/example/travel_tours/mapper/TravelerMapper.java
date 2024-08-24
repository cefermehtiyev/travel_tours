package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.TravelerEntity;
import com.example.travel_tours.model.request.TravelerRequest;
import com.example.travel_tours.model.response.TravelerResponse;

public enum TravelerMapper {
    TRAVELER_MAPPER;

    public TravelerEntity buildTravelerEntity(TravelerRequest travelerRequest) {
        return TravelerEntity.builder()
                .firstName(travelerRequest.getFirstName())
                .lastName(travelerRequest.getLastName())
                .email(travelerRequest.getEmail())
                .build();
    }

    public TravelerResponse buildTravelerResponse(TravelerEntity travelerEntity) {
        return TravelerResponse.builder()
                .id(travelerEntity.getId())
                .firstName(travelerEntity.getFirstName())
                .lastName(travelerEntity.getLastName())
                .email(travelerEntity.getEmail())
                .build();
    }



    public TravelerEntity updateTraveler(TravelerEntity travelerEntity,TravelerRequest travelerRequest) {
         return TravelerEntity.builder()
                 .tours(travelerEntity.getTours())
                 .id(travelerEntity.getId())
                .firstName(travelerRequest.getFirstName())
                .lastName(travelerRequest.getLastName())
                .email(travelerRequest.getEmail())
                .build();
    }
}
