package com.example.travel_tours.service.specification;

import com.example.travel_tours.dao.entity.DestinationEntity;
import com.example.travel_tours.dao.entity.TourEntity;
import com.example.travel_tours.model.constants.TourConstants;
import com.example.travel_tours.model.criteria.TourCriteria;
import com.example.travel_tours.pradicateUtil.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.example.travel_tours.model.constants.TourConstants.DESCRIPTION;
import static com.example.travel_tours.model.constants.TourConstants.END_DATE;
import static com.example.travel_tours.model.constants.TourConstants.NAME;
import static com.example.travel_tours.model.constants.TourConstants.PRICE;

import static com.example.travel_tours.model.constants.TourConstants.START_DATE;
import static com.example.travel_tours.pradicateUtil.PredicateUtil.applyLikePattern;


@AllArgsConstructor
public class TourSpecification implements Specification<TourEntity> {

    private  TourCriteria tourCriteria;




    public Predicate toPredicate(Root<TourEntity> root,
                                 CriteriaQuery<?>query,
                                 CriteriaBuilder cb) {


        var predicates = PredicateUtil.builder().
                addNullSafety(tourCriteria.getName(),
                name -> cb.like(root.get(NAME),applyLikePattern(name))
                )
                .addNullSafety(tourCriteria.getDescription(),
                description-> cb.like(root.get(DESCRIPTION),applyLikePattern(description))
                )
                .addNullSafety(tourCriteria.getPriceFrom(),
                priceFrom-> cb.greaterThanOrEqualTo(root.get(PRICE),priceFrom)
                )
                .addNullSafety(tourCriteria.getPriceTo(),
                        priceTo-> cb.lessThanOrEqualTo(root.get(PRICE),priceTo)
                )
                .addNullSafety(tourCriteria.getStartDate(),
                        startDate-> cb.greaterThanOrEqualTo(root.get(START_DATE),startDate)
                )
                .addNullSafety(tourCriteria.getEndDate(),
                        endDate-> cb.lessThanOrEqualTo(root.get(END_DATE),endDate)
                ).build();

        return cb.and(predicates);




    }



}
