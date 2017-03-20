package hight.sa.services;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hight.sa.model.Permission;
import hight.sa.repository.PermissionRepo;

@Service
public class PermissionService{

    @Resource
    private PermissionRepo permissionRepo;

    public int insert(Permission pojo){
        return permissionRepo.insert(pojo);
    }

    public int insertSelective(Permission pojo){
        return permissionRepo.insertSelective(pojo);
    }

    public int insertList(List<Permission> pojos){
        return permissionRepo.insertList(pojos);
    }

    public int update(Permission pojo){
        return permissionRepo.update(pojo);
    }

    public List<Permission> getUserPermissionByUserName(String userName){
        return permissionRepo.getPermissionByUserName(userName);
    }

    public List<Permission> getAllPermission(){
        return permissionRepo.getAllPermission();
    }
}
