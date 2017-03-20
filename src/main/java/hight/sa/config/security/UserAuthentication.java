package hight.sa.config.security;

import hight.sa.model.Permission;
import hight.sa.model.User;
import hight.sa.services.PermissionService;
import hight.sa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dunn on 18/03/2017.
 */
@Service
public class UserAuthentication implements UserDetailsService {


    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(username);
        if(null != user){
            List<Permission> permissionList = permissionService.getUserPermissionByUserName(username);
            List<GrantedAuthority> authorities = permissionList.stream().map(permission ->
                new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getPassword(),authorities);
        }else {
            throw new UsernameNotFoundException(username + " not found!");
        }
    }
}
