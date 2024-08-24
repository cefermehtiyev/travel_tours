package com.example.travel_tours.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travelers")
@Builder
@Entity
public class TravelerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "tour_traveler",
            joinColumns = @JoinColumn(name = "traveler_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    List<TourEntity> tours;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelerEntity traveler = (TravelerEntity) o;
        return Objects.equals(id, traveler.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
