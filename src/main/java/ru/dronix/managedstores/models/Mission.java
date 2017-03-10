package ru.dronix.managedstores.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store_id;

}
