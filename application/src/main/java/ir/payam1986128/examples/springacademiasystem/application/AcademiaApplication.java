package ir.payam1986128.examples.springacademiasystem.application;

import ir.payam1986128.examples.springacademiasystem.contract.business.AuthServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication(scanBasePackages = "ir.payam1986128.examples.springacademiasystem")
@EnableJpaRepositories(basePackages = "ir.payam1986128.examples.springacademiasystem.persistence.repository")
@EntityScan(basePackages = "ir.payam1986128.examples.springacademiasystem.persistence.entity")
@EnableRetry
@AllArgsConstructor
public class AcademiaApplication {
    private final AuthServiceApi authService;

    public static void main(String[] args) {
        SpringApplication.run(AcademiaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAnAdmin() throws Exception {
        authService.createDefaultAdminIfNotExists();
    }
}
