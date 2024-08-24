package com.example.travel_tours.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationRequest {
    private String location;
    private String description;
    private Date visitDate;
}
