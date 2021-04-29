package com.dashboard.services;

import com.dashboard.repositories.AnnouncementRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class AnnouncementServiceTest {

    @Mock
    private AnnouncementRepository announcementRepository;

    private AnnouncementService announcementService;

    @BeforeEach
    public void init() {
        announcementService = new AnnouncementService(announcementRepository);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void exist() {
    }

    @Test
    void getAll() {
        Mockito.when(announcementRepository.findAll().size()).thenReturn(0);
        assertEquals(announcementService.getAll().size(), 0);
    }

    @Test
    void getById() {
    }
}