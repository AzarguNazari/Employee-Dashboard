package com.dashboard.controller;

import com.dashboard.interfaces.controllerInterfaces.AttendanceControllerInterface;
import com.dashboard.model.Attendance;
import com.dashboard.service.AttendanceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController implements AttendanceControllerInterface {

    @Autowired
    private AttendanceService attendanceService;

    @Override
    public ResponseEntity<?> createAttendance(Attendance attendance) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllAttendances(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAttendanceById(Integer attendanceID) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAttendanceById(Integer attendanceID) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateAttendance(Integer attendanceID, Attendance attendance) {
        return null;
    }
}
