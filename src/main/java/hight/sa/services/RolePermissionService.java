package hight.sa.services;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hight.sa.model.RolePermission;
import hight.sa.repository.RolePermissionRepo;

@Service
public class RolePermissionService{

    @Resource
    private RolePermissionRepo rolePermissionRepo;

    public int insert(RolePermission pojo){
        return rolePermissionRepo.insert(pojo);
    }

    public int insertSelective(RolePermission pojo){
        return rolePermissionRepo.insertSelective(pojo);
    }

    public int insertList(List<RolePermission> pojos){
        return rolePermissionRepo.insertList(pojos);
    }

    public int update(RolePermission pojo){
        return rolePermissionRepo.update(pojo);
    }
}
