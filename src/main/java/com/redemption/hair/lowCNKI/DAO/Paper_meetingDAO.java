package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Paper_meetingDAO {
    String TABLE_NAME = " Paper_meeting ";
    String SELECT_FIELDS = "lid, title, rid, summary, keywords, time, page_number, cited_times, class_number, download_times, references, meeting_name, meeting_place, meeting_time";
}
