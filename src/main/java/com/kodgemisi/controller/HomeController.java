package com.kodgemisi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ari on 23.03.2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/home","/"})
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
