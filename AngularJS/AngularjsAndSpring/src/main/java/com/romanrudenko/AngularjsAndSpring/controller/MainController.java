package com.romanrudenko.AngularjsAndSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author roman.rudenko on 29-Feb-16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String homepage(){
        return "homepage";
    }
}
