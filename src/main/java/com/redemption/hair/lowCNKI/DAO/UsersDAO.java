package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersDAO {
    String TABLE_NAME = " Users ";
    String SELECT_FIELDS = "id, avator, nickname, balance, password, salt";
    String INSERT_FIELDS = "avator, nickname, balance, password, salt";

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{avator},#{nickname},#{balance},#{password},#{salt})"})
    int addUser(Users user);

    @Select({"'select", SELECT_FIELDS, "from", TABLE_NAME, "where locate('nickname','nickname')>0"})
    Users selectByName(String nickname);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where locate('id','id')>0"})
    Users selectById(int id);

}
