package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dronix.managedstores.models.Mission;
import ru.dronix.managedstores.models.Store;
import ru.dronix.managedstores.service.MissionService;
import ru.dronix.managedstores.service.StoreService;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
@RestController
@RequestMapping(value = "/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/list")
    public List<Mission> list(){
        return missionService.findAll();
    }

    @RequestMapping(value = "/add")
    public void addMission(@RequestParam("descr") String descr,
                           @RequestParam("store") Long id){
        Mission mission=new Mission();
        Store store=storeService.getOne(id);
        mission.setDescr(descr);
        mission.setStore_id(store);

        missionService.create(mission);
    }

    @RequestMapping(value = "/update")
    public void update(@RequestParam("id")Long id,
                       @RequestParam(value = "descr", required = false)String descr,
                       @RequestParam(value = "store_id",required = false)Long store_id){
        Mission mission=missionService.getOne(id);
        if(descr!=null){
            mission.setDescr(descr);
        } if(store_id!=null){
            Store store=storeService.getOne(store_id);
            mission.setStore_id(store);
        }

        missionService.update(mission);
    }

    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id")Long id){
        Mission mission=missionService.getOne(id);
        missionService.remove(mission);
    }

}
