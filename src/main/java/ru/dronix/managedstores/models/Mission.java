package ru.dronix.managedstores.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by ADMIN on 09.03.2017.
 */
@Entity
@Table(name = "mission")
@Data
@NoArgsConstructor
public class Mission {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descr")
    private String descr;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store_id;

}
