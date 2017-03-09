package ru.dronix.managedstores.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Entity
@Table(name = "mission")
@Data
public class Mission {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descr")
    private String descr;



}
