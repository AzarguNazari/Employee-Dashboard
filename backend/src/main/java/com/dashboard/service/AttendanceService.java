package com.dashboard.service;

import com.dashboard.exception.AttendanceNotFoundException;
import com.dashboard.model.Attendance;
import com.dashboard.repository.AttendanceRepository;
import com.dashboard.service.interfaces.AttendanceServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttendanceService implements AttendanceServiceInterface {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void save(Attendance attendance) {
        attendanceRepository.save(attendance);
        log.debug("New attendance is added {}", attendance);
    }

    @Override
    public void delete(Integer attendanceId) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(!byId.isPresent()) throw new AttendanceNotFoundException();
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public void update(Integer attendanceId, Attendance attendance) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(!byId.isPresent()) throw new AttendanceNotFoundException();
        attendanceRepository.deleteById(attendanceId);
        attendance.setId(attendanceId);
        attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Integer attendanceId) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(!byId.isPresent()) throw new AttendanceNotFoundException();
        return byId.get();
    }
}
