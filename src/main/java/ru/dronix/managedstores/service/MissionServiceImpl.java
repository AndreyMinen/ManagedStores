package ru.dronix.managedstores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.managedstores.dao.MissionDao;
import ru.dronix.managedstores.models.Mission;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionDao missionDao;

    @Override
    @Transactional
    public List<Mission> findAll() {
        return missionDao.findAll();
    }

    @Override
    @Transactional
    public Mission getOne(Long id) {
        return missionDao.getOne(id);
    }
}
