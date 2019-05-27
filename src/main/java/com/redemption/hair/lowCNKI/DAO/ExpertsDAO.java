package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Experts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExpertsDAO {
    String TABLE_NAME = " Experts ";
    String SELECT_FIELDS = " id, contact, constitution, name, sex, age, major";


    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where name=#{name}"})
    Experts getExpertsByName(String name);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where id=#{id}"})
    Experts getExpertsById(int id);

    @Select({"select id from ", TABLE_NAME, " where name=#{name}"})
    int getIdbyName(String name);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where major=#{major}"})
    List<Experts> getExpertsByMajor(String major);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where institution=#{institution}"})
    List<Experts> getExpertsByInstitution(String institution);

}
