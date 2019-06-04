package com.redemption.hair.lowCNKI.controller;


import com.alibaba.fastjson.JSON;
import com.redemption.hair.lowCNKI.DAO.*;
import com.redemption.hair.lowCNKI.model.*;
import com.redemption.hair.lowCNKI.service.SolrService;
import com.redemption.hair.lowCNKI.utils.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
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
    @Autowired
    JedisAdapter jedisAdapter;
    @Autowired
    HostHolder hostHolder;


    @RequestMapping(path = {"/SearchPaperResult"},method = {RequestMethod.POST})
    public String SearchPaperResult(Model model, String searchString, String searchBy, int page) throws Exception {
        searchString=URLDecoder.decode(searchString, "UTF-8");
        System.out.println(searchString);
        System.out.println(searchBy);
        System.out.println(page);
        List<Bdxs_paper> paperList = solrService.searchPaper(searchBy, searchString, (page-1)*10, 10);

        model.addAttribute("paperList", paperList);
        if(hostHolder.getUser() != null) {
            jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
        }
        for(Bdxs_paper paper:paperList){
            System.out.println(paper.getTitle());
        }
        return "result";
    }

    @RequestMapping(path = {"/SearchPatentResult"},method = {RequestMethod.POST})
    public String SearchPatentResult(Model model, String searchString, String searchBy, int page) throws Exception {
        searchString=URLDecoder.decode(searchString, "UTF-8");
        List<Patent_CNKI> patent_cnkiList = solrService.searchPatent(searchBy, searchString, (page-1)*10, 10);

        model.addAttribute("patentList", patent_cnkiList);
        if(hostHolder.getUser() != null) {
            jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
        }
        return "result";
    }


    @RequestMapping(path = {"/SearchExpertResult"},method = {RequestMethod.POST})
    public String SearchExpertResult(Model model, String searchString, String searchBy, int page) throws Exception {
        searchString=URLDecoder.decode(searchString, "UTF-8");
        List<Bdxs_author> bdxs_authorList = solrService.searchAuthor(searchBy, searchString, (page-1)*10, 10);

        model.addAttribute("expertList", bdxs_authorList);
        if(hostHolder.getUser() != null) {
            jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
        }
        return  "result";
    }

    @RequestMapping(path = {"/Recommend"}, method = RequestMethod.GET)
    public String Recommend(Model model) throws Exception{
        List<Bdxs_paper> bdxs_paperList = solrService.searchPaper("title", "人工智能", 0, 10);

        model.addAttribute("recommendPaper", bdxs_paperList);
        return "result";
    }
}
