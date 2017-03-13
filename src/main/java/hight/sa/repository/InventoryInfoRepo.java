package hight.sa.repository;

import hight.sa.model.InventoryInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * Created by neron.liu on 12/03/2017.
 */
@Mapper
public interface InventoryInfoRepo {

    @Select("select * from InventoryInfo where LogicStoreID = #{logicStoreId} and CommodityID = #{commodityId}")
    @Results(value = {
            @Result(id = true, property = "logicStoreId", column = "LogicStoreID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "commodityId", column = "CommodityID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "commodityCount", column = "CommodityCount", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "updateTime", column = "InventoryUpdateTm", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
    })
    InventoryInfo findByPk(
            @Param("logicStoreId") String logicStoreId,
            @Param("commodityId") String commodityId);

    @Update("update InventoryInfo set CommodityCount = CommodityCount - #{number} " +
            "where LogicStoreID = #{logicStoreId} and CommodityID = #{commodityId}")
    int reduceCommodityCount(@Param("logicStoreId")String logicStoreId, @Param("commodityId")String commodityId, @Param("number")int number);

    @Update("update InventoryInfo set CommodityCount = CommodityCount + #{number} " +
            "where LogicStoreID = #{logicStoreId} and CommodityID = #{commodityId}")
    int increaseCommodityCountByUpdate(@Param("logicStoreId")String logicStoreId, @Param("commodityId")String commodityId, @Param("number")int number);

    @Insert("insert into InventoryInfo(CommodityCount, LogicStoreID, CommodityID) values(#{number}, #{logicStoreId}, #{commodityId})")
    int increaseCommodityCountByInsert(@Param("logicStoreId")String logicStoreId, @Param("commodityId")String commodityId, @Param("number")int number);


}
