package com.redemption.hair.lowCNKI.model;

import java.sql.Timestamp;

public class Patents {
    private int pid;
    private int rid;
    private String title;
    private Timestamp application_date;
    private String summary;
    private String class_number;
    private int transfer;
    private Timestamp publication_date;

    public Patents() {
    }

    public Timestamp getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Timestamp application_date) {
        this.application_date = application_date;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTransfer() {
        return transfer;
    }

    public void setTransfer(int transfer) {
        this.transfer = transfer;
    }

    public Timestamp getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Timestamp publication_date) {
        this.publication_date = publication_date;
    }
}
