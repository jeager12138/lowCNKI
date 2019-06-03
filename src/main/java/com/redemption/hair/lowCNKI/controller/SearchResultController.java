package com.redemption.hair.lowCNKI.controller;


import com.alibaba.fastjson.JSON;
import com.redemption.hair.lowCNKI.DAO.*;
import com.redemption.hair.lowCNKI.model.*;
import com.redemption.hair.lowCNKI.service.SolrService;
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
    @Autowired
    SolrService solrService;


    @RequestMapping(path = {"/SearchPaperResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchPaperResult(String searchString,String searchBy) throws Exception {
        List<Bdxs_paper> paperList = solrService.searchPaper(searchBy, searchString, 0, 100);

        return JSON.toJSONString(paperList);
    }

    @RequestMapping(path = {"/SearchPatentResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchPatentResult(String searchString,String searchBy) throws Exception {
        List<Patent_CNKI> patent_cnkiList = solrService.searchPatent(searchBy, searchString, 0, 100);

        return JSON.toJSONString(patent_cnkiList);
    }


    @RequestMapping(path = {"/SearchExpertResult"},method = {RequestMethod.POST})
    @ResponseBody
    public String SearchExpertResult(String searchString,String searchBy) throws Exception {
        List<Bdxs_author> bdxs_authorList = solrService.searchAuthor(searchBy, searchString, 0, 100);

        return  JSON.toJSONString(bdxs_authorList);
    }
}
