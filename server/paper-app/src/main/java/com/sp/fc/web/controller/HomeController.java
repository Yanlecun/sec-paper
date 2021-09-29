package com.sp.fc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("name", "world ! by ThymeLeaf");
        return "index";
    }

    @GetMapping("/login") // /login?site=teacher 처럼 분기하기
    public String login(@RequestParam String site, Model model) {
        model.addAttribute("site", site);
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String site, Model model) {
        model.addAttribute("site", site);
        return "redirect:/"+site;
    }

    @GetMapping("/signup") // /login?site=teacher 처럼 분기하기
    public String singUp(@RequestParam String site) {
        return "redirect:/"+site+"/signup";
    }
}
