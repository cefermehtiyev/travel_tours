package com.example.travel_tours.dao.repository;

import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.dao.entity.PassportEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.dao.entity.TravelerEntity;
import com.example.travel_tours.model.enums.GuideStatus;
import com.example.travel_tours.model.response.PassportResponse;
import com.example.travel_tours.service.specification.TourSpecification;
import jakarta.persistence.Entity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.swing.plaf.LabelUI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<TourEntity, Long>, JpaSpecificationExecutor<TourEntity> {

    @EntityGraph(attributePaths = {"destinations","travelers","guides"})
    @Override
    Optional<TourEntity> findById(Long id);

    @Query("SELECT p FROM TourEntity t JOIN  t.guides g JOIN  g.passport p WHERE t.id = :tourId")
    List<PassportEntity> findPassportsByTourId(Long tourId);

    @Query("SELECT tr  FROM TourEntity t JOIN  t.travelers tr  WHERE t.id = :tourId")
    List<TravelerEntity> findTravelersByTourId(Long tourId);








}
