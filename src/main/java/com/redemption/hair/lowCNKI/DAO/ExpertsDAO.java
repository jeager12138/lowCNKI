package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Experts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExpertsDAO {
    String TABLE_NAME = " Experts ";
    String SELECT_FIELDS = " id, contact, constitution, name, sex, age, major";


    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where locate('name','name')>0"})
    Experts getExpertsByName(String name);

    @Select({"select id from ", TABLE_NAME, "  where locate('name','name')>0"})
    int getIdbyName(String name);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Experts getExpertsById(int id);

    @Select({"select", SELECT_FIELDS," from ", TABLE_NAME, " where Major=#{Major}"})
    List<Experts> getExpertsByMajor(String Major);

    @Select({"select", SELECT_FIELDS," from ", TABLE_NAME, "  where locate('constitution','constitution')>0"})
    List<Experts> getExpertsByInstitution(String constitution);


}
