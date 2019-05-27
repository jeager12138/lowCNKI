package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Paper_master;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Paper_masterDAO {
    String TABLE_NAME = " Paper_master ";
    String SELECT_FIELDS = " lid, title, rid, summary, keywords, time_, page_number, cited_times, class_number, download_times, references_, institution, year, tutor, url ";

    @Select({"select ", SELECT_FIELDS, " from " , TABLE_NAME, " where rid=#{rid}"})
    List<Paper_master> getPaperByRid(int rid);

}
