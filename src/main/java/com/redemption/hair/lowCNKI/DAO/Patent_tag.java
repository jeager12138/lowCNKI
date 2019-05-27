package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Patent_tag {
    String TABLE_NAME = " Patent_tag ";
    String SELECT_FIELDS = "patent_id, tag_id";
}
