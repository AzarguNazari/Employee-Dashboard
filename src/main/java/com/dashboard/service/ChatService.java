package com.dashboard.service;

import com.dashboard.exception.AttendanceNotFoundException;
import com.dashboard.interfaces.serviceInterfaces.ChatServiceInterface;
import com.dashboard.model.Attendance;
import com.dashboard.repository.MessageRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ChatService implements ChatServiceInterface {

//    @Autowired
//    private MessageRepository messageRepository;
//
//    @Override
//    public void save(Attendance attendance) {
//        messageRepository.save(attendance);
//        log.debug("New attendance is added {}", attendance);
//    }
//
//    @Override
//    public void delete(Integer attendanceId) {
//
//    }
//
//    @Override
//    public void update(Integer attendanceId, Attendance attendance) {
//
//    }
//
//    @Override
//    public boolean exist(Integer attendanceId) {
//        return false;
//    }
//
//    @Override
//    public List<Attendance> getAllAttendances() {
//        return null;
//    }
//
//    @Override
//    public Attendance getAttendanceById(Integer attendanceId) {
//        return null;
//    }
//
//
//    @Override
//    public void delete(Integer attendanceId) {
//        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
//        if(byId.isEmpty()) throw new AttendanceNotFoundException();
//        attendanceRepository.deleteById(attendanceId);
//    }
//
//    @Override
//    public void update(Integer attendanceId, Attendance attendance) {
//        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
//        if(byId.isEmpty()) throw new AttendanceNotFoundException();
//        attendanceRepository.deleteById(attendanceId);
//        attendance.setId(attendanceId);
//        attendanceRepository.save(attendance);
//    }
//
//    @Override
//    public boolean exist(Integer attendanceId) {
//        return attendanceRepository.findById(attendanceId).isPresent();
//    }
//
//    @Override
//    public List<Attendance> getAllAttendances() {
//        return attendanceRepository.findAll();
//    }
//
//    @Override
//    public Attendance getAttendanceById(Integer attendanceId) {
//        final Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
//        if(byId.isEmpty()) throw new AttendanceNotFoundException();
//        return byId.get();
//    }

}
