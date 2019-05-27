package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Expert_tagDAO {
    String TABLE_NAME = " Expert_tag ";
    String SELECT_FIELDS = "expert_id, tag_id";
}
