package com.example.dashboard.employeedashboard.controller.mvc;

import com.example.dashboard.employeedashboard.model.employee.EmployeeDto;
import com.example.dashboard.employeedashboard.service.ProfileServiceImpl;
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
public class ProfileController {

    @Autowired
    private ProfileServiceImpl profileServiceImpl;

    @GetMapping("/dashboard/profile")
    public String profile(Model model){
        model.addAttribute("userdto", new EmployeeDto());
//        model.addAttribute("message", "danger");
        return "profile";
    }


    @PostMapping("/dashboard/profile")
    public String profile(@ModelAttribute EmployeeDto employeeDto, Model model){
        if(!employeeDto.getFirstName().trim().equals("")){
            model.addAttribute("message", "success");
        }
        return "profile";
    }

    @GetMapping("/dashboard/activities")
    public String activities(Model model){
        return "activities";
    }

    @GetMapping("/dashboard/setting")
    public String setting(Model model){
        return "setting";
    }
}
