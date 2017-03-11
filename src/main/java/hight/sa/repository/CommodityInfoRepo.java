package hight.sa.repository;

import hight.sa.model.CommodityInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Mapper
public interface CommodityInfoRepo {


    @Select("select * from CommodityInfo where CommodityID = #{id}")
    @Results(value = {
            @Result(id = true, property = "id", column = "CommodityID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "CommodityName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    CommodityInfo findById(@Param("id") String id);

    @Select("select CommodityID, CommodityName from CommodityInfo order by CommodityID desc")
    @Results(value = {
            @Result(id = true, property = "id", column = "CommodityID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "CommodityName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    List<CommodityInfo> getSelectedList();
}
