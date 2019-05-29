package com.redemption.hair.lowCNKI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
    @RequestMapping(path = {"/login"}, method = {RequestMethod.GET})
    public String testFreeMarker() {
        return "login";
    }
}
