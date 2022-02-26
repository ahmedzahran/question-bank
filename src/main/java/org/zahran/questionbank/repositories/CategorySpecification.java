package org.zahran.questionbank.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.zahran.questionbank.entities.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.function.Predicate;

public class CategorySpecification {

    public static Specification<Category> nameLike(String name) {

        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("name"),"%"+name+"%");

//        return (root, query, criteriaBuilder)->{
//            return criteriaBuilder.like(root.get("name"), "%"+name+"%");
//        };

//        return (root, query, cb) -> {
//            return cb.like(root.get("name"), "%" + name + "%");
//        };
    }

    public static Specification<Category> fromDate(String from){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime fromDate = LocalDate.parse(from,dateTimeFormatter).atStartOfDay();

        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"),fromDate);
    }

}
