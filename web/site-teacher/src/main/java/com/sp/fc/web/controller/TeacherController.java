package com.sp.fc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @GetMapping({"", "/"})
    public String index() {
        return "/teacher/index";
    }

    @GetMapping("/signup")
    public String singUp() {
        return "/teacher/signup";
    }
}
