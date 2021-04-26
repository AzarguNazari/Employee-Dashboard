package com.dashboard.controller;

import com.dashboard.interfaces.controllerInterfaces.AnnouncementControllerInterface;
import com.dashboard.interfaces.controllerInterfaces.EmployeeControllerInterface;
import com.dashboard.exception.*;
import com.dashboard.model.Announcement;
import com.dashboard.model.Employee;
import com.dashboard.service.AnnouncementService;
import com.dashboard.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementsController implements AnnouncementControllerInterface {

    @Autowired
    private AnnouncementService announcementService;

    @Override
    public ResponseEntity<?> createAnnouncement(Announcement announcement) {
        try{
            announcementService.save(announcement);
            log.debug("New announcement {} is created", announcement);
            return new ResponseEntity<>("New employee created", HttpStatus.CREATED);
        }
        catch(BadRequestException ex){
            return new ResponseEntity<>(new ApiError("Announcement with id " + announcement.getId() + " is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllEmployees() {
        try{
            return new ResponseEntity<>(announcementService.getAllAnnouncements(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeById(Integer announcementID) {
        try{
            return new ResponseEntity<>(announcementService.getAnnouncementById(announcementID), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer announcementID) {
        try{
            announcementService.delete(announcementID);
            log.debug("Announcement with id {} is deleted", announcementID);
            return new ResponseEntity<>("Announcement with id " + announcementID + " is deleted", HttpStatus.OK);
        }
        catch(AnnouncementNotFoundException ex){
            return ExceptionFactory.EMPLOYEE_NOT_FOUND(announcementID);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer announcementID, Announcement announcement) {
        return null;
    }
}
