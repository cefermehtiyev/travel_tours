package com.example.travel_tours.model.criteria;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageCriteria {
    @JsonInclude(USE_DEFAULTS)
    private Integer page;

    @JsonInclude(USE_DEFAULTS)
    private Integer count;


}
