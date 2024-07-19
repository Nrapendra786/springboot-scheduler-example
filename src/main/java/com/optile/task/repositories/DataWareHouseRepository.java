package com.optile.task.repositories;

import com.optile.task.entities.DataWareHouse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NrapendraKumar
 */
public interface DataWareHouseRepository  extends CrudRepository<DataWareHouse,Long>{
    //marker Interface
}
