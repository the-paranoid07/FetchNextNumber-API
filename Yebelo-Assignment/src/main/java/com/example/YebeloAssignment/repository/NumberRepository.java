package com.example.YebeloAssignment.repository;

import com.example.YebeloAssignment.model.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity,Integer> {
    NumberEntity findByCategoryCode(String categoryCode);
}
