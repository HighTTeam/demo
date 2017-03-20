package hight.sa.config.security;

import com.google.common.collect.Lists;
import hight.sa.model.Permission;
import hight.sa.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by dunn on 19/03/2017.
 */
@Service
public class SaInvocationSecurityMeMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    PermissionService permissionService;


    private volatile Map<String, Collection<ConfigAttribute>> map =null;


    private void loadPermission(){
        List<Permission> allPermission = permissionService.getAllPermission();
        map = allPermission.stream().collect(Collectors.toMap(Permission::getUrl,permission -> {
            SecurityConfig securityConfig = new SecurityConfig(permission.getName());
            return Lists.newArrayList(securityConfig);
        }));
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(null == map) loadPermission();
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            resUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
