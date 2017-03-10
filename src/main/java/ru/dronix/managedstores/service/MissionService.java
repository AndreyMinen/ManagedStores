package ru.dronix.managedstores.service;

import ru.dronix.managedstores.models.Mission;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface MissionService {

    List<Mission> findAll();

    Mission getOne(Long id);

    void create(Mission mission);

    void update(Mission mission);

    void remove(Mission mission);

}
