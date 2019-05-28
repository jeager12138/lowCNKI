package com.redemption.hair.lowCNKI.interceptor;

import com.redemption.hair.lowCNKI.DAO.TokenDAO;
import com.redemption.hair.lowCNKI.DAO.UsersDAO;
import com.redemption.hair.lowCNKI.model.HostHolder;
import com.redemption.hair.lowCNKI.model.Token;
import com.redemption.hair.lowCNKI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenDAO tokenDAO;

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }

        if (ticket != null) {
            Token loginTicket = tokenDAO.selectByToken(ticket);
            if (loginTicket == null || loginTicket.getToken_time().before(new Date()) || loginTicket.getToken_valid() != 0) {
                return true;
            }

            Users user = usersDAO.selectById(loginTicket.getUser_id());
            hostHolder.setUser(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && hostHolder.getUser() != null) {
            modelAndView.addObject("user", hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}

