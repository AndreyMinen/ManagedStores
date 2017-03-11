package ru.dronix.managedstores.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.dronix.managedstores.models.Seller;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface SellerService {

    List<Seller> findAll();

    Seller getOne(Long id);

    List<Seller> findByName(String name);

    void create(Seller seller);

    void update(Seller seller);

    void remove(Seller seller);

}
