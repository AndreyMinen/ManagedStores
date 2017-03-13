package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addStore(@RequestParam("name")String name,
                       @RequestParam("city_id")Long id){
        Store store=new Store();
        store.setName(name);
        store.setCity(cityService.getOne(id));

        storeService.create(store);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
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

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(@RequestParam("id")Long id){
        storeService.remove(storeService.getOne(id));
    }

    @RequestMapping(value = "/filter",method = RequestMethod.GET)
    public List<Store> filter(@RequestParam(value = "name",required = false)String name,
                                           @RequestParam(value = "city_id",required = false)Long id){

        final List<Store> stores=new ArrayList<>();
        System.out.println(name);
        if(name!=null && id==null){
            List<Seller> sellers=sellerService.findByName(name);
            sellers.forEach(item->stores.add(item.getStore_id()));
        }
        if(name==null && id!=null){
            storeService.findByCityId(id).forEach(stores::add);
        }
        if(name==null && id==null){
            storeService.findAll().forEach(stores::add);
        }
        if(name!=null && id!=null){
            List<Seller> sellers=sellerService.findByName(name);
            sellers.forEach(seller -> {
                if (seller.getStore_id().getCity().getId()==id){
                    stores.add(seller.getStore_id());
                }
            });
        }


        return stores;
    }

}
