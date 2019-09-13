package com.lourence.john.loginsystem.timelog.service;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import com.lourence.john.loginsystem.timelog.repository.TimeLogRepository;
import com.lourence.john.loginsystem.util.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeLogServiceImpl implements TimeLogService {
    @Autowired
    private TimeLogRepository repository;

    @Override
    public TimeLog createTimeLog(int id) {
        TimeLog timeLog = new TimeLog();
        timeLog.setEmployeeId(id);
        timeLog.setTime(System.currentTimeMillis());
        TimeLog lastLog = getLastLog(id);
        if(lastLog != null) {
            if(lastLog.getType().equals(StateEnum.OUT)) {
                timeLog.setType(StateEnum.IN);
            } else {
                timeLog.setType(StateEnum.OUT);
            }
        } else {
            timeLog.setType(StateEnum.IN);
        }
        return repository.save(timeLog);
    }

    private TimeLog getLastLog(int id) {
       return repository.findFirstByEmployeeIdOrderByTimeDesc(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
