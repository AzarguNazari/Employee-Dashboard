package com.dashboard;

import com.dashboard.controller.TaskRestController;
import com.dashboard.model.Priority;
import com.dashboard.model.Status;
import com.dashboard.model.Task;
import com.dashboard.service.TaskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRestController bankAccountController;

    @Autowired
    private TaskService taskService;

    @BeforeEach
    public void contextLoads() throws Exception {
        assertThat(bankAccountController).isNotNull();
        assertThat(taskService).isNotNull();
        Task task = new Task();
        task.setPercentage(50);
        task.setPriority(Priority.HIGH);
        task.setStatus(Status.DONE);
        task.setDescription("clean all unused branches");
        task.setTaskname("Git Branch Cleaning");
        taskService.deleteAllTasks();
        taskService.addNewTask(task);
        assertThat(taskService.getAllTasks()).hasSize(1);
    }

    @Test
    public void addNewAccount() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + this.port + "/v1/api/tasks";
        URI uri = new URI(baseUrl);
        Task task = new Task();
        task.setPercentage(50);
        task.setPriority(Priority.HIGH);
        task.setStatus(Status.DONE);
        task.setDescription("clean all unused branches");
        task.setTaskname("Git Branch Cleaning");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<Task> request = new HttpEntity<>(task, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        Assert.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    public void getAllList() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + this.port + "/v1/api/tasks";
        URI uri = new URI(baseUrl);
        final ResponseEntity<List> tasks = this.restTemplate.getForEntity(uri, List.class);
        assertThat(tasks).isNotNull();
        assertThat(tasks.getBody()).hasSize(1);
        Assert.assertEquals(200, tasks.getStatusCodeValue());
    }

    @Test
    public void updateTask() {

    }

    @Test
    public void deleteTask(){

    }

    @Test
    public void deleteAllTask() {

    }
}

