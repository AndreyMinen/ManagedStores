package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.managedstores.dao.SellerDao;
import ru.dronix.managedstores.models.Seller;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    @Override
    @Transactional
    public List<Seller> findAll(){
        return sellerDao.findAll();
    }

    @Override
    @Transactional
    public Seller getOne(Long id) {
        return sellerDao.getOne(id);
    }

}
