package hight.sa.services;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import hight.sa.model.User;
import hight.sa.repository.UserRepo;

@Service
public class UserService{

    @Resource
    private UserRepo userRepo;

    public int insert(User pojo){
        return userRepo.insert(pojo);
    }

    public int insertSelective(User pojo){
        return userRepo.insertSelective(pojo);
    }

    public int insertList(List<User> pojos){
        return userRepo.insertList(pojos);
    }

    /**
     * 更新用户信息
     * @param pojo
     * @return
     */
    public int update(User pojo){
        return userRepo.update(pojo);
    }


    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName){
        return userRepo.queryUserByUserName(userName);
    }
}
