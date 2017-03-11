package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dronix.managedstores.models.City;
import ru.dronix.managedstores.models.Seller;
import ru.dronix.managedstores.models.Store;
import ru.dronix.managedstores.service.CityService;
import ru.dronix.managedstores.service.SellerService;
import ru.dronix.managedstores.service.StoreService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 11.03.2017.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private CityService cityService;

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/list")
    public List<Store> list(){
        return storeService.findAll();
    }


    @RequestMapping(value = "/add")
    public void addStore(@RequestParam("name")String name,
                       @RequestParam("city_id")Long id){
        Store store=new Store();
        store.setName(name);
        store.setCity(cityService.getOne(id));

        storeService.create(store);
    }

    @RequestMapping(value = "/update")
    public void update(@RequestParam("id")Long id,
                       @RequestParam(value = "name",required = false)String name,
                       @RequestParam(value = "city_id",required = false)Long city_id){
        Store store=storeService.getOne(id);

        if(name!=null){
            store.setName(name);
        }if(city_id!=null){
            store.setCity(cityService.getOne(city_id));
        }

        storeService.update(store);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id")Long id){
        storeService.remove(storeService.getOne(id));
    }

    @RequestMapping(value = "/filter/city")
    public List<Store> findByCity(@RequestParam("id")Long id){
        return storeService.findByCity_id(id);
    }

    @RequestMapping(value = "/filter/seller")
    public List<Store> findBySeller(@RequestParam("name")String name){
        List<Seller> sellers=sellerService.findByName(name);
        List<Store> stores=new ArrayList<>();
        sellers.forEach(seller -> stores.add(seller.getStore_id()));

        return stores;
    }

    @RequestMapping(value = "/filter/sellercity")
    public List<Store> findByCityAndSeller(@RequestParam("name")String name,
                                    @RequestParam("city_id")Long id){
        List<Seller> sellers=sellerService.findByName(name);
        List<Store> stores=new ArrayList<>();
        sellers.forEach(seller -> {
            if (seller.getStore_id().getCity().getId()==id){
                stores.add(seller.getStore_id());
            }
        });

        return stores;
    }

}
