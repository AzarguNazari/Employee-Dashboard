package com.dashboard.service;

import com.dashboard.exception.AnnouncementNotFoundException;
import com.dashboard.model.Announcement;
import com.dashboard.repository.AnnouncementRepository;
import com.dashboard.interfaces.serviceInterfaces.AnnouncementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService implements AnnouncementServiceInterface {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public void save(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    @Override
    public void delete(Integer announcementId) {
        final Optional<Announcement> byId = announcementRepository.findById(announcementId);
        if(byId.isEmpty()) throw new AnnouncementNotFoundException();
        announcementRepository.deleteById(announcementId);
    }

    @Override
    public void update(Integer announcementId, Announcement announcement) {
        if(exist(announcementId)){
            delete(announcementId);
            announcement.setId(announcementId);
            announcementRepository.save(announcement);
        }
        else throw new AnnouncementNotFoundException();
    }

    @Override
    public boolean exist(Integer announcementId) {
        return announcementRepository.findById(announcementId).isPresent();
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncementById(Integer announcementId) {
        return announcementRepository.findById(announcementId).orElseThrow(AnnouncementNotFoundException::new);
    }
}
