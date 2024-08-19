package com.apple.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class BasicController {


    @GetMapping("/about")
    @ResponseBody
    public String about(){
        return "?????????";
    }

    @GetMapping("/html")
    @ResponseBody
    public String html(){
        return "<h1>HTML !!</h1>";
    }

    @GetMapping("/date")
    @ResponseBody
    public String date(){
        return LocalDateTime.now().toString();
    }
}
