package com.redemption.hair.lowCNKI.DAO;

import com.redemption.hair.lowCNKI.model.Bdxs_author;
import com.redemption.hair.lowCNKI.model.Bdxs_paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Bdxs_paperDAO {
    String TABLE_NAME = " bdxs_paper ";
    String SELECT_FIELDS = "paperId,title,sourceName,sourceUrl,authorName,summary,keywords,doi,cited,downLoadUrl,journalTitle,journalPicture,fields";

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{title},title)>0"})
    List<Bdxs_paper> getPaperByTitle(String title);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{authorName},authorName)>0"})
    List<Bdxs_paper> getPaperByAuthorName(String authorName);

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where locate(#{keywords},keywords)>0"})
    List<Bdxs_paper> getPaperByKeywords(String keywords);
}
