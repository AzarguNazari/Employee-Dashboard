package com.dashboard.backend.repositories;

import com.dashboard.backend.models.jpa.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
