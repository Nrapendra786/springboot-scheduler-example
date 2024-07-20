package com.optile.task.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by NrapendraKumar
 */
@Entity
@Table(name = "data_ware_house")
@Getter
@Setter
public class DataWareHouse implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private int age;
}
