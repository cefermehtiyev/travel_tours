package com.example.travel_tours.dao.repository;

import com.example.travel_tours.dao.entity.GuideScheduleEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuideScheduleRepository extends JpaRepository<GuideScheduleEntity,Long> {

    @EntityGraph(attributePaths = {"guide"})
    @Override
    List<GuideScheduleEntity> findAll();

    @EntityGraph(attributePaths = {"guide",})
    @Override
    Optional<GuideScheduleEntity> findById(Long id);
}
