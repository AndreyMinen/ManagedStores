package ru.dronix.managedstores.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ADMIN on 09.03.2017.
 */

@Entity
@Table(name = "store")
@Data
@NoArgsConstructor
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnoreProperties("store_id")
    @OneToMany(mappedBy = "store_id",cascade= CascadeType.ALL)
    private List<Mission> missions;

    @JsonIgnoreProperties("store_id")
    @OneToMany(mappedBy = "store_id")
    private List<Seller> sellers;


}
