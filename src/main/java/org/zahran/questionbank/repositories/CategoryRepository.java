package org.zahran.questionbank.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.zahran.questionbank.entities.Category;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {

//    public Page<Category> findAll(Specification<Category> spec, Pageable pageable);
//    public List<Category> findAll(Specification<Category> spec);
    public Page<Category> findByNameContaining(String name, Pageable pageable);
//    public Page<Category> findByCreatedAtBetween(LocalDateTime from,LocalDateTime to,Pageable pageable);
}
