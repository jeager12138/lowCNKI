package com.redemption.hair.lowCNKI.controller;


import com.redemption.hair.lowCNKI.DAO.*;
import com.redemption.hair.lowCNKI.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class testController {

    @Autowired
    Co_expertsDAO co_expertsDAO;
    @Autowired
    ExpertsDAO expertsDAO;
    @Autowired
    Paper_masterDAO paper_masterDAO;
    @Autowired
    Paper_journalDAO paper_journalDAO;
    @Autowired
    Paper_meetingDAO paper_meetingDAO;
    @Autowired
    PatentsDAO patentsDAO;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index() {
        int i = co_expertsDAO.selectCoIdByExpertId(1);
        String str = "" + i;
        return str;
    }

    @RequestMapping(path = {"/blabla"}, method = {RequestMethod.GET})
    @ResponseBody
    public String funcForTest(Model model) {
        //Experts e = expertsDAO.getExpertsByName(expertName);
        //model.addAttribute("expert", e);
        int rid = expertsDAO.getIdbyName("原");
        List<Paper_master> papers = paper_masterDAO.getPaperByRid(rid);
        //model.addAttribute("papers", papers);
        System.out.println("-------a------");
        String str = "";
        for(Paper_master t: papers) {
            str = t.getInstitution();

        }
        return str;
    }


}
