package com.dashboard.controller.mvc;

import com.dashboard.model.employee.EmployeeDto;
import com.dashboard.model.task.Task;
import com.dashboard.service.DashboardServiceImpl;
import com.dashboard.service.TaskServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping
public class DashboardController {

    @Autowired
    private DashboardServiceImpl dashboardServiceImpl;

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping(value = {"/", "/dashboard"})
    public String defaultHome(Model model){
        return "redirect:/dashboard/index";
    }

    //              MAIN PAGE
    @GetMapping(value = {"/dashboard/index"})
    public String home(Model model, @RequestParam(value = "section", required = false, defaultValue = "default") String section){
        switch (section){
            case "tasks":
                Pageable pageable = PageRequest.of(0, 5, Sort.unsorted());
                Page<Task> tasks = taskServiceImpl.getAllTasks(pageable);
                model.addAttribute("tasks", tasks);
                break;
            case "profile":
                model.addAttribute("userdto", new EmployeeDto());
                break;
        }
        model.addAttribute("section", section);
        return "index";
    }

    //              LOG IN
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/dashboard/404-error")
    public String notFound(Model model){
        return "error";
    }

    @PostMapping("/dashboard/register")
    public String register(@ModelAttribute EmployeeDto employeeDto, Model model) {

        System.err.println(employeeDto.getEmail() + " " + employeeDto.getPassword1() + " " + employeeDto.getFirstName() + " " + employeeDto.getLastName() + "  " + employeeDto.getSalary() + "  " + employeeDto.getPosition());


            dashboardServiceImpl.createAccount(employeeDto);



        return "redirect:/register";
    }
}
