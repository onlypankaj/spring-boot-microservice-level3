package com.onlypankaj.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Value("${app.descriptionnew:default value}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @GetMapping("/greeting")
    public String greeting(){

        return this.greetingMessage+
                this.listValues;
    }
}
