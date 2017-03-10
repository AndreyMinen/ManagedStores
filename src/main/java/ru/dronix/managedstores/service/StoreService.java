package ru.dronix.managedstores.service;

import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface StoreService {

    List<Store> findAll();

    Store getOne(Long id);

}
