package com.redemption.hair.lowCNKI.model;

import java.sql.Timestamp;

public class Token {
    private int user_id;
    private String token;
    private Timestamp token_time;
    private int token_valid;

    public Token() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getToken_time() {
        return token_time;
    }

    public void setToken_time(Timestamp token_time) {
        this.token_time = token_time;
    }

    public int getToken_valid() {
        return token_valid;
    }

    public void setToken_valid(int token_valid) {
        this.token_valid = token_valid;
    }
}
