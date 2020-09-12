package com.dashboard.repository;

import com.dashboard.model.Attendance;
import com.dashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
