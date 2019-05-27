package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Experts;
import com.redemption.hair.lowCNKI.model.Paper_journal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Paper_journalDAO {
    String TABLE_NAME = " Paper_journal ";
    String SELECT_FIELDS = " lid,title,rid,summary,keywords,time_,cited_times,class_number,download_times,references_,journal_title,page_number,ISSN";


    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where title=#{title}"})
    List<Paper_journal> getJournalByTitle(String title);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where rid=#{rid}"})
    List<Paper_journal> getJournalByRid(int rid);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where keywords=#{keywords}"})
    List<Paper_journal> getJournalByKeyword(String keyword);
}
