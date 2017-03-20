package hight.sa.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hight.sa.model.UserRole;

@Mapper
public interface UserRoleRepo {
    int insert(@Param("pojo") UserRole pojo);

    int insertSelective(@Param("pojo") UserRole pojo);

    int insertList(@Param("pojos") List<UserRole> pojo);

    int update(@Param("pojo") UserRole pojo);
}
