package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Patents {
    String TABLE_NAME = " Patents ";
    String SELECT_FIELDS = "pid, title, rid, application_date, summary, class_number, transfer, publication_date";
}
