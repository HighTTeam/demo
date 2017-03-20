package hight.sa.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hight.sa.model.Permission;

@Mapper
public interface PermissionRepo {
    int insert(@Param("pojo") Permission pojo);

    int insertSelective(@Param("pojo") Permission pojo);

    int insertList(@Param("pojos") List<Permission> pojo);

    int update(@Param("pojo") Permission pojo);

    List<Permission> getPermissionByUserName(@Param("userName")String userName);

    List<Permission> getAllPermission();
}
