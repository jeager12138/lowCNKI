package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Follow_experts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Follow_expertsDAO {
    String TABLE_NAME = " Follow_experts ";
    String SELECT_FIELDS = "user_id, expert_id";
    String INSERT_FIELDS = SELECT_FIELDS;


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId}, #{expertId})"})
    int addFollow(@Param("userId")int userId, @Param("expertId")int expertId);


    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where user_id=#{userId} and expert_id=#{expertId}"})
    Follow_experts queryIfFollow(@Param("userId")int userId, @Param("expertId")int expertId);

}
