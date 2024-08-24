package com.example.travel_tours.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuideResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
