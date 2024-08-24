package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.repository.DestinationRepository;
import com.example.travel_tours.dao.repository.TourRepository;
import com.example.travel_tours.exception.NotFuondException;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.model.response.DestinationResponse;
import com.example.travel_tours.service.abstraction.TourService;
import com.example.travel_tours.service.concurate.TourServiceHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.print.attribute.standard.Destination;

import java.util.List;

import static com.example.travel_tours.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

public enum DestinationMapper {
    DESTINATION_MAPPER;





    public DestinationEntity buildDestinationEntity(DestinationRequest destinationRequest) {
        return DestinationEntity.builder()
                .location(destinationRequest.getLocation())
                .description(destinationRequest.getDescription())
                .visitDate(destinationRequest.getVisitDate())
                .build();


    }



    public DestinationResponse buildDestinationResponse(DestinationEntity destinationEntity) {
        return DestinationResponse.builder()
                .id(destinationEntity.getId())
                .location(destinationEntity.getLocation())
                .description(destinationEntity.getDescription())
                .visitDate(destinationEntity.getVisitDate())
                .build();
    }

    public DestinationEntity updateDestination(DestinationEntity destinationEntity,DestinationRequest destinationRequest) {
        return DestinationEntity.builder()
                .tour(destinationEntity.getTour())
                .id(destinationEntity.getId())
                .location(destinationRequest.getLocation())
                .description(destinationRequest.getDescription())
                .visitDate(destinationRequest.getVisitDate())
                .build();
    }





}
