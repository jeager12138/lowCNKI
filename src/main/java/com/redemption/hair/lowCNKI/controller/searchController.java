package com.redemption.hair.lowCNKI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class searchController {
    @RequestMapping(path = {"/search"}, method = {RequestMethod.GET})
    public String testFreeMarker() {
        return "search";
    }
}
