package com.redemption.hair.lowCNKI.model;

import java.util.Timer;
import java.sql.Timestamp;

public class Applies {
    private int id;
    private int expert_id;
    private Timestamp created_at;
    private String content;
    private String user_name;
    private String expert_name;

    public Applies() {

    }

    public int getId() {
        return id;
    }

    public int getExpert_id() {
        return expert_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public String getContent() {
        return content;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public void setContent(String content) {
        this.content = content;
    };

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

}
