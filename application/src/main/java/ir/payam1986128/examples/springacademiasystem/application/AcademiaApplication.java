package ir.payam1986128.examples.springacademiasystem.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ir.payam1986128.examples.springacademiasystem")
@EnableJpaRepositories(basePackages = "ir.payam1986128.examples.springacademiasystem.persistence.repository")
@EntityScan(basePackages = "ir.payam1986128.examples.springacademiasystem.persistence.entity")
public class AcademiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcademiaApplication.class, args);
    }
}
