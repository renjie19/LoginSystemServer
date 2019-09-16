package com.lourence.john.loginsystem.report.repository;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReportRepository extends CrudRepository<TimeLog,Integer> {
    @Query("select t from TimeLog t where employeeId = :id and time between :startDate and :endDate order by time ASC")
    List findLogsByEmployeeId(@Param("id")int id, @Param("startDate") long startDate, @Param("endDate") long endDate);
}
