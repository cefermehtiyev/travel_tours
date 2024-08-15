package com.example.travel_tours.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guides")
@Builder
@Entity
public class GuideEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuideEntity guide = (GuideEntity) o;
        return id == guide.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
