package com.example.demo.repository.specification;

import com.example.demo.model.Job;
import com.example.demo.model.JobType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class JobByType implements Specification<Job> {

    private final String type;

    @Override
    public Predicate toPredicate(final Root<Job> root,
                                 final CriteriaQuery<?> criteriaQuery,
                                 final CriteriaBuilder criteriaBuilder) {

        final JobType jobTypeEnumValue = JobType.getByValue(this.type);
        if(this.type != null && jobTypeEnumValue == null) {
            return criteriaBuilder.isFalse(criteriaBuilder.literal(true));
        }

        if (type == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.equal(root.get("type"), jobTypeEnumValue);

    }
}
