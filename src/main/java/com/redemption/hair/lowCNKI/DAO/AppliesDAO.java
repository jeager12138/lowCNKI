package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppliesDAO {
    String TABLE_NAME = " Applies ";
    String SELECT_FIELDS = "id, expert_id, created_at, content, user_name, expert_name";
}
