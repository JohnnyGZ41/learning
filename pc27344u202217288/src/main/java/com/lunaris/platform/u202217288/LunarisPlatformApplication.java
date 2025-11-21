package com.lunaris.platform.u202217288;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LunarisPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunarisPlatformApplication.class, args);
    }

}
