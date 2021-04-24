package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.model.Announcement;

import java.util.List;

public interface AnnouncementServiceInterface {
    void save(Announcement announcement);
    void delete(Integer announcementId);
    void update(Integer announcementId, Announcement announcement);
    boolean exist(Integer announcementId);
    List<Announcement> getAllAnnouncements();
    Announcement getAnnouncementById(Integer announcementId);
}
