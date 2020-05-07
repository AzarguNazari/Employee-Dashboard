package com.example.dashboard.employeedashboard.controller;

import com.example.dashboard.employeedashboard.model.dto.LoginUserDto;
import com.example.dashboard.employeedashboard.model.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping
public class HomeController {

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
        model.addAttribute("loginUserDto", new LoginUserDto());
        return "login";
    }

    @PostMapping(value = "/dashboard/login")
    public String login(@ModelAttribute LoginUserDto loginUserDto, Model model) {
        System.out.println(loginUserDto.getUsername() + " " + loginUserDto.getPassword() + " is received");
//        message = this.messageRepository.save(message);
        return "redirect:/dashboard/index";
    }

    // -------------------------- REGISTER ----------------------------

    @GetMapping("/dashboard/register")
    public String register(Model model){
        model.addAttribute("userdto", new UserDto());
        return "register";
    }

    @PostMapping("/dashboard/register")
    public String register(@ModelAttribute UserDto userDto, Model model) {

        System.out.println(userDto.getUsername() + " " + userDto.getPassword1() + " is received");
//        message = this.messageRepository.save(message);
        return "redirect:/dashboard/index";
    }

    @GetMapping("/dashboard/notfound")
    public String notFound(Model model){
        return "error";
    }

    @GetMapping("/dashboard/announcements")
    public String announcement(Model model){
        return "announcement";
    }

    @GetMapping("/dashboard/attendance")
    public String attendance(Model model){
        return "attendance";
    }

    @GetMapping("/dashboard/chat")
    public String chat(Model model){
        return "chat";
    }

    @GetMapping("/dashboard/tasks")
    public String tasks(Model model){
        return "tasks";
    }

    @GetMapping("/dashboard/profile")
    public String profile(Model model){
        return "profile";
    }

    @GetMapping("/dashboard/setting")
    public String setting(Model model){
        return "setting";
    }

    @GetMapping("/dashboard/activities")
    public String activities(Model model){
        return "activities";
    }
}