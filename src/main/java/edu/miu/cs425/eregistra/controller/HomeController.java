package edu.miu.cs425.eregistra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/","eregistrar/home"})
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = {"eregistrar/about"})
    public String displayAbout() {
        return "public/about";
    }

    @GetMapping(value = {"eregistrar/login"})
    public String displayLogin() {
        return "login";
    }
}
