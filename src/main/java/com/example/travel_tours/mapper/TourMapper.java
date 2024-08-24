package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.model.request.TourRequest;
import com.example.travel_tours.model.response.PageableTourResponse;
import com.example.travel_tours.model.response.TourResponse;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.Optional;

public enum TourMapper {
    TOUR_MAPPER;


    public TourEntity buildTourEntity(TourRequest tourRequest) {
        return TourEntity.builder()
                .name(tourRequest.getName())
                .description(tourRequest.getDescription())
                .price(tourRequest.getPrice())
                .startDate(tourRequest.getStartDate())
                .endDate(tourRequest.getEndDate())
                .build();
    }




    public TourResponse buildTourResponse(TourEntity tourEntity) {
        return TourResponse.builder()
                .id(tourEntity.getId())
                .name(tourEntity.getName())
                .description(tourEntity.getDescription())
                .price(tourEntity.getPrice())
                .startDate(tourEntity.getStartDate())
                .endDate(tourEntity.getEndDate())
                .build();
    }

    public PageableTourResponse buildPageableTourResponse(Page<TourEntity> tourEntityPage) {
        return PageableTourResponse.builder().tours(Collections.singletonList(tourEntityPage.map(a->TOUR_MAPPER.buildTourResponse(a)).stream().toList()))
                .hasNextPage(tourEntityPage.hasNext())
                .lastPageNumber(tourEntityPage.getTotalPages())
                .totalElements(tourEntityPage.getNumberOfElements())
                .build();
    }


}
