package ru.dronix.managedstores.service;

import ru.dronix.managedstores.models.Seller;

import java.util.List;

/**
 * Created by ADMIN on 10.03.2017.
 */
public interface SellerService {

    List<Seller> findAll();

    Seller getOne(Long id);

}
