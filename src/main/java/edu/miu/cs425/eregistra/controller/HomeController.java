package edu.miu.cs425.eregistra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/"})
    public String displayHomepage() {
        return "home/index";
    }
}
