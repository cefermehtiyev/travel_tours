package com.example.travel_tours.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private PassportRequest passportRequest;
}
