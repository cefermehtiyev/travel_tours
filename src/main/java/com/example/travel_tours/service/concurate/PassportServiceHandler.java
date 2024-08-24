package com.example.travel_tours.service.concurate;


import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.dao.repository.GuideScheduleRepository;
import com.example.travel_tours.dao.repository.PassportRepository;
import com.example.travel_tours.mapper.PassportMapper;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.service.EntityFetchService;
import com.example.travel_tours.service.abstraction.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.travel_tours.mapper.GuideScheduleMapper.GUIDE_SCHEDULE_MAPPER;
import static com.example.travel_tours.mapper.PassportMapper.PASSPORT_MAPPER;


@RequiredArgsConstructor
@Service
public class PassportServiceHandler implements PassportService {

    private final GuideScheduleRepository guideScheduleRepository;
    private final PassportRepository passportRepository;

    @Override
    @Transactional
    public void saveGuidePassport(GuideEntity guide, PassportRequest passportRequest) {
        var passport = PASSPORT_MAPPER.buildPassportEntity(passportRequest);

        var guideSchedule = GUIDE_SCHEDULE_MAPPER.buildGuideScheduleEntity();
        passport.setGuide(guide);
        guideSchedule.setGuide(guide);
        guideScheduleRepository.save(guideSchedule);

        passportRepository.save(passport);



    }





}
