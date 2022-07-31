package tr.com.nihatalim.jpalockingmechanizm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JpaLockingMechanizmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLockingMechanizmApplication.class, args);
    }

}
