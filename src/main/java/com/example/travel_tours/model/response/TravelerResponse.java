package com.example.travel_tours.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
