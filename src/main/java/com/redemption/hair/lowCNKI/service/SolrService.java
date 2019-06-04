package com.redemption.hair.lowCNKI.service;


import com.redemption.hair.lowCNKI.model.Bdxs_author;
import com.redemption.hair.lowCNKI.model.Bdxs_paper;
import com.redemption.hair.lowCNKI.model.Patent_CNKI;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolrService {
    //private final String SOLR_URL = "http://10.72.148.82:8983/solr/lowCNKI";
    private final String SOLR_URL = "http://192.144.201.108:8983/solr/lowCNKI";

    private HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL).build();


    public List<Bdxs_paper> searchPaper(String searchBy, String keyword, int offset, int count) throws Exception {
        List<Bdxs_paper> paperList = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        query.setRows(count);
        query.setStart(offset);

        if (searchBy.equals("title")) {
            query.set("q", "Title_paper:" + keyword);
        } else if (searchBy.equals("author")) {
            query.set("q", "AuthorName_paper:" + keyword);
        } else if (searchBy.equals("keyword")) {
            query.set("q", "keywords_paper:" + keyword);
        } else {
            query.set("q", "Title_paper:" + keyword + " OR AuthorName_paper:" + keyword + " OR keywords_paper:" + keyword);
        }
        QueryResponse response = null;
        response = client.query(query);

        SolrDocumentList list = response.getResults();
        for (SolrDocument solrDocument : list) {
            // Todo
            Bdxs_paper paper = new Bdxs_paper();
            paper.setPaperId(Integer.parseInt((String)solrDocument.getFirstValue("paperId_paper")));
            paper.setAuthorName((String)solrDocument.getFirstValue("AuthorName_paper"));
            paper.setTitle((String)solrDocument.getFirstValue("Title_paper"));
            paper.setSummary((String)solrDocument.getFirstValue("Summary_paper"));
            paper.setCited((String)solrDocument.getFirstValue("Cited_paper"));
            paper.setDoi((String)solrDocument.getFirstValue("Summary_paper"));
            paper.setDownLoadUrl((String)solrDocument.getFirstValue("Doi_paper"));
            paper.setFields((String)solrDocument.getFirstValue("Fields_paper"));
            paper.setKeywords((String)solrDocument.getFirstValue("keywords_paper"));
            paperList.add(paper);
        }

        return paperList;
    }

    public List<Bdxs_author> searchAuthor(String searchBy, String keyword, int offset, int count) throws Exception {
        List<Bdxs_author> authorList = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        query.setRows(count);
        query.setStart(offset);

        if (searchBy.equals("field")) {
            query.set("q", "Field_author:" + keyword);
        } else if (searchBy.equals("name")) {
            query.set("q", "Name_author:" + keyword);
        } else if (searchBy.equals("institution")) {
            query.set("q", "Affiliate_author:" + keyword);
        } else {
            query.set("q", "Field_author:" + keyword + " OR Name_author:" + keyword + " OR Affiliate_author:" + keyword);
        }

        QueryResponse response = null;
        response = client.query(query);

        SolrDocumentList list = response.getResults();
        for (SolrDocument solrDocument : list) {
            //Todo
            Bdxs_author author = new Bdxs_author();
            author.setScholarId((String)solrDocument.getFirstValue("scholarId_author"));
            author.setAffiliate((String)solrDocument.getFirstValue("Affiliate_author"));
            author.setName((String)solrDocument.getFirstValue("Name_author"));
            author.setCited((String)solrDocument.getFirstValue("Cited_author"));
            author.setField((String)solrDocument.getFirstValue("Field_author"));
            author.setPaperNum((String)solrDocument.getFirstValue("paperNum_author"));
            authorList.add(author);
        }

        return authorList;
    }

    public List<Patent_CNKI> searchPatent(String searchBy, String keyword, int offset, int count) throws Exception {
        List<Patent_CNKI> patentList = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        query.setRows(count);
        query.setStart(offset);

        if (searchBy.equals("name")) {
            query.set("q", "Name_patent:" + keyword);
        } else if (searchBy.equals("invent_name")) {
            query.set("q", "invent_name_patent:" + keyword);
        } else if (searchBy.equals("institution")) {
            query.set("q", "apply_name_patent:" + keyword + " OR agent_name_patent:" + keyword);
        } else if (searchBy.equals("keyword")) {
            query.set("q", "abstract_patent:" + keyword);
        } else {
            query.set("q", "Name_patent:" + keyword + " OR invent_name_patent:" + keyword + " OR apply_name_patent:" + keyword + " OR abstract_patent:" + keyword);
        }

        QueryResponse response = null;
        response = client.query(query);

        SolrDocumentList list = response.getResults();
        for (SolrDocument solrDocument : list) {
            //Todo
            Patent_CNKI patent = new Patent_CNKI();
            patent.setAbstract_((String)solrDocument.getFirstValue("abstract_patent"));
            patent.setAddress((String)solrDocument.getFirstValue("Address_patent"));
            patent.setName((String)solrDocument.getFirstValue("Name_patent"));
            patent.setAgent_name((String)solrDocument.getFirstValue("agent_name_patent"));
            patentList.add(patent);
        }

        return patentList;
    }

}
