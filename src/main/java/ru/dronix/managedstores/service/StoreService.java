package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dronix.managedstores.dao.StoreDao;
import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Service
public class StoreService {
    @Autowired
    private StoreDao storeDao;


    public List<Store> findAll(){
        return storeDao.findAll();
    }

}
