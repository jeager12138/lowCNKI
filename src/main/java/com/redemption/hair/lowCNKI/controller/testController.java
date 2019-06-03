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
public class testController {

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
    @Autowired
    Bdxs_paperDAO bdxs_paperDAO;
    @Autowired
    Bdxs_authorDAO bdxs_authorDAO;
    @Autowired
    Patent_CNKIDAO patent_cnkiDAO;
    @Autowired
    Wf_organizationDAO wf_organizationDAO;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String index() {
        //test bdxs_authorDAO
        /*
        List<Bdxs_author> authorList1 = bdxs_authorDAO.getAuthorByField("农业经济管理");
        List<Bdxs_author> authorList2 = bdxs_authorDAO.getAuthorByName("其");
        List<Bdxs_author> authorList3 = bdxs_authorDAO.getAuthorByAffiliate("北京大学");
        System.out.println("getAuthorByField: "+JSON.toJSONString(authorList1));
        System.out.println("getAuthorByName: "+JSON.toJSONString(authorList2));
        System.out.println("selectAuthorByAffiliate: "+JSON.toJSONString(authorList3));
        */
        //test patent_cnkiDAO
        /*
        System.out.println(JSON.toJSONString(patent_cnkiDAO.getPatentByName("展示盒")));
        System.out.println(JSON.toJSONString(patent_cnkiDAO.getPatentByInventName("胡明珠")));
        System.out.println(JSON.toJSONString(patent_cnkiDAO.getPatentByAgent_name("杭州君度")));
        System.out.println(JSON.toJSONString(patent_cnkiDAO.getPatentByApply_name("九江学院")));
        System.out.println(JSON.toJSONString(patent_cnkiDAO.getPatentByKeyword("平面镜装置")));
         */
        //test bdxs_paperDAO
        /*
        System.out.println(JSON.toJSONString(bdxs_paperDAO.getPaperByAuthorName("其")));
        System.out.println(JSON.toJSONString(bdxs_paperDAO.getPaperByKeywords("细胞")));
        System.out.println(JSON.toJSONString(bdxs_paperDAO.getPaperByTitle("马克思主义")));
         */
        //test wf_organizationDAO

        System.out.println(JSON.toJSONString((wf_organizationDAO.getOrganizationByName("沈阳大学"))));

        return JSON.toJSONString((wf_organizationDAO.getOrganizationByName("沈阳大学")));
    }

    @RequestMapping(path = {"/blabla"}, method = {RequestMethod.GET})
    @ResponseBody
    public String funcForTest(Model model) {
        //Experts e = expertsDAO.getExpertsByName(expertName);
        //model.addAttribute("expert", e);
        int rid = expertsDAO.getIdbyName("原");
        List<Paper_master> papers = paper_masterDAO.getPaperByRid(rid);
        //model.addAttribute("papers", papers);
        System.out.println("-------a------");
        String str = "";
        for(Paper_master t: papers) {
            str = t.getInstitution();

        }
        return str;
    }

    @RequestMapping(path = {"/test"}, method = {RequestMethod.GET})
    public String test() {
        return "test";
    }

    @RequestMapping(path = {"/essay"}, method = {RequestMethod.GET})
    public String essay() {
        return "essay";
    }

    @RequestMapping(path = {"/expertInfo"},method = {RequestMethod.GET})
    public String expertInfo(){return "expert";}

    @RequestMapping(path = {"/charge"}, method = {RequestMethod.GET})
    public String charge() {
        return "charge";
    }

    @RequestMapping(path = {"/institution"},method = {RequestMethod.GET})
    public String institution(){
        return "insit";
    }
}
