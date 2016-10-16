package com.optile.task.repositories;

import com.optile.task.entities.DataWareHouse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */
public interface DataWareHouseRepository  extends CrudRepository<DataWareHouse,Long>{
    //marker Interface
}
