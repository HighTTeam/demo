package hight.sa.repository;

import hight.sa.model.VehicleStoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Mapper
public interface VehicleStoreInfoRepo {

    @Select("select VehicleStoreID, VehicleStoreName from VehicleStoreInfo order by VehicleStoreCrtTime desc")
    @Results(value = {
            @Result(id = true, property = "id", column = "VehicleStoreID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "VehicleStoreName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    List<VehicleStoreInfo> getSelectedList();

}
