package com.example.dashboard.employeedashboard.controller;

import com.example.dashboard.employeedashboard.model.Task;
import com.example.dashboard.employeedashboard.model.dto.LoginUserDto;
import com.example.dashboard.employeedashboard.model.dto.UserDto;
import com.example.dashboard.employeedashboard.service.TaskService;
import lombok.extern.log4j.Log4j2;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
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
public class HomeController {

    @Autowired
    private TaskService taskService;

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

    @PostMapping("/dashboard/login")
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

        System.err.println(userDto.getEmail() + " " + userDto.getPassword1() + " " + userDto.getFirstName() + " " + userDto.getLastName() + "  " + userDto.getSalary() + "  " + userDto.getPosition());
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
        Pageable pageable = PageRequest.of(0, 5, Sort.unsorted());
        Page<Task> tasks = taskService.getAllTasks(pageable);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/dashboard/profile")
    public String profile(Model model){
        model.addAttribute("userdto", new UserDto());
//        model.addAttribute("message", "danger");
        return "profile";
    }

    @PostMapping("/dashboard/profile")
    public String profile(@ModelAttribute UserDto userDto, Model model){
        if(!userDto.getFirstName().trim().equals("")){
            model.addAttribute("message", "success");
        }
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

    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute UserDto userDto, Model model){
        if(!userDto.getFirstName().trim().equals("")){
            model.addAttribute("message", "success");
        }
        return "profile";
    }
}