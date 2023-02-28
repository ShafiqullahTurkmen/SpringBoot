package com.sheff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
  //  @ResponseBody  is used to return body response, otherwise return html page
    public String getThymeleaf1() {
        return "thymeleaf1";
    }
}
