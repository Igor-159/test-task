package com.example.demo.repository.specification;

import com.example.demo.model.Job;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import jakarta.persistence.criteria.Predicate;

@AllArgsConstructor
public class JobByTimeFrom implements Specification<Job> {

    private final LocalDateTime timeFrom;

    @Override
    public Predicate toPredicate(final Root<Job> root,
                                 final CriteriaQuery<?> criteriaQuery,
                                 final CriteriaBuilder criteriaBuilder) {

        if(timeFrom == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.greaterThanOrEqualTo(root.get("time"), this.timeFrom);
    }

}
