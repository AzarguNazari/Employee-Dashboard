package com.dashboard.controllers;

import com.dashboard.repositories.AnnouncementRepository;
import com.dashboard.services.AnnouncementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AnnouncementsController.class)
class AnnouncementsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnnouncementRepository announcementRepository;

    @MockBean
    private AnnouncementService announcementService;



//    @MockBean
//    private WeatherClient weatherClient;
    @Test
    void createAnnouncement() {

    }

    @Test
    void getAllEmployees() throws Exception {
        mockMvc.perform(get("/api/v1/announcements"))
                .andExpect(content().string("[]"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void updateEmployee() {
    }
}