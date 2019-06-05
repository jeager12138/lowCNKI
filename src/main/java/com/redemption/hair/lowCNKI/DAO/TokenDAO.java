package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Token;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface TokenDAO {
    String TABLE_NAME = " Ticket ";
    String INSERT_FIELDS = " user_id, token ,token_time ,token_valid ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{user_id},#{token},#{token_time},#{token_valid})"})
    int addToken(Token tokenk);

    @Update({"update",TABLE_NAME, "set token_valid=#{valid} where token=#{token}"})
    void updateTokenValid(@Param("token") String token,@Param("valid") int valid); //找到ticket并把token_valid字段更新 注意多个参数的格式

    @Select({"select", SELECT_FIELDS ,"from" ,TABLE_NAME ," where token=#{token}" })
    Token selectByToken(String token);

    @Select({"select token_time from ", TABLE_NAME, " where token=#{token}"})
    Date selectDate(String token);

    @Select({"select token_valid from ", TABLE_NAME, "where token=#{token}"})
    int selectValid(String token);

    @Select({"select user_id from ", TABLE_NAME, "where token=#{token}"})
    int selectUserId(String token);


}
