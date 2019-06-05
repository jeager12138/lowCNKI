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

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    Patent_CNKI getPatentByPubNum(String pub_number);

    @Select({"select apply_num from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentapply_numByPubNum(String pub_number);

    @Select({"select apply_date from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentapply_dateByPubNum(String pub_number);

    @Select({"select pub_date from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentpub_dateByPubNum(String pub_number);

    @Select({"select apply_name from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentapply_nameByPubNum(String pub_number);

    @Select({"select address from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentaddressByPubNum(String pub_number);

    @Select({"select invent_name from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentinvent_nameByPubNum(String pub_number);

    @Select({"select agent_name from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentagent_nameByPubNum(String pub_number);

    @Select({"select agent_man from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentagent_manByPubNum(String pub_number);

    @Select({"select abstract_ from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentabstract_ByPubNum(String pub_number);

    @Select({"select pages from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatentpagesByPubNum(String pub_number);

    @Select({"select typenum from",  TABLE_NAME, "where pub_number = #{pub_number}"})
    String getPatenttypenumagent_manByPubNum(String pub_number);

}
