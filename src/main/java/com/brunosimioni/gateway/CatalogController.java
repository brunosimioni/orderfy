package com.brunosimioni.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class Catalog {

    
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
