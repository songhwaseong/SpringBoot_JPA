package com.study.develop.repository;

import com.study.develop.entity.Customer;
import com.study.develop.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
