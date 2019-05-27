package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersDAO {
    String TABLE_NAME = " Users ";
    String SELECT_FIELDS = "id, avator, nickname, balance, password, salt";
}
