package com.redemption.hair.lowCNKI.controller;


import com.redemption.hair.lowCNKI.DAO.Co_expertsDAO;
import com.redemption.hair.lowCNKI.DAO.ExpertsDAO;
import com.redemption.hair.lowCNKI.DAO.Follow_expertsDAO;
import com.redemption.hair.lowCNKI.DAO.Paper_masterDAO;
import com.redemption.hair.lowCNKI.DAO.Paper_journalDAO;
import com.redemption.hair.lowCNKI.DAO.Paper_meetingDAO;
import com.redemption.hair.lowCNKI.DAO.PatentsDAO;
import com.redemption.hair.lowCNKI.model.*;
import com.redemption.hair.lowCNKI.service.FollowService;
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

    @RequestMapping(path = {"/expert"}, method = {RequestMethod.GET})
    public String getExpertInformation(Model model, @RequestParam("ExpertId")int expertId) {
        Experts e = expertsDAO.getExpertsById(expertId);
        model.addAttribute("expert", e);                     //专家信息

        List<Paper_master> masterList = paper_masterDAO.getPaperByRid(expertId);
        List<Paper_journal> journalList = paper_journalDAO.getJournalByRid(expertId);
//        List<Paper_meeting> meetingList = paper_meetingDAO.getMeetingByRid(expertId);
//        List<Patents> patentList = patentsDAO.getPatentsByRid(expertId);

        model.addAttribute("masterList", masterList);         //博硕
        model.addAttribute("journalList",journalList);        //期刊
//        model.addAttribute("meetingList",meetingList);        //会议
//        model.addAttribute("patentList",patentList);          //专利

        int masterNumber = 0;
        int journalNumber = 0;
        int meetingNumber = 0;
        int patentNumber = 0;
        double masterRate= 0;
        double journalRate = 0;
        double meetingRate = 0;
        double patentRate = 0;
        if (masterList != null)
             masterNumber = masterList.size();
        if (journalList != null)
            journalNumber = journalList.size();
//        if (meetingList != null)
//            meetingNumber = meetingList.size();
//        if (patentList != null)
//            patentNumber = patentList.size();

        model.addAttribute("masterNumber",masterNumber);  //博硕数
        model.addAttribute("journalNumber",journalNumber); //期刊数
        model.addAttribute("meetingNumber",meetingNumber); // 会议数
        model.addAttribute("patentNumber",patentNumber); //专利数

        int refNumber = 0;       //TODO 被引频次 这个东西要不要写
        model.addAttribute("refNumber",refNumber);  //被引频次

        int refPercent = refNumber/100 < 10 ? refNumber/100 : 10;
        model.addAttribute("refPercent",refPercent);  //一个前端用的百分比

        int totalNumber =  masterNumber + journalNumber + meetingNumber + patentNumber;
        model.addAttribute("totalNumber",totalNumber);  //成果数

        int totalPercent = totalNumber/100 < 10 ? totalNumber/100 : 10;
        model.addAttribute("totalPercent",totalPercent);   //一个前端用的百分比

        if (totalNumber != 0){
            masterRate = masterNumber / totalNumber *100.0;
            journalRate = journalNumber / totalNumber *100.0;
            meetingRate = meetingNumber / totalNumber *100.0;
            patentRate = patentNumber / totalNumber *100.0;
        }

        model.addAttribute("masterRate",masterRate);
        model.addAttribute("journalRate",journalRate);
        model.addAttribute("meetingRate",meetingRate);
        model.addAttribute("patentRate",patentRate);
        return "expert";  //html name
    }

//    @RequestMapping(path = {"/getExpertPaper"}, method = {RequestMethod.GET})
//    public String getExpertPaper(Model model, @RequestParam("ExpertId")int rid) {
//
//        return "";  //html name
//    }

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
