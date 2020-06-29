package com.codegym.exam.services;

import com.codegym.exam.model.City;
import com.codegym.exam.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Value("1")
    private int statusExist;

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new LinkedList<>();
        Iterable<City> customerIterable = cityRepository.findAll();
        for (City city : customerIterable){
            cities.add(city);
        }
        return cities;
    }

    @Override
    public City findById(long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
