package org.bsgmteam.subsjob.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The project name is subsjob.
 * Created by sergey on 05.12.15 at 17:34.
 * For more information you should send mail to codedealerb@gmail.com
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.bsgmteam.subsjob.model"})
@EnableJpaRepositories(basePackages = {"org.bsgmteam.subsjob.model.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
