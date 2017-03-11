package ru.dronix.managedstores.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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

    @JsonIgnoreProperties("city")
    @OneToMany(mappedBy = "city")
    private List<Store> stores;

}
