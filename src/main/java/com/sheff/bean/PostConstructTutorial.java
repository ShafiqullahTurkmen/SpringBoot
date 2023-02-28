package com.sheff.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class PostConstructTutorial {

    @Autowired
    Logger LOG;

//    public PostConstructTutorial() {
//        LOG.info("Log info çağrıldı");
//    }

    @PostConstruct
    public void init() {
        LOG.info("Log info çağrıldı");
    }


    public static void main(String[] args) {
        PostConstructTutorial postConstructTutorial = new PostConstructTutorial();
        System.out.println(postConstructTutorial + "Bla Bla");
    }
}
