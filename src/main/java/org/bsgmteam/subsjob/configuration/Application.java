package org.bsgmteam.subsjob.configuration;

import org.bsgmteam.subsjob.service.VacancyService;
import org.bsgmteam.subsjob.service.impl.VacancyServiceImpl;
import org.bsgmteam.subsjob.service.notification.email.impl.MailNotification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Bean
    public MailNotification getMailNotification() {
        return new MailNotification();
    }

    // CORS
    @Bean
    FilterRegistrationBean corsFilter(
            @Value("${tagit.origin:http://localhost:8080}") String origin) {
        return new FilterRegistrationBean(new Filter() {
            public void doFilter(ServletRequest req, ServletResponse res,
                                 FilterChain chain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) req;
                HttpServletResponse response = (HttpServletResponse) res;
                String method = request.getMethod();
                // this origin value could just as easily have come from a database
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods",
                        "POST,GET,OPTIONS,DELETE");
                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader(
                        "Access-Control-Allow-Headers",
                        "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
                if ("OPTIONS".equals(method)) {
                    response.setStatus(HttpStatus.OK.value());
                } else {
                    chain.doFilter(req, res);
                }
            }

            public void init(FilterConfig filterConfig) {
            }

            public void destroy() {
            }
        });
    }
}
