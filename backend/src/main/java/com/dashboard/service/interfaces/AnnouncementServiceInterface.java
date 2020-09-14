package com.dashboard.service.interfaces;

import com.dashboard.model.Announcement;
import com.dashboard.model.Attendance;

import java.util.List;

public interface AnnouncementServiceInterface {
    void save(Announcement announcement);
    void delete(Integer announcementId);
    void update(Integer announcementId, Announcement announcement);
    List<Announcement> getAllAnnouncements();
    Announcement getAnnouncementById(Integer announcementId);
}
