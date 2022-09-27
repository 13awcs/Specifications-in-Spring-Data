package com.example.InspectionsDemo;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InspectionSpecification implements Specification<Inspection> {
    private SearchCriteria criteria;

    public InspectionSpecification() {
    }

    public InspectionSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Inspection> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            if (root.get(criteria.getKey()).getJavaType() == LocalDate.class) {
                LocalDate date = LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                return builder.greaterThan(root.get(criteria.getKey()), date);
            }else if(root.get(criteria.getKey()).getJavaType() == Integer.class){
                return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            }
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            if (root.get(criteria.getKey()).getJavaType() == LocalDate.class) {
                LocalDate date = LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                return builder.lessThan(root.get(criteria.getKey()), date);
            }else if(root.get(criteria.getKey()).getJavaType() == Integer.class){
                return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            }
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}
