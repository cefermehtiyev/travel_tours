package com.example.travel_tours.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableTourResponse <T>{
    private List<T> tours;
    private Integer lastPageNumber;
    private Integer totalElements;
    private boolean hasNextPage;
}
