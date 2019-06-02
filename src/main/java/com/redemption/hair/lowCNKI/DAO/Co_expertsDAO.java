package com.redemption.hair.lowCNKI.DAO;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Co_expertsDAO {
    String TEST_FIELD = " co_expert_id ";
    String TABLE_NAME = " Co_experts ";

    @Select({"select",TEST_FIELD ,"from",  TABLE_NAME, "where locate('expert_id','co_expert_id')>0"})
    int selectCoIdByExpertId(int expert_id);

}