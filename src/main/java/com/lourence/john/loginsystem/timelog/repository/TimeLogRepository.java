package com.lourence.john.loginsystem.timelog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeLogRepository extends JpaRepository<TimeLog,Integer> {
      TimeLog findFirstByEmployeeIdOrderByTimeDesc(int id);
}
