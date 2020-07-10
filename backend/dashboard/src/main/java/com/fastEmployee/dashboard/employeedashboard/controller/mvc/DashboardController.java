package com.fastEmployee.dashboard.employeedashboard.controller.mvc;

import com.fastEmployee.dashboard.employeedashboard.model.employee.EmployeeDto;
import com.fastEmployee.dashboard.employeedashboard.service.DashboardServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping
public class DashboardController {

    @Autowired
    private DashboardServiceImpl dashboardServiceImpl;

    @GetMapping
    public String defaultHome(Model model){
        return "redirect:/dashboard/index";
    }

    //              MAIN PAGE
    @GetMapping(value = {"/dashboard/index", "/dashboard"})
    public String home(Model model){
        return "index";
    }

    //              LOG IN
    @GetMapping("/dashboard/login")
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

        try{
            dashboardServiceImpl.createAccount(employeeDto);
        }


        return "redirect:/register";
    }
}
