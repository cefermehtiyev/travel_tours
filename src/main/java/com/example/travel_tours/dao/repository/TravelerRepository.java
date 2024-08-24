package com.example.travel_tours.dao.repository;

import com.example.travel_tours.dao.entity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<TravelerEntity,Long> {

}
