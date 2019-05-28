package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Paper_meeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Paper_meetingDAO {
    String TABLE_NAME = " Paper_meeting ";
    String SELECT_FIELDS = "lid, title, rid, summary, keywords, time, page_number, cited_times, class_number, download_times, references, meeting_name, meeting_place, meeting_time";

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where title=#{title}"})
    List<Paper_meeting> getMeetingByTitle(String title);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where rid=#{rid}"})
    List<Paper_meeting> getMeetingByRid(int rid);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where keywords=#{keywords}"})
    List<Paper_meeting> getMeetingByKeyword(String keywords);

}

