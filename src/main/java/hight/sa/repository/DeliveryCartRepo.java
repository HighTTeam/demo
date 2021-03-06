package hight.sa.repository;

import hight.sa.model.DeliveryCart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * Created by gibson.luo on 2017/3/12.
 */
@Mapper
public interface DeliveryCartRepo {

    @Insert("insert into DeliveryCart(DistributionID, LogicStoreID, VehicleStoreID, CommodityID, Num) values(#{distributionId}, #{logicStoreId}, #{vehicleStoreId}, #{commodityId}, #{num})")
    void addCart(@Param("distributionId") String distributionId,
                 @Param("logicStoreId") String logicStoreId,
                 @Param("vehicleStoreId") String vehicleStoreId,
                 @Param("commodityId") String commodityId,
                 @Param("num") Integer num);

    @Update("update DeliveryCart set Num = #{num} where CartID = #{cartId}")
    void modifyCart(@Param("cartId") Long cartId, @Param("num") Integer num);

    @Delete("delete from DeliveryCart where CartID = #{cartId}")
    void deleteCart(@Param("cartId") Long cartId);

    @Select("select * from DeliveryCart where DistributionID = #{distributionId} and CommodityID = #{commodityId}")
    @Results(value = {
            @Result(id = true, property = "id", column = "CartID", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "distributionId", column = "DistributionID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "commodityId", column = "CommodityID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "num", column = "Num", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "crtTime", column = "CrtTime", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
    })
    DeliveryCart findTheSameCommodity(@Param("distributionId") String distributionId,
                                      @Param("commodityId") String commodityId);

    @Select("select t.CartID, t.DistributionID, t.CommodityID, t.Num, t.LogicStoreID, h.StoreHouseName, t.VehicleStoreID, v.VehicleStoreName, c.CommodityName from DeliveryCart t left join CommodityInfo c on t.CommodityID = c.CommodityID left join StoreHouseInfo h on h.StoreHouseID = t.LogicStoreID left join VehicleStoreInfo v on v.VehicleStoreID = t.VehicleStoreID where DistributionID = #{distributionId}")
    @Results(value = {
            @Result(id = true, property = "id", column = "CartID", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "distributionId", column = "DistributionID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "commodityId", column = "CommodityID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "commodityName", column = "CommodityName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "logicStoreId", column = "LogicStoreID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "logicStoreName", column = "StoreHouseName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "vehicleStoreId", column = "VehicleStoreID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "vehicleStoreName", column = "VehicleStoreName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "num", column = "Num", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "crtTime", column = "CrtTime", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
    })
    List<DeliveryCart> getCartList(@Param("distributionId") String distributionId);
}
