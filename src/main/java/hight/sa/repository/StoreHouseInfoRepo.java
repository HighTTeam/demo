package hight.sa.repository;

import hight.sa.model.StoreHouseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Mapper
public interface StoreHouseInfoRepo {

    @Select("select * from StoreHouseInfo order by CrtTime desc")
    @Results(value = {
            @Result(id = true, property = "id", column = "StoreHouseID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "StoreHouseName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "address", column = "StoreHouseAddr", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "contacts", column = "StoreHouseContacts", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "telNumber", column = "StoreHouseTelNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "cardId", column = "StoreHouseCardID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "crtTime", column = "CrtTime", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
    })
    List<StoreHouseInfo> getAll();

    @Select("select StoreHouseID, StoreHouseName from StoreHouseInfo order by CrtTime desc")
    @Results(value = {
            @Result(id = true, property = "id", column = "StoreHouseID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "StoreHouseName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    List<StoreHouseInfo> getSelectedList();
}
