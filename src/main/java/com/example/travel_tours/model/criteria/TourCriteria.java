package com.example.travel_tours.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourCriteria {

    private String name;
    private String description;
    private Integer priceFrom;
    private Integer priceTo;
    private Date startDate;
    private Date endDate;

}
