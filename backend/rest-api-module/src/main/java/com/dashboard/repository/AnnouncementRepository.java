package com.dashboard.repository;

import com.dashboard.model.Announcement;
import com.dashboard.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}
