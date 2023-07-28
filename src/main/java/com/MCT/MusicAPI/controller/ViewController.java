package com.MCT.MusicAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ViewController {
    @GetMapping("/")
    public String getSwagger(){
        return "redirect:/swagger-ui/index.html#/";
    }
}
