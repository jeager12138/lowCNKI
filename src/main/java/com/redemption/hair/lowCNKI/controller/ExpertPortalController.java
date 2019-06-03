package com.redemption.hair.lowCNKI.controller;


import com.redemption.hair.lowCNKI.DAO.*;
import com.redemption.hair.lowCNKI.model.*;
import com.redemption.hair.lowCNKI.service.FollowService;
import com.redemption.hair.lowCNKI.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpertPortalController {
    @Autowired
    Co_expertsDAO co_expertsDAO;
    @Autowired
    ExpertsDAO expertsDAO;
    @Autowired
    Paper_journalDAO paper_journalDAO;
    @Autowired
    Paper_masterDAO paper_masterDAO;
    @Autowired
    Paper_meetingDAO paper_meetingDAO;
    @Autowired
    PatentsDAO patentsDAO;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    FollowService followService;
    @Autowired
    Follow_expertsDAO follow_expertsDAO;

    @Autowired
    Bdxs_authorDAO bdxs_authorDAO;
    @Autowired
    Bdxs_paperDAO bdxs_paperDAO;
    @Autowired
    SolrService solrService;

    @RequestMapping(path = {"/expert"}, method = {RequestMethod.GET})
    public String getExpertInformation(Model model, @RequestParam("ExpertId")String expertId) {
        Bdxs_author author = bdxs_authorDAO.selectAuthorById(expertId);
        model.addAttribute("expert", author);                     //专家信息

        int otherNumber = 0;  //其他
        int journalNumber = 0;  //期刊
        int meetingNumber = 0;  //会议
        int patentNumber = 0;  //专著

        System.out.println(author.getBookRatio());
        otherNumber = (int)(Integer.parseInt(author.getPaperNum()) * Double.parseDouble(author.getOtherRtio().replace("%",""))*0.01);
        journalNumber = (int)(Integer.parseInt(author.getPaperNum()) * Double.parseDouble(author.getJournalRatio().replace("%",""))*0.01);
        meetingNumber = (int)(Integer.parseInt(author.getPaperNum()) * Double.parseDouble(author.getMeetingRatio().replace("%",""))*0.01);
        patentNumber = (int)(Integer.parseInt(author.getPaperNum()) * Double.parseDouble(author.getBookRatio().replace("%",""))*0.01);
        System.out.println(journalNumber);
        model.addAttribute("masterNumber", otherNumber);  //其他数
        model.addAttribute("journalNumber", journalNumber); //期刊数
        model.addAttribute("meetingNumber", meetingNumber); // 会议数
        model.addAttribute("patentNumber", patentNumber); //专利数

        int refNumber = Integer.parseInt(author.getCited());
        model.addAttribute("refNumber", refNumber);  //被引频次

        int refPercent = refNumber/10 < 10 ? refNumber/10 : 10;
        model.addAttribute("refPercent", refPercent);  //一个前端用的百分比

        int totalNumber =  Integer.parseInt(author.getPaperNum());
        model.addAttribute("totalNumber", totalNumber);  //成果数
        System.out.println(totalNumber);

        int totalPercent = totalNumber/10 < 10 ? totalNumber/10 : 10;
        model.addAttribute("totalPercent", totalPercent);   //一个前端用的百分比

        model.addAttribute("otherRate", otherNumber*1.0/totalNumber * 100);
        model.addAttribute("journalRate", journalNumber*1.0/totalNumber * 100);
        model.addAttribute("meetingRate", meetingNumber*1.0/totalNumber * 100);
        model.addAttribute("patentRate", patentNumber*1.0/totalNumber * 100);

        model.addAttribute("user", hostHolder.getUser());

        List<Bdxs_paper> list = new ArrayList<>();
        list = bdxs_paperDAO.getPaperByAuthorName(author.getName());
        model.addAttribute("paperList", list);

        try {
            Follow_experts ret = follow_expertsDAO.queryIfFollow(hostHolder.getUser().getId(), Integer.parseInt(expertId));
            if(ret==null)
                model.addAttribute("followResult",0);
            else
                model.addAttribute("followResult",1);
        } catch (Exception ex) {
            model.addAttribute("followResult",-1);
        }

        return "expert";  //html name
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
        return -1;
    }
}
