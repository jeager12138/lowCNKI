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
public class SearchResultController {

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

    @RequestMapping(path = {"/SearchPaperResult"},method = {RequestMethod.GET})
    public String SearchResult(Model model,
                               @RequestParam("searchType")String searchType,
                               @RequestParam("searchBy")String searchBy,
                               @RequestParam("searchString")String searchString){
        if(searchType.equals("journal")){
            if(searchBy.equals("title")){
                List<Paper_journal> p = paper_journalDAO.getJournalByTitle(searchString);
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("author")){
                List<Paper_journal> p = paper_journalDAO.getJournalByRid(expertsDAO.getIdbyName(searchString));
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("keyword")){
                List<Paper_journal> p = paper_journalDAO.getJournalByKeyword(searchString);
                model.addAttribute("PaperList",p );
            }
            else{
                List<Paper_journal> p1 = paper_journalDAO.getJournalByTitle(searchString);
                List<Paper_journal> p2 = paper_journalDAO.getJournalByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_journal> p3 = paper_journalDAO.getJournalByKeyword(searchString);
                p1.addAll(p2);p1.addAll(p3);
                model.addAttribute("PaperList",p1 );
            }
        }
        else if (searchType.equals("master")){
            if(searchBy.equals("title")){
                List<Paper_master> p = paper_masterDAO.getMasterByTitle(searchString);
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("author")){
                List<Paper_master> p = paper_masterDAO.getMasterByRid(expertsDAO.getIdbyName(searchString));
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("keyword")){
                List<Paper_master> p = paper_masterDAO.getMasterByKeyword(searchString);
                model.addAttribute("PaperList",p );
            }
            else{
                List<Paper_master> p1 = paper_masterDAO.getMasterByTitle(searchString);
                List<Paper_master> p2 = paper_masterDAO.getMasterByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_master> p3 = paper_masterDAO.getMasterByKeyword(searchString);
                p1.addAll(p2);p1.addAll(p3);
                model.addAttribute("PaperList",p1 );
            }
        }
        else if (searchType.equals("meeting")){
            if(searchBy.equals("title")){
                List<Paper_meeting> p = paper_meetingDAO.getMeetingByTitle(searchString);
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("author")){
                List<Paper_meeting> p = paper_meetingDAO.getMeetingByRid(expertsDAO.getIdbyName(searchString));
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("keyword")){
                List<Paper_meeting> p = paper_meetingDAO.getMeetingByKeyword(searchString);
                model.addAttribute("PaperList",p );
            }
            else{
                List<Paper_meeting> p1 = paper_meetingDAO.getMeetingByTitle(searchString);
                List<Paper_meeting> p2 = paper_meetingDAO.getMeetingByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_meeting> p3 = paper_meetingDAO.getMeetingByKeyword(searchString);
                p1.addAll(p2);p1.addAll(p3);
                model.addAttribute("PaperList",p1 );
            }
        }
        else if (searchType.equals("patent")){
            if(searchBy.equals("title")){
                List<Patents> p = patentsDAO.getPatentsByTitle(searchString);
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("author")){
                List<Patents> p = patentsDAO.getPatentsByRid(expertsDAO.getIdbyName(searchString));
                model.addAttribute("PaperList",p );
            }
            else if(searchBy.equals("keyword")){
                List<Patents> p = patentsDAO.getPatentsByKeyword(searchString);
                model.addAttribute("PaperList",p );
            }
            else{
                List<Patents> p1 = patentsDAO.getPatentsByTitle(searchString);
                List<Patents> p2 = patentsDAO.getPatentsByRid(expertsDAO.getIdbyName(searchString));
                List<Patents> p3 = patentsDAO.getPatentsByKeyword(searchString);
                p1.addAll(p2);p1.addAll(p3);
                model.addAttribute("PaperList",p1 );
            }
        }
        else{
            if(searchBy.equals("title")){
                List<Paper_journal> pj = paper_journalDAO.getJournalByTitle(searchString);
                List<Paper_master> pma = paper_masterDAO.getMasterByTitle(searchString);
                List<Paper_meeting> pme = paper_meetingDAO.getMeetingByTitle(searchString);
            }
            else if(searchBy.equals("author")){
                List<Paper_journal> pj = paper_journalDAO.getJournalByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_master> pma = paper_masterDAO.getMasterByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_meeting> pme = paper_meetingDAO.getMeetingByRid(expertsDAO.getIdbyName(searchString));
            }
            else if(searchBy.equals("keyword")){
                List<Paper_journal> pj = paper_journalDAO.getJournalByKeyword(searchString);
                List<Paper_master> pma = paper_masterDAO.getMasterByKeyword(searchString);
                List<Paper_meeting> pme = paper_meetingDAO.getMeetingByKeyword(searchString);
            }
            else{
                List<Paper_journal> pj1 = paper_journalDAO.getJournalByTitle(searchString);
                List<Paper_master> pma1 = paper_masterDAO.getMasterByTitle(searchString);
                List<Paper_meeting> pme1 = paper_meetingDAO.getMeetingByTitle(searchString);
                List<Paper_journal> pj2 = paper_journalDAO.getJournalByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_master> pma2 = paper_masterDAO.getMasterByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_meeting> pme2 = paper_meetingDAO.getMeetingByRid(expertsDAO.getIdbyName(searchString));
                List<Paper_journal> pj3 = paper_journalDAO.getJournalByKeyword(searchString);
                List<Paper_master> pma3 = paper_masterDAO.getMasterByKeyword(searchString);
                List<Paper_meeting> pme3 = paper_meetingDAO.getMeetingByKeyword(searchString);
                pj1.addAll(pj2);pj1.addAll(pj3);
                pma1.addAll(pma2);pma1.addAll(pma3);
                pme1.addAll(pme2);pme1.addAll(pme3);
            }
        }
        return "";
    }

    @RequestMapping(path = {"/SearchExpertResult"},method = {RequestMethod.GET})
    @ResponseBody
    public String SearchExpertResult(Model model,
                                     @RequestParam("searchBy")String searchBy,
                                     @RequestParam("searchString")String searchString){
        if(searchBy.equals("name")){
            Experts e = expertsDAO.getExpertsByName(searchString);
            model.addAttribute("ExpertList",e );
        }
        else if(searchBy.equals("field")){
            List<Experts> e = expertsDAO.getExpertsByMajor(searchString);
            model.addAttribute("ExpertList",e );
        }
        else{
            List<Experts> e = expertsDAO.getExpertsByInstitution(searchString);
            model.addAttribute("ExpertList",e );
        }

        return  "";
    }
}
