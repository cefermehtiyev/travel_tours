package com.example.travel_tours.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassportResponse {
    private Long id;
    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
}
