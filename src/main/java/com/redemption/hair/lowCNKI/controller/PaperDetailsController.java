package com.redemption.hair.lowCNKI.controller;

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

    @RequestMapping(path = {"/essay"}, method = RequestMethod.GET)
    public String essay(Model model, @RequestParam("paperId")int paperId, @RequestParam("page")int page) throws Exception {
        Bdxs_paper paper = new Bdxs_paper();
        paper = bdxs_paperDAO.getPaperById(paperId);
        model.addAttribute("essayInfo", paper);

        List<Bdxs_paper> list = new ArrayList<>();
        list = solrService.searchPaper("title", paper.getTitle(), (page-1)*10 ,10);
        model.addAttribute("refEssayList", list);
        return "essay";
    }
}
