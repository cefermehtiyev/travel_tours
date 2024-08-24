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
public class DestinationResponse {
    private Long id;
    private String location;
    private String description;
    private Date visitDate;
}
