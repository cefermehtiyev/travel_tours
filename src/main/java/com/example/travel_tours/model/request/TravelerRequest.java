package com.example.travel_tours.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelerRequest {
    private String firstName;
    private String lastName;
    private String email;
}
