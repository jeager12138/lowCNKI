package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Bdxs_author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Bdxs_authorDAO {
    String TABLE_NAME = " bdxs_author ";
    String SELECT_FIELDS = "scholarId,name,affiliate,cited,field,journalRatio,meetingRatio,bookRatio,otherRtio,paperNum";

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{name},name)>0"})
    List<Bdxs_author> getAuthorByName(String name);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{affiliate},affiliate)>0"})
    List<Bdxs_author> getAuthorByAffiliate(String affiliate);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{field},field)>0"})
    List<Bdxs_author> getAuthorByField(String field);
}
