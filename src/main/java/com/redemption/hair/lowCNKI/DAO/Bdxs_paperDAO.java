package com.redemption.hair.lowCNKI.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Bdxs_paperDAO {
    String TABLE_NAME = " bdxs_paper ";
    String SELECT_FIELDS = "paperId,title,sourceName,sourceUrl,authorName,summary,keywords,doi,cited,downLoadUrl,journalTitle,journalPicture,fields";
}
