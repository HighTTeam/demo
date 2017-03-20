package hight.sa.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hight.sa.model.RolePermission;

@Mapper
public interface RolePermissionRepo {
    int insert(@Param("pojo") RolePermission pojo);

    int insertSelective(@Param("pojo") RolePermission pojo);

    int insertList(@Param("pojos") List<RolePermission> pojo);

    int update(@Param("pojo") RolePermission pojo);
}
