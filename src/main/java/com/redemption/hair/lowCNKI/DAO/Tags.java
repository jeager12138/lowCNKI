package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tags {
    String TABLE_NAME = " Tags ";
    String SELECT_FIELDS = "id, name, state";
}
