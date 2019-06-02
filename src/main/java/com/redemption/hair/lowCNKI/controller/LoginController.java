package com.redemption.hair.lowCNKI.controller;

import com.redemption.hair.lowCNKI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String reg(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpServletResponse response) {

        try {
            Map<String, Object> map = userService.register(username, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                cookie.setMaxAge(3600 * 24 * 5);
                response.addCookie(cookie);
                return "success";
            } else {
                return map.get("msg").toString();
            }
        } catch (Exception e) {
            return "服务器错误";
        }
    }


    @RequestMapping(path = {"/login/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) {
        try {
            Map<String, Object> map = userService.login(username, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                return "success";
            } else {
                return map.get("msg").toString();
            }

        } catch (Exception e) {
            return "服务器错误";
        }
    }

    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);
        return "success";
    }
}
