package com.dashboard.controller.mvc;

import com.dashboard.service.AttendenceServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping
public class AttendenceController {

    @Autowired
    private AttendenceServiceImpl attendenceServiceImpl;

    @GetMapping("/dashboard/attendance")
    public String attendance(Model model){
        return "attendance";
    }


}
