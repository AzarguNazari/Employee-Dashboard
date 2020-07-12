package com.example.dashboard.employeedashboard.controller.mvc;

import com.example.dashboard.employeedashboard.model.employee.EmployeeDto;
import com.example.dashboard.employeedashboard.service.DashboardServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String home(Model model, @RequestParam(value = "section", required = false) String section){
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
