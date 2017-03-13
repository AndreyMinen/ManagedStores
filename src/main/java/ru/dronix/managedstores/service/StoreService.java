package ru.dronix.managedstores.service;

import ru.dronix.managedstores.models.City;
import ru.dronix.managedstores.models.Seller;
import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface StoreService {

    List<Store> findAll();

    Store getOne(Long id);

    void create(Store store);

    void update(Store store);

    void remove(Store store);

    List<Store> findByCityId(Long id);

}
