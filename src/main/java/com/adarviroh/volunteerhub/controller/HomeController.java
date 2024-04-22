package com.adarviroh.volunteerhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Yaraslau_Dubovik on 04/11/2024
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
