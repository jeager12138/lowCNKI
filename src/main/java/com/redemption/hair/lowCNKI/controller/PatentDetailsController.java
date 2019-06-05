package com.redemption.hair.lowCNKI.controller;

import com.redemption.hair.lowCNKI.DAO.Bdxs_authorDAO;
import com.redemption.hair.lowCNKI.DAO.Bdxs_paperDAO;
import com.redemption.hair.lowCNKI.DAO.Patent_CNKIDAO;
import com.redemption.hair.lowCNKI.model.Bdxs_paper;
import com.redemption.hair.lowCNKI.model.Patent_CNKI;
import com.redemption.hair.lowCNKI.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatentDetailsController {
    @Autowired
    SolrService solrService;
    @Autowired
    Patent_CNKIDAO patent_cnkidao;

    @RequestMapping(path = {"/patent"}, method = RequestMethod.GET)
    public String patent(Model model, @RequestParam("pubNum")String pubNum) throws Exception {
        Patent_CNKI patent = patent_cnkidao.getPatentByPubNum(pubNum);
        patent.setPub_number(pubNum);
        patent.setPub_date(patent_cnkidao.getPatentpub_dateByPubNum(pubNum));
        patent.setApply_name(patent_cnkidao.getPatentapply_nameByPubNum(pubNum));
        patent.setAbstract_(patent_cnkidao.getPatentabstract_ByPubNum(pubNum));
        patent.setAddress(patent_cnkidao.getPatentaddressByPubNum(pubNum));
        patent.setAgent_name(patent_cnkidao.getPatentagent_nameByPubNum(pubNum));
        patent.setAgent_man(patent_cnkidao.getPatentagent_manByPubNum(pubNum));
        patent.setApply_date(patent_cnkidao.getPatentapply_dateByPubNum(pubNum));
        patent.setApply_num(patent_cnkidao.getPatentapply_numByPubNum(pubNum));
        patent.setInvent_name(patent_cnkidao.getPatentinvent_nameByPubNum(pubNum));
        model.addAttribute("patent",patent);
        return "patent";
    }
}
