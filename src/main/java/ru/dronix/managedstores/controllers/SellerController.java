package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dronix.managedstores.models.Seller;
import ru.dronix.managedstores.service.SellerService;
import ru.dronix.managedstores.service.StoreService;

import java.util.List;

/**
 * Created by ADMIN on 11.03.2017.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/list")
    public List<Seller> list(){
        return sellerService.findAll();
    }

    @RequestMapping(value = "/add")
    public void addSeller(@RequestParam("name")String name,
                          @RequestParam("store_id")Long id){

        Seller seller=new Seller();
        seller.setName(name);
        seller.setStore_id(storeService.getOne(id));

        sellerService.create(seller);
    }

    @RequestMapping(value = "/update")
    public void update(@RequestParam("id")Long id,
                       @RequestParam(value = "name",required = false)String name,
                       @RequestParam(value = "store_id",required = false)Long store_id){

        Seller seller=sellerService.getOne(id);
        if(name!=null){
            seller.setName(name);
        }if(store_id!=null){
            seller.setStore_id(storeService.getOne(id));
        }



        sellerService.update(seller);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id")Long id){

        sellerService.remove(sellerService.getOne(id));
    }

}
