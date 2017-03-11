package ru.dronix.managedstores.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Entity
@Table(name = "seller")
@Data
@NoArgsConstructor
public class Seller {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store_id;

}
