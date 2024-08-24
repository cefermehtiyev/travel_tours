package com.example.travel_tours.mapper;

import com.example.travel_tours.dao.entity.GuideScheduleEntity;
import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.request.GuideScheduleRequest;
import com.example.travel_tours.model.response.GuideScheduleResponse;

import static com.example.travel_tours.model.enums.GuideStatus.AVAILABLE;

public enum GuideScheduleMapper {
    GUIDE_SCHEDULE_MAPPER;


    public GuideScheduleEntity buildGuideScheduleEntity( ) {
        return GuideScheduleEntity.builder()
                .guideStatus(AVAILABLE)
                .workDay(0l)
                .build();
    }

    public GuideScheduleResponse buildGuideScheduleResponse(GuideScheduleEntity guideScheduleEntity) {
        return GuideScheduleResponse.builder()
                .id(guideScheduleEntity.getId())
                .guideStatus(guideScheduleEntity.getGuideStatus())
                .workDay(guideScheduleEntity.getWorkDay())
                .build();
    }


}
