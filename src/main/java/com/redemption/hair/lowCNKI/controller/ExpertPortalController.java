package com.redemption.hair.lowCNKI.controller;


import com.redemption.hair.lowCNKI.DAO.Co_expertsDAO;
import com.redemption.hair.lowCNKI.DAO.ExpertsDAO;
import com.redemption.hair.lowCNKI.DAO.Paper_masterDAO;
import com.redemption.hair.lowCNKI.model.Experts;
import com.redemption.hair.lowCNKI.model.Paper_master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Paper;
import java.util.List;

@Controller
public class ExpertPortalController {
    @Autowired
    Co_expertsDAO co_expertsDAO;
    @Autowired
    ExpertsDAO expertsDAO;
    @Autowired
    Paper_masterDAO paper_masterDAO;

    @RequestMapping(path = {"/getExpertInformation"}, method = {RequestMethod.GET})
    @ResponseBody
    public String getExpertInformation(Model model, @RequestParam("ExpertName")String expertName) {
        Experts e = expertsDAO.getExpertsByName(expertName);
        model.addAttribute("expert", e);
        return "";  //html name
    }

    @RequestMapping(path = {"/getExpertPaper"}, method = {RequestMethod.GET})
    @ResponseBody
    public String getExpertPaper(Model model, @RequestParam("ExpertName")String expertName) {
        int rid = expertsDAO.getIdbyName(expertName);
        List<Paper_master> EssayList = paper_masterDAO.getPaperByRid(rid);
        model.addAttribute("EssayList", EssayList);
        return "";  //html name
    }

    

}
