package com.optile.task.services;

import com.optile.task.enums.JobStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by NrapendraKumar on 06-10-2016.
 */

@Component
public class JobStatusService {

    @Getter
    @Setter
    private static Map<String, JobStatusEnum> jobStatusMap = new ConcurrentHashMap<>();
}