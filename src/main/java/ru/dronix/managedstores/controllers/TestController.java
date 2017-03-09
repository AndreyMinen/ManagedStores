package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dronix.managedstores.dao.SellerDao;
import ru.dronix.managedstores.dao.StoreDao;
import ru.dronix.managedstores.models.Seller;
import ru.dronix.managedstores.models.Store;
import ru.dronix.managedstores.service.SellerService;
import ru.dronix.managedstores.service.StoreService;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/list")
    public String findAll(){
        List<Store> storeList=storeService.findAll();
        return "profit";
    }

}
