package com.example.travel_tours.service.concurate;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.repository.DestinationRepository;
import com.example.travel_tours.dao.repository.TourRepository;
import com.example.travel_tours.exception.NotFuondException;
import com.example.travel_tours.mapper.TourMapper;
import com.example.travel_tours.model.enums.ExceptionConstants;
import com.example.travel_tours.model.request.DestinationRequest;
import com.example.travel_tours.service.EntityFetchService;
import com.example.travel_tours.service.abstraction.DestinationService;
import com.example.travel_tours.service.abstraction.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.travel_tours.mapper.DestinationMapper.DESTINATION_MAPPER;
import static com.example.travel_tours.model.enums.ExceptionConstants.DESTINATION_NOT_FOUND;
import static com.example.travel_tours.model.enums.ExceptionConstants.TOUR_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class DestinationServiceHandler  implements DestinationService {
    private final DestinationRepository destinationRepository;
    private final EntityFetchService entityFetchService;



    @Override
    public void addDestination(TourEntity tourEntity,DestinationRequest destinationRequest) {
        var destination = DESTINATION_MAPPER.buildDestinationEntity(destinationRequest);
        destination.setTour(tourEntity);
        destinationRepository.save(destination);
    }

    @Override
    public void updateDestination(Long id,DestinationRequest destinationRequest) {
        var destination = entityFetchService.fetchDestinationExist(id);
        var updateDestination = DESTINATION_MAPPER.updateDestination(destination,destinationRequest);
        destinationRepository.save(updateDestination);
    }


}
