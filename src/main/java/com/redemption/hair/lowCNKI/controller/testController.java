package com.redemption.hair.lowCNKI.controller;

import com.alibaba.fastjson.JSON;
import com.redemption.hair.lowCNKI.DAO.*;
import com.redemption.hair.lowCNKI.model.*;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index() {

        /*test bdxs_authorDAO
        List<Bdxs_author> authorList1 = bdxs_authorDAO.getAuthorByField("农业经济管理");
        List<Bdxs_author> authorList2 = bdxs_authorDAO.getAuthorByName("其");
        List<Bdxs_author> authorList3 = bdxs_authorDAO.getAuthorByAffiliate("北京大学");
        System.out.println("getAuthorByField"+JSON.toJSONString(authorList1));
        System.out.println("getAuthorByName"+JSON.toJSONString(authorList2));
        System.out.println("selectAuthorByAffiliate"+JSON.toJSONString(authorList3));
         */
        /*test patent_cnkiDAO
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

        return "";
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
    @RequestMapping(path = {"/testSolr"}, method = {RequestMethod.GET})
    @ResponseBody
    public String testSolr() {
        final String SOLR_URL = "http://127.0.0.1:8983/solr/lowCNKI";
        HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL).build();

            List<Bdxs_paper> questionList = new ArrayList<>();
            SolrQuery query = new SolrQuery();
            query.setRows(10);
            query.setStart(0);
            query.setHighlight(true);
            //query.set("q","Title_paper:决策树算法的系统实现与修剪优化");
        String keyword = "人工智能";
        query.set("q", "Title_paper:" + keyword + " OR AuthorName_paper:" + keyword + " OR keywords_paper:" + keyword);
            //query.set("df", "title_paper");
            QueryResponse response = null;
            try {
                response = client.query(query);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(response);
            SolrDocumentList list = response.getResults();
            for (SolrDocument solrDocument : list) {
                String authorName = (String)solrDocument.getFirstValue("AuthorName_paper");
                String title_paper = (String)solrDocument.getFirstValue("Title_paper");
                System.out.println("\nauthorName: "+ authorName + "\ntitle_paper: " + title_paper);
            }
            return "123";
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

    @RequestMapping(path = {"/login"}, method = {RequestMethod.GET})
    public String testLogin() {
        return "login";
    }

    @RequestMapping(path = {"/institution"},method = {RequestMethod.GET})
    public String institution(){
        return "insit";
    }


    @RequestMapping(path = {"/search"}, method = {RequestMethod.GET})
    public String testFreeMarker() {
        return "search";
    }

}
