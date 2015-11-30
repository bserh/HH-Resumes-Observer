package org.bsgmteam.subsjob.configuration;

import org.bsgmteam.subsjob.service.VacancyService;
import org.bsgmteam.subsjob.service.impl.VacancyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The project name is subsjob.
 * Created by sergey on 30.11.15 at 21:20.
 * For more information you should send mail to codedealerb@gmail.com
 */
@SpringBootApplication(scanBasePackages = "org.bsgmteam.subsjob")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public VacancyService getVacancyService() {
        return new VacancyServiceImpl();
    }
}
