package com.fastEmployee.dashboard.employeedashboard.controller.mvc;

import com.fastEmployee.dashboard.employeedashboard.model.task.Task;
import com.fastEmployee.dashboard.employeedashboard.model.employee.EmployeeDto;
import com.fastEmployee.dashboard.employeedashboard.service.TaskServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping
public class TaskController {

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping("/dashboard/tasks")
    public String tasks(Model model){
        Pageable pageable = PageRequest.of(0, 5, Sort.unsorted());
        Page<Task> tasks = taskServiceImpl.getAllTasks(pageable);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute EmployeeDto employeeDto, Model model){
        if(!employeeDto.getFirstName().trim().equals("")){
            model.addAttribute("message", "success");
        }
        return "profile";
    }

}
