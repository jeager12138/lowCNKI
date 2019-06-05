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


    @RequestMapping(path = {"/SearchPaperResult"},method = {RequestMethod.GET})
    public String SearchPaperResult(Model model,
                                    @RequestParam("searchString")String searchString,
                                    @RequestParam("searchBy")String searchBy,
                                    @RequestParam("searchType")String searchType,
                                    @RequestParam("page")int page) throws Exception {
        searchString=URLDecoder.decode(searchString, "UTF-8");

        if(searchType.equals("paper")) {
            List<Bdxs_paper> paperList = (List<Bdxs_paper>)solrService.searchPaper(searchBy, searchString, (page-1)*10, 10).get("paperList");

            long Num = (long)(solrService.searchPaper(searchBy, searchString, (page-1)*10, 10).get("num"));
            long pageNum = (long)(Math.ceil(Num/10.0));
            long pageLeft = (page-5)>=1?page-2:1;
            long pageRight = (page+5)<=pageNum?page+5:pageNum;
            model.addAttribute("user", hostHolder.getUser());

            System.out.println(pageNum);
            System.out.println(pageLeft);
            System.out.println(pageRight);
            System.out.println(page);
            model.addAttribute("pageCur",page);
            model.addAttribute("pageLeft",pageLeft);
            model.addAttribute("pageRight",pageRight);
            model.addAttribute("paperList", paperList);

            List<Bdxs_paper> recommendPaper = (List<Bdxs_paper>)solrService.searchPaper("title", "人工智能", 0, 10).get("paperList");

            model.addAttribute("recommendPaper", recommendPaper);

            if(hostHolder.getUser() != null) {
                jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
            }
        } else if (searchType.equals("patent")) {
            List<Patent_CNKI> patent_cnkiList = (List<Patent_CNKI>) solrService.searchPatent(searchBy, searchString, (page-1)*10, 10).get("patentList");

            long Num = (long)solrService.searchPatent(searchBy, searchString, (page-1)*10, 10).get("num");
            long pageNum = (long)(Math.ceil(Num/10.0));
            long pageLeft = (page-5)>=1?page-2:1;
            long pageRight = (page+5)<=pageNum?page+5:pageNum;
            model.addAttribute("user", hostHolder.getUser());
//            System.out.println("print id"+hostHolder.getUser().getId());
            model.addAttribute("pageCur",page);
            model.addAttribute("pageLeft",pageLeft);
            model.addAttribute("pageRight",pageRight);
            model.addAttribute("patentList", patent_cnkiList);

            List<Bdxs_paper> recommendPaper =  (List<Bdxs_paper>)solrService.searchPaper("title", "人工智能", 0, 10).get("paperList");

            model.addAttribute("recommendPaper", recommendPaper);

            if(hostHolder.getUser() != null) {
                jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
            }
        } else {
            List<Bdxs_author> bdxs_authorList = (List<Bdxs_author>) solrService.searchAuthor(searchBy, searchString, (page-1)*10, 10).get("authorList");
            long Num = (long)solrService.searchAuthor(searchBy, searchString, (page-1)*10, 10).get("num");
            long pageNum = (long)(Math.ceil(Num/10.0));
            long pageLeft = (page-5)>=1?page-2:1;
            long pageRight = (page+5)<=pageNum?page+5:pageNum;
            model.addAttribute("user", hostHolder.getUser());
            model.addAttribute("pageCur",page);
            model.addAttribute("pageLeft",pageLeft);
            model.addAttribute("pageRight",pageRight);
            model.addAttribute("expertList", bdxs_authorList);

            List<Bdxs_paper> recommendPaper = (List<Bdxs_paper>)solrService.searchPaper("title", "人工智能", 0, 10).get("paperList");

            model.addAttribute("recommendPaper", recommendPaper);

            if(hostHolder.getUser() != null) {
                jedisAdapter.addSearchHistory(String.valueOf(hostHolder.getUser().getId()), searchString);
            }
        }

        return "result";
    }


//    @RequestMapping(path = {"/SearchPatentResult"},method = {RequestMethod.GET})
//    public String SearchPatentResult(Model model, String searchString, String searchBy, int page) throws Exception {
//        searchString=URLDecoder.decode(searchString, "UTF-8");
//
//        return "result";
//    }
//
//
//    @RequestMapping(path = {"/SearchExpertResult"},method = {RequestMethod.GET})
//    public String SearchExpertResult(Model model, String searchString, String searchBy, int page) throws Exception {
//        searchString=URLDecoder.decode(searchString, "UTF-8");
//
//        return  "result";
//    }

}
