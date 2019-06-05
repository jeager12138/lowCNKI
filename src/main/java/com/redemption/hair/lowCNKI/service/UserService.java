package com.redemption.hair.lowCNKI.service;

import com.redemption.hair.lowCNKI.DAO.TokenDAO;
import com.redemption.hair.lowCNKI.DAO.UsersDAO;
import com.redemption.hair.lowCNKI.model.Token;
import com.redemption.hair.lowCNKI.model.Users;
import com.redemption.hair.lowCNKI.utils.lowCNKIutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UsersDAO usersDAO;
    @Autowired
    TokenDAO tokenDAO;

    public Users selectByName(String name) {
        return usersDAO.selectByName(name);
    }

    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        Users user = usersDAO.selectByName(username);

        if (user != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new Users();
        user.setNickname(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setAvator(head);
        user.setPassword(lowCNKIutils.MD5(password+user.getSalt()));
        usersDAO.addUser(user);


        // 登陆
        String ticket = addLoginTicket(usersDAO.selectByName(username).getId());
        map.put("ticket", ticket);
        return map;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        Users user = null;
        try{
            user = usersDAO.selectByName(username);
        }
        catch(Exception e){
            map.put("msg", "用户名不存在");
            return map;
        }

        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if (!lowCNKIutils.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {

        Token ticket = new Token();
        ticket.setUser_id(userId);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime() + 1000*3600*24);
        ticket.setToken_time(ts);
        ticket.setToken_valid(0);
        ticket.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenDAO.addToken(ticket);
        return ticket.getToken();
    }

    public Users getUser(int id) {
        return usersDAO.selectById(id);
    }

    public void logout(String ticket) {
        tokenDAO.updateTokenValid(ticket, 1);
    }
}
