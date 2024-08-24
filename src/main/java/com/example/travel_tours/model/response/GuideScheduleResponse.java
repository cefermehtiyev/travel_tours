package com.example.travel_tours.model.response;

import com.example.travel_tours.model.enums.GuideStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideScheduleResponse {
    Long id;
    GuideStatus guideStatus;
    Long workDay;
}
