package com.lourence.john.loginsystem.timelog.service;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;

public interface TimeLogService {
    TimeLog createTimeLog(int id);

    void deleteAll();
}
