package ru.zichead.PP_3_1_2.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("")
    public String helloPage () {
        return "hello";
    }
}
