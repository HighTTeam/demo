package hight.sa.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import hight.sa.model.Role;

@Mapper
public interface RoleRepo {
    int insert(@Param("pojo") Role pojo);

    int insertSelective(@Param("pojo") Role pojo);

    int insertList(@Param("pojos") List<Role> pojo);

    int update(@Param("pojo") Role pojo);
}
