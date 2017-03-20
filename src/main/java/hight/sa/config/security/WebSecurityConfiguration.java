package hight.sa.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 *
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    ShaPasswordEncoder passwordEncoder;

    @Autowired
    SaFilterSecurityInterceptor saFilterSecurityInterceptor;


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
////                .groupAuthoritiesByUsername(JdbcUserDetailsManager.DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY)
//                .authoritiesByUsernameQuery(JdbcUserDetailsManager.DEF_AUTHORITIES_BY_USERNAME_QUERY)
//                .usersByUsernameQuery(JdbcUserDetailsManager.DEF_USERS_BY_USERNAME_QUERY);
//        auth.inMemoryAuthentication()
        auth.userDetailsService(new UserAuthentication());
//                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error=true").defaultSuccessUrl("/admin")
                .usernameParameter("email").passwordParameter("password")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .clearAuthentication(Boolean.TRUE).permitAll()
                .and().rememberMe().tokenValiditySeconds(Integer.MAX_VALUE).rememberMeParameter("remember-me")
                .rememberMeCookieName("workspace")
                .and().csrf().disable();
        http.addFilterBefore(saFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/data/**", "/js/**", "/vendor/**");
    }
}
