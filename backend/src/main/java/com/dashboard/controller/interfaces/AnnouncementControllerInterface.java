package com.dashboard.controller.interfaces;

import com.dashboard.model.Announcement;
import com.dashboard.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AnnouncementControllerInterface {

    @PostMapping
    ResponseEntity<?> createAnnouncement(@RequestBody Announcement announcement);

    @GetMapping
    ResponseEntity<?> getAllEmployees();

    @GetMapping("/{announcementID}")
    ResponseEntity<?> getEmployeeById(@PathVariable Integer announcementID);

    @DeleteMapping("/{announcementID}")
    ResponseEntity<?> deleteEmployeeById(@PathVariable Integer announcementID);

    @PutMapping("/{announcementID}")
    ResponseEntity<?> updateEmployee(@PathVariable Integer announcementID, @RequestBody Announcement announcement);
}
