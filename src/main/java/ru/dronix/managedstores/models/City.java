package ru.dronix.managedstores.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "city_id")
//    private Set<Store> stores;

}
