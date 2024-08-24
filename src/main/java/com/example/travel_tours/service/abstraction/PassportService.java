package com.example.travel_tours.service.abstraction;

import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.model.request.PassportRequest;

public interface PassportService {
    void saveGuidePassport(GuideEntity guide, PassportRequest passportRequest);

}
