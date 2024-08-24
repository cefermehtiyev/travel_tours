package com.example.travel_tours.service.concurate;

import com.example.travel_tours.dao.entity.GuideScheduleEntity;
import com.example.travel_tours.dao.repository.GuideScheduleRepository;
import com.example.travel_tours.mapper.GuideScheduleMapper;
import com.example.travel_tours.model.response.GuideScheduleResponse;
import com.example.travel_tours.service.abstraction.GuideScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.travel_tours.mapper.GuideScheduleMapper.GUIDE_SCHEDULE_MAPPER;

@RequiredArgsConstructor
@Service
public class GuideScheduleServiceHandler implements GuideScheduleService {
    private final GuideScheduleRepository guideScheduleRepository;


    @Override
    public List<GuideScheduleResponse> getGuideSchedules() {
        return guideScheduleRepository.findAll()
                .stream()
                .map(GUIDE_SCHEDULE_MAPPER::buildGuideScheduleResponse)
                .toList();
    }
    @Override
    public void addGuideSchedule(GuideScheduleEntity guideScheduleEntity) {
        guideScheduleRepository.save(guideScheduleEntity);
    }


}
