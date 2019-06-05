package com.redemption.hair.lowCNKI.controller;

import com.redemption.hair.lowCNKI.DAO.Bdxs_authorDAO;
import com.redemption.hair.lowCNKI.DAO.Bdxs_paperDAO;
import com.redemption.hair.lowCNKI.model.Bdxs_paper;
import com.redemption.hair.lowCNKI.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaperDetailsController {
    @Autowired
    Bdxs_paperDAO bdxs_paperDAO;
    @Autowired
    SolrService solrService;
    @Autowired
    Bdxs_authorDAO bdxs_authorDAO;

    @RequestMapping(path = {"/essay"}, method = RequestMethod.GET)
    public String essay(Model model, @RequestParam("paperId")int paperId, @RequestParam("page")int page) throws Exception {
        Bdxs_paper paper = new Bdxs_paper();
        paper = bdxs_paperDAO.getPaperById(paperId);
        model.addAttribute("essayInfo", paper);

        int refNumber = Integer.parseInt(paper.getCited())/10 > 10 ? 10 : Integer.parseInt(paper.getCited())/10;
        model.addAttribute("refNumber",refNumber);


        String ScholarID = "CN-B07300AJ";
        try {
            List<String> slist = bdxs_authorDAO.getAuthorIdName(paper.getAuthorName());
            if (slist != null)
                ScholarID = slist.get(0);
        }
        catch (Exception ex){
            ScholarID = " ";
        }
        List<Bdxs_paper> list = new ArrayList<>();
        list = solrService.searchPaper("title", paper.getTitle(), (page-1)*10 ,10);
        model.addAttribute("refEssayList", list);
        model.addAttribute("scholarId",ScholarID);

        //int pageNum = (int)(Math.ceil(list.size()/10.0));
        int pageNum = 15;
        int pageLeft = (page-5)>=1?page-2:1;
        int pageRight = (page+5)<=pageNum?page+5:pageNum;

        model.addAttribute("pageCur",page);
        model.addAttribute("pageLeft",pageLeft);
        model.addAttribute("pageRight",pageRight);
        return "essay";
    }
}
