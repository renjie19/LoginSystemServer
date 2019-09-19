package com.lourence.john.loginsystem.report.repository;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ReportRepository extends CrudRepository<TimeLog,Integer> {
    List<TimeLog> findByEmployeeIdAndTimeBetweenOrderByTimeAsc(int id, long startDate, long endDate);
}
