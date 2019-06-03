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

    @Select({"select num_papers from",  TABLE_NAME, "where name = #{name}"})
    String getNum_papersByName(String name);

    @Select({"select num_cited from",  TABLE_NAME, "where name = #{name}"})
    String getNum_citedByName(String name);

    @Select({"select core_inclusion from",  TABLE_NAME, "where name = #{name}"})
    String getCore_inclusionByName(String name);

    @Select({"select highest_cited from",  TABLE_NAME, "where name = #{name}"})
    String getHighest_citedByName(String name);

    @Select({"select num_experts from",  TABLE_NAME, "where name = #{name}"})
    String getNum_expertsByName(String name);

    @Select({"select repre_author from",  TABLE_NAME, "where name = #{name}"})
    String getRepre_authorByName(String name);

}
