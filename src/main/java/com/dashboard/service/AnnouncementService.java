package com.dashboard.service;

import com.dashboard.exception.AnnouncementNotFoundException;
import com.dashboard.model.Announcement;
import com.dashboard.repository.AnnouncementRepository;
import com.dashboard.interfaces.serviceInterfaces.CrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService implements CrudOperations<Announcement> {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public void save(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    @Override
    public void delete(int announcementId) {
        final Optional<Announcement> byId = announcementRepository.findById(announcementId);
        if(byId.isEmpty()) throw new AnnouncementNotFoundException();
        announcementRepository.deleteById(announcementId);
    }

    @Override
    public void update(int announcementId, Announcement announcement) {
        if(exist(announcementId)){
            delete(announcementId);
            announcement.setId(announcementId);
            announcementRepository.save(announcement);
        }
        else throw new AnnouncementNotFoundException();
    }

    @Override
    public boolean exist(int announcementId) {
        return announcementRepository.findById(announcementId).isPresent();
    }

    @Override
    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getById(int announcementId) {
        return announcementRepository.findById(announcementId).orElseThrow(AnnouncementNotFoundException::new);
    }
}
