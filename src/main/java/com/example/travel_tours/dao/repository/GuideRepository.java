package com.example.travel_tours.dao.repository;


import com.example.travel_tours.dao.entity.GuideEntity;
import com.example.travel_tours.model.enums.GuideStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GuideRepository extends JpaRepository<GuideEntity,Long> {

    @Override
    @EntityGraph(attributePaths = {"passport","schedule"})
    Optional<GuideEntity> findById(Long id);

    @EntityGraph(attributePaths = {"passport","schedule"})
    @Override
    List<GuideEntity> findAll();

    @Query("SELECT g  FROM GuideScheduleEntity gs Join gs.guide g   where gs.guideStatus = :status")
    List<GuideEntity> findGuidesByStatus(GuideStatus status);
}
