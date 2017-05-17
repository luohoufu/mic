package io.tonny.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/")
    public String index() {
        LOGGER.info("The index controller invoked!");
        return "Greetings from Spring Boot!";
    }
}