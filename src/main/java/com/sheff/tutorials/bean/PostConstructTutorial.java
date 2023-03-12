package com.sheff.tutorials.bean;

import org.springframework.stereotype.Controller;

@Controller
public class PostConstructTutorial {

//    @Autowired
//    Logger LOG;
//
////    public PostConstructTutorial() {
////        LOG.info("Log info çağrıldı");
////    }
//
//    @PostConstruct
//    public void init() {
//        LOG.info("Log info çağrıldı");
//    }


    public static void main(String[] args) {
        PostConstructTutorial postConstructTutorial = new PostConstructTutorial();
        System.out.println(postConstructTutorial + "Bla Bla");
    }
}
