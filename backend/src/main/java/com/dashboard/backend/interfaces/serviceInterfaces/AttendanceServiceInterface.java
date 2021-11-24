package com.dashboard.backend.interfaces.serviceInterfaces;

import com.dashboard.backend.models.JPA.Attendance;

import java.util.List;

public interface AttendanceServiceInterface {
    void save(Attendance attendance);
    void delete(Integer attendanceId);
    void update(Integer attendanceId, Attendance attendance);
    boolean exist(Integer attendanceId);
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Integer attendanceId);
}
