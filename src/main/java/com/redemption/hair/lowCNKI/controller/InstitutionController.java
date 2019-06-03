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
        Wf_organization wf = wf_organizationDAO.getOrganizationByName("沈阳大学");
        wf.setNum_cited("12456");
        wf.setNum_papers("1245");
        model.addAttribute("institution",wf);
        return "insit";
    }
}
