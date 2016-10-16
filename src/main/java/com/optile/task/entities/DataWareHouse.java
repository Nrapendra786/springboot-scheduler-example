package com.optile.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */
@Entity
@Table(name = "data_ware_house")
public class DataWareHouse implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @Getter
    @Setter
    private String userName;

    @Column(name = "lastname")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "age")
    @Getter
    @Setter
    private int age;
}
