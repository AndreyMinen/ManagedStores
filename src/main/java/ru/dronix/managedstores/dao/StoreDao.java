package ru.dronix.managedstores.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Repository
public interface StoreDao extends CrudRepository<Store,Long> {

    List<Store> findAll();

    Store findOne(Long id);

}
