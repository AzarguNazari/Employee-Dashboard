package com.dashboard.backend.repositories;

import com.dashboard.backend.models.JPA.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}
