package ru.dronix.managedstores.service;

import ru.dronix.managedstores.models.City;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface CityService {

    List<City> findAll();

    City getOne(Long id);

    void create(City city);

    void update(City city);

    void remove(City city);

    City findByName(String name);

}
