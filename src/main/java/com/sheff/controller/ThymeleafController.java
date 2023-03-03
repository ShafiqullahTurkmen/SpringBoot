package com.sheff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
  //  @ResponseBody  is used to return body response, otherwise return html page
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf12Model(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        model.addAttribute("key_model2", "I come from model-2");
        return "thymeleaf1";
    }


    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf13Model(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        model.addAttribute("key_model2", "I come from model-2");
        return "/thymeleaf_file/thymeleaf3";
    }
}
