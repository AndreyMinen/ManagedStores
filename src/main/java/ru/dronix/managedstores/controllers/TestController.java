package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dronix.managedstores.models.Mission;
import ru.dronix.managedstores.models.Store;
import ru.dronix.managedstores.service.MissionService;
import ru.dronix.managedstores.service.StoreServiceImpl;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {
    @Autowired
    private MissionService missionService;

    @RequestMapping(value = "/list")
    public String findAll(){
        return missionService.findAll().get(0).getStore_id().getName();
    }

}
