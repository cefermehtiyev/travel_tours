package com.example.travel_tours.service.concurate;

import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.repository.GuideRepository;
import com.example.travel_tours.dao.repository.PassportRepository;
import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.request.GuideRequest;
import com.example.travel_tours.model.request.PassportRequest;
import com.example.travel_tours.model.response.GuideResponse;
import com.example.travel_tours.service.EntityFetchService;
import com.example.travel_tours.service.abstraction.GuideService;
import com.example.travel_tours.service.abstraction.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.example.travel_tours.mapper.GuideMapper.GUIDE_MAPPER;
import static com.example.travel_tours.mapper.PassportMapper.PASSPORT_MAPPER;
import static com.example.travel_tours.model.enums.GuideStatus.AVAILABLE;
import static com.example.travel_tours.model.enums.GuideStatus.BUSY;

@RequiredArgsConstructor
@Service
public class GuideServiceHandler implements GuideService {

    private final GuideRepository guideRepository;
    private final PassportRepository passportRepository;
    private final EntityFetchService entityFetchService;
    private final PassportService passportService;




    @Override
    @Transactional
    public void addGuide(GuideRequest guideRequest) {
        var guide = GUIDE_MAPPER.buildGuideEntity(guideRequest);
        guideRepository.save(guide);
        passportService.saveGuidePassport(guide,guideRequest.getPassportRequest());

    }


    public void updateGuidePassport(Long id, PassportRequest passportRequest) {
        var guide = entityFetchService.fetchGuideExist(id);
        var passport = guide.getPassport();
        var updatePassport = PASSPORT_MAPPER.updatePassport(passport,passportRequest);
        passportRepository.save(updatePassport);

    }

    @Override
    public GuideResponse getGuide(Long id) {
        var guide = entityFetchService.fetchGuideExist(id);
        return GUIDE_MAPPER.buildGuideResponse(guide);
    }

    @Override
    public List<GuideResponse> getAllGuide() {
        return guideRepository.findAll().stream().map(GUIDE_MAPPER::buildGuideResponse).toList();
    }

    public List<GuideResponse> searchGuide(GuideStatus guideStatus) {

        var guide  = guideRepository.findGuidesByStatus(guideStatus);

        return guide.stream().map(GUIDE_MAPPER::buildGuideResponse).toList();


    }
    @Override
    @Transactional
    public void updateGuideStatus(){
        var guides = guideRepository.findAll();

        Date currentDate  = new Date();
        System.out.println(currentDate);

        guides.stream().forEach(guide -> {
            if(guide.getTours()!=null){
                boolean isAvailable = guide.getTours().stream().allMatch(
                        tourEntity -> tourEntity.getEndDate().before(currentDate)
                );
                guide.getSchedule().setGuideStatus(isAvailable ? AVAILABLE : BUSY );
            }

        });








    }





}
