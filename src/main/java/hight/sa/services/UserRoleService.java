package hight.sa.services;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hight.sa.model.UserRole;
import hight.sa.repository.UserRoleRepo;

@Service
public class UserRoleService{

    @Resource
    private UserRoleRepo userRoleRepo;

    public int insert(UserRole pojo){
        return userRoleRepo.insert(pojo);
    }

    public int insertSelective(UserRole pojo){
        return userRoleRepo.insertSelective(pojo);
    }

    public int insertList(List<UserRole> pojos){
        return userRoleRepo.insertList(pojos);
    }

    public int update(UserRole pojo){
        return userRoleRepo.update(pojo);
    }
}
