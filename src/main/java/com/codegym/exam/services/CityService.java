package com.codegym.exam.services;

import com.codegym.exam.model.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City findById(long id);
    void save(City city);
    void remove(Long id);
}
