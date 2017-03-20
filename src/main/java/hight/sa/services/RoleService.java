package hight.sa.services;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hight.sa.model.Role;
import hight.sa.repository.RoleRepo;

@Service
public class RoleService{

    @Resource
    private RoleRepo roleRepo;

    public int insert(Role pojo){
        return roleRepo.insert(pojo);
    }

    public int insertSelective(Role pojo){
        return roleRepo.insertSelective(pojo);
    }

    public int insertList(List<Role> pojos){
        return roleRepo.insertList(pojos);
    }

    public int update(Role pojo){
        return roleRepo.update(pojo);
    }
}
