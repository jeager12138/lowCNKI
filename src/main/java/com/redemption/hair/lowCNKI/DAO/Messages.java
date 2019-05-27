package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Messages {
    String TABLE_NAME = " Messages ";
    String SELECT_FIELDS = "message_id, send_id, rec_id, title, state, date, message";
}
