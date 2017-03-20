package hight.sa.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Service;

/**
 * Created by dunn on 18/03/2017.
 */
@Service
public class SaFilterSecurityInterceptor extends FilterSecurityInterceptor {

    @Autowired
    private SaInvocationSecurityMeMetadataSource saInvocationSecurityMeMetadataSource;

    @Autowired
    public void setSaAccessDecisionManager(SaAccessDecisionManager saAccessDecisionManager) {
        super.setAccessDecisionManager(saAccessDecisionManager);
    }


    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.saInvocationSecurityMeMetadataSource;
    }
}
