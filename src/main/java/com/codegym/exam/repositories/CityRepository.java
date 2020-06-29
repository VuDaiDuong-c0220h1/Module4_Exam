package com.codegym.exam.repositories;

import com.codegym.exam.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    City findById(long id);
}
