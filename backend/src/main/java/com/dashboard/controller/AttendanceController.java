package com.dashboard.controller;

import com.dashboard.controller.interfaces.AttendanceControllerInterface;
import com.dashboard.model.Attendance;
import com.dashboard.service.AttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance")
@Tag(name = "Attendance")
@Log4j2
public class AttendanceController implements AttendanceControllerInterface {

    @Autowired
    private AttendanceService attendanceService;


    @Override
    public ResponseEntity<?> createAttendance(Attendance attendance) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> getAllAttendances(Pageable pageable) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> getAttendanceById(Integer attendanceID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> deleteAttendanceById(Integer attendanceID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> updateAttendance(Integer attendanceID, Attendance attendance) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
