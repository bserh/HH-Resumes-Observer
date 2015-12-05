package org.bsgmteam.subsjob.configuration;

import org.bsgmteam.subsjob.model.vo.vacancy.VacancyPagingWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * The project name is subsjob.
 * Created by sergey on 30.11.15 at 23:33.
 * For more information you should send mail to codedealerb@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
@DirtiesContext
public class ApplicationTest {
    private final static String VACANCY_URL = "/vacancies";
    @Value("${local.server.port}")
    private int port;

    @Test
    public void testSearchVacancies() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<VacancyPagingWrapper> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + VACANCY_URL, VacancyPagingWrapper.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
