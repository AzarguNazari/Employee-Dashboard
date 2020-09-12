package com.dashboard.controller.interfaces;

import com.dashboard.model.Attendance;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AttendanceControllerInterface {

    @PostMapping
    ResponseEntity<?> createAttendance(@RequestBody Attendance attendance);

    @GetMapping
    ResponseEntity<?> getAllAttendances(Pageable pageable);

    @GetMapping("/{attendanceID}")
    ResponseEntity<?> getAttendanceById(@PathVariable Integer attendanceID);

    @DeleteMapping("/{attendanceID}")
    ResponseEntity<?> deleteAttendanceById(@PathVariable Integer attendanceID);

    @PutMapping("/{attendanceID}")
    ResponseEntity<?> updateAttendance(@PathVariable Integer attendanceID, @RequestBody Attendance attendance);
}
