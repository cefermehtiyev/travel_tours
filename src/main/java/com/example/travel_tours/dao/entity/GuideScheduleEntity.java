package com.example.travel_tours.dao.entity;

import com.example.travel_tours.model.enums.GuideStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guide_schedule")
@Builder
@Entity
public class GuideScheduleEntity {
    @Id
    Long id;

    @Enumerated(STRING)
    GuideStatus guideStatus;
    Long workDay;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    GuideEntity guide;






}
