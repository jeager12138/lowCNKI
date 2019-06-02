package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Bdxs_paper;
import com.redemption.hair.lowCNKI.model.Patent_CNKI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Patent_CNKIDAO {
    String TABLE_NAME = " Patent_CNKI ";
    String SELECT_FIELDS = "name,apply_num,apply_date,pub_number,pub_date,apply_name,address,invent_name,agent_name,agent_man,code,abstract_,pages,typenum";

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{name},name)>0"})
    List<Patent_CNKI> getPatentByName(String name);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{invent_name},invent_name)>0"})
    List<Patent_CNKI> getPatentByInventName(String invent_name);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{apply_name},apply_name)>0"})
    List<Patent_CNKI> getPatentByApply_name(String apply_name);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{agent_name},agent_name)>0"})
    List<Patent_CNKI> getPatentByAgent_name(String agent_name);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{abstract_},abstract_)>0"})
    List<Patent_CNKI> getPatentByKeyword(String abstract_);
}
