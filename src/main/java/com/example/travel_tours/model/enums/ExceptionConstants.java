package com.example.travel_tours.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION","Unexpected Exception"),
    TOUR_NOT_FOUND("TOUR_NOT_FOUND","TOUR Not Found"),
    DESTINATION_NOT_FOUND("DESTINATION_NOT_FOUND","Destination Not Found"),
    GUIDE_NOT_FOUND("GUIDE_NOT_FOUND","Guide Not Found"),
    PASSPORT_NOT_FOUND("PASSPORT_NOT_FOUND","Passport Not Found"),
    TRAVELER_NOT_FOUND("TRAVELER_NOT_FOUND","Traveler Not Found"),;

    String code;
    String message;
}
