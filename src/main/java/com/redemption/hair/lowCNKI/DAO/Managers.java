package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Managers {
    String TABLE_NAME = " Managers ";
    String SELECT_FIELDS = "id, account, password, salt";
}
