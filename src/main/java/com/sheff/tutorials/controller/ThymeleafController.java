package com.sheff.tutorials.controller;

import com.sheff.tutorials.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // option: root {}
    // http://localhost:8080
    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }

    // http://localhost:8080/responseBody
    @GetMapping("/responseBody")
    @ResponseBody
    //  @ResponseBody  is used to return body response, otherwise return html page
    public String responseBody() {
        return "response body example";
    }


    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
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
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        model.addAttribute("key_model2", "I come from model-2");
        return "/thymeleaf_file/thymeleaf3";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        return "thymeleaf4";
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Model Object
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("Urun Adi")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", productDto);

        return "thymeleaf5";
    }

    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObject(Model model) {
        model.addAttribute("key_model1", "I come from model-1");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productId(1L).productName("Urun Adi1").productPrice(1500).build());
        listem.add(ProductDto.builder().productId(2L).productName("Urun Adi3").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(3L).productName("Urun Adi4").productPrice(3500).build());
        listem.add(ProductDto.builder().productId(4L).productName("Urun Adi5").productPrice(4500).build());
        listem.add(ProductDto.builder().productId(5L).productName("Urun Adi6").productPrice(5500).build());
        listem.add(ProductDto.builder().productId(6L).productName("Urun Adi7").productPrice(6500).build());
        model.addAttribute("product_liste", listem);
        return "thymeleaf6";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    // http://localhost:8080/thymeleaf7
    @GetMapping({"/thymeleaf7/", "/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("key_model1", "id " + id);
        } else {
            model.addAttribute("key_model1", "id not found");
        }
        return "thymeleaf7";
    }

    // http://localhost:8080/thymeleaf8/?id=4
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8ModelObject(Model model, @RequestParam(name = "id", required = false, defaultValue = "0") Long id) {
        if (id != null) {
            model.addAttribute("key_model1", "id " + id);
        } else if (id == 0) {
            model.addAttribute("key_model1", "default Value");
        } else {
            model.addAttribute("key_model1", "id not found");
        }
        return "thymeleaf8";
    }

}
