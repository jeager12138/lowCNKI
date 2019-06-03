package com.redemption.hair.lowCNKI.controller;

import com.alibaba.fastjson.JSON;
import com.redemption.hair.lowCNKI.DAO.Wf_organizationDAO;
import com.redemption.hair.lowCNKI.model.Wf_organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InstitutionController {
    @Autowired
    Wf_organizationDAO wf_organizationDAO;
    @RequestMapping(path = {"/institutionInfo"}, method = {RequestMethod.GET})
    public String institutionInfo(Model model){
        System.out.println(JSON.toJSONString((wf_organizationDAO.getOrganizationByName("沈阳大学"))));
        String name = "北京大学";
        Wf_organization wf = wf_organizationDAO.getOrganizationByName(name);
        wf.setNum_cited(wf_organizationDAO.getNum_citedByName(name));
        wf.setNum_papers(wf_organizationDAO.getNum_papersByName(name));
        wf.setCore_inclusion(wf_organizationDAO.getCore_inclusionByName(name));
        wf.setHighest_cited(wf_organizationDAO.getHighest_citedByName(name));
        wf.setNum_experts(wf_organizationDAO.getNum_expertsByName(name));
        wf.setRepre_author(wf_organizationDAO.getRepre_authorByName(name));
        model.addAttribute("institution",wf);
        return "insit";
    }
}
