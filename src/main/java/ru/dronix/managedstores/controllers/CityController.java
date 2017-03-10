package ru.dronix.managedstores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dronix.managedstores.models.City;
import ru.dronix.managedstores.service.CityService;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/list")
    public List<City> list(){
        return cityService.findAll();
    }

    @RequestMapping(value = "/get/{city}")
    public City getCity(@PathVariable("city") String city){
        return cityService.findByName(city);
    }

    @RequestMapping(value = "/add")
    public void addCity(@RequestParam("name")String name){
        City city=new City();
        city.setName(name);
        cityService.create(city);
    }

    @RequestMapping(value = "/update")
    public void update(@RequestParam("id") Long id,
                       @RequestParam("name") String name){
        City city=cityService.getOne(id);
        city.setName(name);

        cityService.update(city);
    }

    @RequestMapping(value = "/delete")
    public void remove(@RequestParam("id") Long id){
        City city=cityService.getOne(id);
        cityService.remove(city);
    }

}
