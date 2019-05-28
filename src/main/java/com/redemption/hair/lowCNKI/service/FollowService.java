package com.redemption.hair.lowCNKI.service;


import com.redemption.hair.lowCNKI.DAO.Follow_expertsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    Follow_expertsDAO follow_expertsDAO;


    public boolean follow(int user_id, int expert_id) {
        follow_expertsDAO.addFollow(user_id, expert_id);
        return true;
    }
}
