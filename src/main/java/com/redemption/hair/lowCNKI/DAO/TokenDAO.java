package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenDAO {
    String TABLE_NAME = " Token ";
    String SELECT_FIELDS = "user_id, token ,token_time ,token_valid";
}
