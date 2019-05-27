package com.redemption.hair.lowCNKI.controller;


import com.redemption.hair.lowCNKI.DAO.Co_expertsDAO;
import com.redemption.hair.lowCNKI.DAO.ExpertsDAO;
import com.redemption.hair.lowCNKI.DAO.Follow_expertsDAO;
import com.redemption.hair.lowCNKI.DAO.Paper_masterDAO;
import com.redemption.hair.lowCNKI.model.Experts;
import com.redemption.hair.lowCNKI.model.Follow_experts;
import com.redemption.hair.lowCNKI.model.HostHolder;
import com.redemption.hair.lowCNKI.model.Paper_master;
import com.redemption.hair.lowCNKI.service.FollowService;
import com.redemption.hair.lowCNKI.service.followService;
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
    @Autowired
    HostHolder hostHolder;
    @Autowired
    FollowService followService;
    @Autowired
    Follow_expertsDAO follow_expertsDAO;

    @RequestMapping(path = {"/getExpertInformation"}, method = {RequestMethod.GET})
    public String getExpertInformation(Model model, @RequestParam("ExpertId")int expertId) {
        Experts e = expertsDAO.getExpertsById(expertId);
        model.addAttribute("expert", e);
        return "";  //html name
    }

    @RequestMapping(path = {"/getExpertPaper"}, method = {RequestMethod.GET})
    public String getExpertPaper(Model model, @RequestParam("ExpertId")int rid) {
        List<Paper_master> EssayList = paper_masterDAO.getPaperByRid(rid);
        model.addAttribute("EssayList", EssayList);
        return "";  //html name
    }

    @RequestMapping(path = {"/followExpert"}, method = {RequestMethod.POST})
    @ResponseBody
    public String followExpert(@RequestParam("ExpertId")int expertId) {
        boolean ret = followService.follow(hostHolder.getUser().getId(), expertId);
        return ret ? "success" : "fail: please follow later";
    }

    @RequestMapping(path = {"/queryIfFollow"}, method = {RequestMethod.GET})
    @ResponseBody
    public int queryIfFollow(@RequestParam("ExpertId")int expertId) {
        try {
            Follow_experts ret = follow_expertsDAO.queryIfFollow(hostHolder.getUser().getId(), expertId);
            return ret==null ? 0 : 1;
        } catch (Exception e) {
            return -1;
        }

    }




    

}
