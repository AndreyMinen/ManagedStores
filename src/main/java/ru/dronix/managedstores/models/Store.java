package ru.dronix.managedstores.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ADMIN on 09.03.2017.
 */

@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city_id;




}
