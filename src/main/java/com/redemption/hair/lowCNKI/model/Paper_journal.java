package com.redemption.hair.lowCNKI.model;

import java.sql.Timestamp;

public class Paper_journal {
    private int lid;
    private String title;
    private int rid;
    private String summary;
    private String keywords;
    private Timestamp time_;
    private String cited_times;
    private String class_number;
    private String references_;
    private String journal_title;
    private String page_number;
    private String ISSN;

    public Paper_journal() {
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Timestamp getTime_() {
        return time_;
    }

    public void setTime_(Timestamp time_) {
        this.time_ = time_;
    }

    public String getCited_times() {
        return cited_times;
    }

    public void setCited_times(String cited_times) {
        this.cited_times = cited_times;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getReferences_() {
        return references_;
    }

    public void setReferences_(String references_) {
        this.references_ = references_;
    }

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public String getPage_number() {
        return page_number;
    }

    public void setPage_number(String page_number) {
        this.page_number = page_number;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }
}
