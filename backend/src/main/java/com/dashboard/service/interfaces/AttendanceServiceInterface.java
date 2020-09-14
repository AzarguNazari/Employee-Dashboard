package com.dashboard.service.interfaces;

import com.dashboard.model.Attendance;

import java.util.List;

public interface AttendanceServiceInterface {
    void save(Attendance attendance);
    void delete(Integer attendanceId);
    void update(Integer attendanceId, Attendance attendance);
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Integer attendanceId);
}
