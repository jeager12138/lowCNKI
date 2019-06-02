package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Patents;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PatentsDAO {
    String TABLE_NAME = " Patents ";
    String SELECT_FIELDS = "pid, title, rid, application_date, summary, class_number, transfer, publication_date";

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where locate('title','title')>0"})
    List<Patents> getPatentsByTitle(String title);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where locate('rid','rid')>0"})
    List<Patents> getPatentsByRid(int rid);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where locate('summary','summary')>0"})
    List<Patents> getPatentsByKeyword(String summary);


}
