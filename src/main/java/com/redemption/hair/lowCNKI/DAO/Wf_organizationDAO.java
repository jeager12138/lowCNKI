package com.redemption.hair.lowCNKI.DAO;
import com.redemption.hair.lowCNKI.model.Wf_organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Wf_organizationDAO {
    String TABLE_NAME = " wf_organization ";
    String SELECT_FIELDS = "id,name,introduction,num_papers,num_cited,core_inclusion,highest_cited,num_experts,repre_author";

    @Select({"select",SELECT_FIELDS ,"from",  TABLE_NAME, "where name = #{name}"})
    Wf_organization getOrganizationByName(String name);

}
