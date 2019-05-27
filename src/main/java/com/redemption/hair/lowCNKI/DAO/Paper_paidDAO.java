package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Paper_paidDAO {
    String TABLE_NAME = " Paper_paid ";
    String SELECT_FIELDS = "user_id, paper_id";
}
