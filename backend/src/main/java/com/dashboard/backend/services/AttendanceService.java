package com.dashboard.backend.services;

import com.dashboard.backend.exceptions.AttendanceNotFoundException;
import com.dashboard.backend.interfaces.serviceInterfaces.CrudOperations;
import com.dashboard.backend.models.jpa.Attendance;
import com.dashboard.backend.repositories.AttendanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttendanceService implements CrudOperations<Attendance> {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void save(Attendance attendance) {
        attendanceRepository.save(attendance);
        log.debug("New attendance is added {}", attendance);
    }

    @Override
    public void delete(int attendanceId) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(byId.isEmpty()) throw new AttendanceNotFoundException();
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public void update(int attendanceId, Attendance attendance) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(byId.isEmpty()) throw new AttendanceNotFoundException();
        attendanceRepository.deleteById(attendanceId);
        attendance.setId(attendanceId);
        attendanceRepository.save(attendance);
    }

    @Override
    public boolean exist(int attendanceId) {
        return attendanceRepository.findById(attendanceId).isPresent();
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getById(int attendanceId) {
        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if(byId.isEmpty()) throw new AttendanceNotFoundException();
        return byId.get();
    }
}
