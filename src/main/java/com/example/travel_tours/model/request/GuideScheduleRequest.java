package com.example.travel_tours.model.request;

import com.example.travel_tours.model.enums.GuideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuideScheduleRequest {

    GuideStatus guideStatus;
    Long workDay;
}
