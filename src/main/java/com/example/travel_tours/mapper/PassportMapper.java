package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.PassportEntity;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.model.response.PassportResponse;

public enum PassportMapper {

    PASSPORT_MAPPER;


    public PassportEntity buildPassportEntity(PassportRequest passportRequest) {
        return PassportEntity.builder()
                .passportNumber(passportRequest.getPassportNumber())
                .expiryDate(passportRequest.getExpiryDate())
                .issueDate(passportRequest.getIssueDate())
                .build();
    }

    public PassportResponse buildPassportResponse(PassportEntity passportEntity) {
        return PassportResponse.builder()
                .id(passportEntity.getId())
                .passportNumber(passportEntity.getPassportNumber())
                .expiryDate(passportEntity.getExpiryDate())
                .issueDate(passportEntity.getIssueDate())
                .build();
    }

    public PassportEntity updatePassport(PassportEntity passportEntity,PassportRequest passportRequest) {
        return PassportEntity.builder()
                .guide(passportEntity.getGuide())
                .id(passportEntity.getId())
                .passportNumber(passportRequest.getPassportNumber())
                .expiryDate(passportRequest.getExpiryDate())
                .issueDate(passportRequest.getIssueDate())
                .build();
    }




}
