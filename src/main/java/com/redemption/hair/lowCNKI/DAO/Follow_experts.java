package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Follow_experts {
    String TABLE_NAME = " Follow_experts ";
    String SELECT_FIELDS = "user_id, expert_id";
}
