package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Paper_tag {
    String TABLE_NAME = " Paper_tag ";
    String SELECT_FIELDS = "paper_id, tag_id";
}
