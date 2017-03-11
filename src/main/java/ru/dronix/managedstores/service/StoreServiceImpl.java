package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.managedstores.dao.StoreDao;
import ru.dronix.managedstores.models.City;
import ru.dronix.managedstores.models.Seller;
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

    @Override
    @Transactional
    public void create(Store store) {
        storeDao.saveAndFlush(store);
    }

    @Override
    @Transactional
    public void update(Store store) {
        storeDao.saveAndFlush(store);
    }

    @Override
    @Transactional
    public void remove(Store store) {
        storeDao.delete(store);
    }

    @Override
    @Transactional
    public List<Store> findByCity_id(Long id) {
        return storeDao.findByCity_id(id);
    }

}
