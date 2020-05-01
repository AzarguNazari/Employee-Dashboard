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
@RequestMapping("/")
public class HomeController {

    // ------------------------------ MAIN PAGE

    @GetMapping("index")
    public String home(Model model){
        return "index";
    }

    // -------------------------- LOG IN

    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("userdto", new LoginUserDto());
        return "login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute LoginUserDto loginUserDto, Model model) {

        System.out.println(loginUserDto.getUsername() + " " + loginUserDto.getPassword() + " is received");
//        message = this.messageRepository.save(message);
        return "redirect:index";
    }

    // -------------------------- REGISTER ----------------------------

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("userdto", new UserDto());
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute UserDto userDto, Model model) {

        System.out.println(userDto.getUsername() + " " + userDto.getPassword1() + " is received");
//        message = this.messageRepository.save(message);
        return "redirect:index";
    }

    @GetMapping("notfound")
    public String notFound(Model model){
        return "error";
    }

    @GetMapping("announcements")
    public String announcement(Model model){
        return "announcement";
    }

    @GetMapping("attendance")
    public String attendance(Model model){
        return "attendance";
    }

    @GetMapping("chat")
    public String chat(Model model){
        return "chat";
    }

    @GetMapping("tasks")
    public String tasks(Model model){
        return "tasks";
    }

    @GetMapping("profile")
    public String profile(Model model){
        return "profile";
    }

    @GetMapping("setting")
    public String setting(Model model){
        return "setting";
    }

    @GetMapping("activities")
    public String activities(Model model){
        return "activities";
    }



}
