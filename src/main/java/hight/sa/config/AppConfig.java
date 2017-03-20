package hight.sa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

/**
 * Created by neron.liu on 10/03/2017.
 */
@Configuration
@Import(WebSecurityConfiguration.class)
public class AppConfig {


    @Bean
    public ShaPasswordEncoder getPasswordEncoder(){
        return new ShaPasswordEncoder(256);
    }
}
