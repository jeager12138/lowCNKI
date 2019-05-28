package com.redemption.hair.lowCNKI.model;

import java.sql.Timestamp;
import java.util.Date;

public class Paper_master {
    private int lid;
    private String title;
    private int rid;
    private String summary;
    private String keywords;
    private Timestamp time_;
    private int page_number;
    private String cited_times;
    private String class_number;
    private String download_times;
    private String references_;
    private String institution;
    private String year;
    private String tutor;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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


    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
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

    public String getDownload_times() {
        return download_times;
    }

    public void setDownload_times(String download_times) {
        this.download_times = download_times;
    }

    public Timestamp getTime_() {
        return time_;
    }

    public void setTime_(Timestamp time_) {
        this.time_ = time_;
    }

    public String getReferences_() {
        return references_;
    }

    public void setReferences_(String references_) {
        this.references_ = references_;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
