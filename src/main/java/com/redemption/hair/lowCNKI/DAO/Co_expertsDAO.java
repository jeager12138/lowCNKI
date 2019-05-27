package com.redemption.hair.lowCNKI.DAO;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Co_expertsDAO {
    String TEST_FIELD = " co_expert_id ";
    String TABLE_NAME = " Co_experts ";

    @Select({"select co_expert_id from Co_experts where expert_id=#{expert_id}"})
    int selectCoIdByExpertId(int expert_id);

}