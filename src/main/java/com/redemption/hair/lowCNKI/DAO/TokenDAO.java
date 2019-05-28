package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Token;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TokenDAO {
    String TABLE_NAME = " Token ";
    String SELECT_FIELDS = "user_id, token ,token_time ,token_valid";

    @Insert({"insert into", TABLE_NAME, "(", SELECT_FIELDS, ") values (#{user_id},#{token},#{token_time},#{token_valid}"})
    Token addToken(String token);

    @Update({"update",TABLE_NAME, "set token_valid=#{valid} where locate('token','token')>0"})
    void updateTokenValid(@Param("token") String token,@Param("valid") int valid); //找到ticket并把token_valid字段更新 注意多个参数的格式

    @Select({"select", SELECT_FIELDS ,"from" ,TABLE_NAME ," where locate('token','token')>0" })
    Token selectByToken(String token);

}
