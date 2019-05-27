package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Follow_expertsDAO {
    String TABLE_NAME = " Follow_experts ";
    String SELECT_FIELDS = "user_id, expert_id";
}
