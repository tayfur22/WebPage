package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing webstore");
        return "welcome"; // Bu, 'welcome.jsp' səhifəsini geri qaytarır
    }

    @RequestMapping("/welcome/greeting")
    public String greeting() {
        return "welcome";
    }
}
