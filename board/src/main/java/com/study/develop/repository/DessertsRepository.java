package com.study.develop.repository;

import com.study.develop.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertsRepository extends JpaRepository<Dessert, Integer> {
}
