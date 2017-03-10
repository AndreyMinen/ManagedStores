package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.managedstores.dao.CityDao;
import ru.dronix.managedstores.models.City;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    @Transactional
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    @Transactional
    public City getOne(Long id) {
        return cityDao.getOne(id);
    }

    @Override
    @Transactional
    public void create(City city) {
        cityDao.saveAndFlush(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        cityDao.saveAndFlush(city);
    }

    @Override
    @Transactional
    public void remove(City city) {
        cityDao.delete(city);
    }

    @Override
    @Transactional
    public City findByName(String name) {
        return cityDao.findByName(name);
    }
}
