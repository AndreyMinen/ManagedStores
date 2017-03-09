package ru.dronix.managedstores.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dronix.managedstores.models.City;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Repository
public interface CityDao extends CrudRepository<City,Long> {

    List<City> findAll();
    City findOne(Long id);

}
