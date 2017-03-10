package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.managedstores.dao.StoreDao;
import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;

    @Override
    @Transactional
    public List<Store> findAll(){
        return storeDao.findAll();
    }

    @Override
    @Transactional
    public Store getOne(Long id) {
        return storeDao.getOne(id);
    }

}
