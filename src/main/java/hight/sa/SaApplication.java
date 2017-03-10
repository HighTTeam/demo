package hight.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaApplication.class, args);
    }

}
