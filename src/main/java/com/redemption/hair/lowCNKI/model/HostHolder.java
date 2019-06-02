package com.redemption.hair.lowCNKI.model;


import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<Users> users = new ThreadLocal<Users>();

    public Users getUser() {
        return users.get();
    }

    public void setUser(Users user) {
        users.set(user);
    }

    public void clear() {
        users.remove();;
    }
}