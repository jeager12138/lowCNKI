package com.redemption.hair.lowCNKI.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index() {
        return "Hello lowCNKI";
    }

    @RequestMapping(path = {"/test"}, method = {RequestMethod.GET})
    public String testFreeMarker() {
        return "test";
    }
}
