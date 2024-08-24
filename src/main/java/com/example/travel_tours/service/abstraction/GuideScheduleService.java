package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.dao.entity.GuideScheduleEntity;
import com.example.travel_tours.model.response.GuideScheduleResponse;

import java.util.List;

public interface GuideScheduleService {

    List<GuideScheduleResponse> getGuideSchedules();
    void addGuideSchedule(GuideScheduleEntity guideSchedule);
}
