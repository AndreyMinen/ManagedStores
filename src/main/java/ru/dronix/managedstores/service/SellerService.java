package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dronix.managedstores.dao.SellerDao;
import ru.dronix.managedstores.models.Seller;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Service
public class SellerService {

    @Autowired
    private SellerDao sellerDao;


    public List<Seller> findAll(){
        return sellerDao.findAll();
    }

}
