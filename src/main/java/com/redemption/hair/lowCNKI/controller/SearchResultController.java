package com.redemption.hair.lowCNKI.controller;


import com.alibaba.fastjson.JSON;
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
    Bdxs_paperDAO bdxs_paperDAO;
    @Autowired
    Patent_CNKIDAO patent_cnkiDAO;
    @Autowired
    Bdxs_authorDAO bdxs_authorDAO;

    @RequestMapping(path = {"/SearchPaperResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchPaperResult(String searchString,String searchBy){
        List<Bdxs_paper> paperList = null;
        if(searchBy.equals("title")){
            paperList =  bdxs_paperDAO.getPaperByTitle(searchString);
        }
        else if(searchBy.equals("author")){
            paperList =  bdxs_paperDAO.getPaperByAuthorName(searchString);
        }
        else if(searchBy.equals("keyword")){
            paperList =  bdxs_paperDAO.getPaperByKeywords(searchString);
        }
        else{
            paperList = bdxs_paperDAO.getPaperByTitle(searchString);
            paperList.addAll(bdxs_paperDAO.getPaperByAuthorName(searchString));
            paperList.addAll(bdxs_paperDAO.getPaperByKeywords(searchString));
        }
        //System.out.println(JSON.toJSONString(paperList));
        return JSON.toJSONString(paperList);
    }

    @RequestMapping(path = {"/SearchPatentResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchPatentResult(String searchString,String searchBy){
        List<Patent_CNKI> patent_cnkiList = null;
        if(searchBy.equals("invent_name")){
            patent_cnkiList =  patent_cnkiDAO.getPatentByInventName(searchString);
        }
        else if(searchBy.equals("name")){
            patent_cnkiList =  patent_cnkiDAO.getPatentByName(searchString);
        }
        else if(searchBy.equals("institution")){
            patent_cnkiList =  patent_cnkiDAO.getPatentByAgent_name(searchString);
            patent_cnkiList.addAll(patent_cnkiDAO.getPatentByApply_name(searchString));
        }
        else if(searchBy.equals("keyword")){
            patent_cnkiList =  patent_cnkiDAO.getPatentByKeyword(searchString);
        }
        else{
            patent_cnkiList =  patent_cnkiDAO.getPatentByInventName(searchString);
            patent_cnkiList.addAll(patent_cnkiDAO.getPatentByName(searchString));
            patent_cnkiList.addAll(patent_cnkiDAO.getPatentByAgent_name(searchString));
            patent_cnkiList.addAll(patent_cnkiDAO.getPatentByApply_name(searchString));
            patent_cnkiList.addAll(patent_cnkiDAO.getPatentByKeyword(searchString));
        }
        return JSON.toJSONString(patent_cnkiList);
    }


    @RequestMapping(path = {"/SearchExpertResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchExpertResult(String searchString,String searchBy){
        List<Bdxs_author> bdxs_authorList = null;
        if(searchBy.equals("name")){
            bdxs_authorList = bdxs_authorDAO.getAuthorByName(searchString);
        }
        else if(searchBy.equals("field")){
            bdxs_authorList = bdxs_authorDAO.getAuthorByField(searchString);
        }
        else if(searchBy.equals("institution")){
            bdxs_authorList = bdxs_authorDAO.getAuthorByAffiliate(searchString);
        }else{
            bdxs_authorList = bdxs_authorDAO.getAuthorByName(searchString);
            bdxs_authorList.addAll(bdxs_authorDAO.getAuthorByField(searchString));
            bdxs_authorList.addAll(bdxs_authorDAO.getAuthorByAffiliate(searchString));
        }
        return  JSON.toJSONString(bdxs_authorList);
    }
}
