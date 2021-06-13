package com.onlypankaj.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${app.descriptionnew:default value}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment env;

    @GetMapping("/greeting")
    public String greeting(){

        return this.greetingMessage+
                this.listValues+
                this.dbValues+
                dbSettings.getHost()+dbSettings.getConnection();
    }

    @GetMapping("/envdetails")
    public String envDetails(){
        env.getProperty("test");    //Value lookup instead of value inject
        return env.getProperty("${HOME}") + "####" + env.toString();
    }
}
