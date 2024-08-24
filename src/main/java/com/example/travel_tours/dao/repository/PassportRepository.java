package com.example.travel_tours.dao.repository;

import com.example.travel_tours.dao.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportEntity,Long> {
}
