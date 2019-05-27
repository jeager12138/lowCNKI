package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Co_institutionDAO {
    String TABLE_NAME = " Co_institutionDAO ";
    String SELECT_FIELDS = "expert_id, co_constitution";
}
