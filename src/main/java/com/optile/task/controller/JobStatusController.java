package com.optile.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optile.task.enums.JobStatusEnum;
import com.optile.task.services.JobStatusService;
import com.optile.task.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by NrapendraKumar on 06-10-2016.
 */
@RestController
public class JobStatusController {

    @Autowired
    private JobStatusService jobStatusService;

    @RequestMapping(name = AppUtil.JOB_STATUS_URL , method= RequestMethod.GET)
    public @ResponseBody String getJobStatus() throws JsonProcessingException {
        Map<String,JobStatusEnum> jobStatusEnumMap =  jobStatusService.getJobStatusMap();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(jobStatusEnumMap);
        return json;
    }
}
