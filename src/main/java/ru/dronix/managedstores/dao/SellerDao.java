package ru.dronix.managedstores.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dronix.managedstores.models.Seller;

import java.util.List;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Repository
public interface SellerDao extends JpaRepository<Seller,Long> {

    List<Seller> findAll();

    Seller getOne(Long id);

}
