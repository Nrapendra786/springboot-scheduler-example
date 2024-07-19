package com.optile.task.services;

import org.springframework.stereotype.Service;

/**
 * Created by NrapendraKumar
 */
@Service
public interface IScheduledJobService {
    void executeJob();
}
