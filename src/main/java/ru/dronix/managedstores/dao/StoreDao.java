package ru.dronix.managedstores.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dronix.managedstores.models.City;
import ru.dronix.managedstores.models.Seller;
import ru.dronix.managedstores.models.Store;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Repository
public interface StoreDao extends JpaRepository<Store,Long> {

    List<Store> findAll();

    Store getOne(Long id);

    List<Store> findByCity_id(Long id);

}
