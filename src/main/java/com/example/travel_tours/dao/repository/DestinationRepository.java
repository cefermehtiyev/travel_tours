package com.example.travel_tours.dao.repository;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.model.response.DestinationResponse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {



}
