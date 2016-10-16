package com.optile.task.services;

import com.optile.task.entities.DataWareHouse;
import com.optile.task.exceptions.ScheduledJobException;
import com.optile.task.repositories.DataWareHouseRepository;
import com.optile.task.utils.AppUtil;
import com.optile.task.utils.NumberUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */

@Service
@Qualifier(AppUtil.DATA_WARE_HOUSE)
@Transactional
public class DataWareHouseScheduledJobServiceImpl implements IScheduledJobService {

    private static final Logger logger = LoggerFactory.getLogger(DataWareHouseScheduledJobServiceImpl.class.getName());

    @Autowired
    private DataWareHouseRepository dataWareHouseRepository;

    @Override
    public void executeJob() {
        InputStream inputStream = getClass().getResourceAsStream(AppUtil.DATA_WARE_HOUSE_CSV_FILE);
        try {
            LineIterator lineIterator = IOUtils.lineIterator(inputStream, AppUtil.UTF_8);
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                String[] elements = line.split(AppUtil.COMMA);
                DataWareHouse dataWareHouse = new DataWareHouse();
                dataWareHouse.setUserName(elements[NumberUtil.ZERO]);
                dataWareHouse.setLastName(elements[NumberUtil.ONE]);
                dataWareHouse.setAge(Integer.parseInt(elements[NumberUtil.TWO]));
                dataWareHouseRepository.save(dataWareHouse);
            }
        } catch (IOException e) {
            throw new ScheduledJobException(e.getMessage(), e.getCause());
        }
    }
}
