package org.bsgmteam.subsjob.service.impl;

import org.bsgmteam.subsjob.model.vo.vacancy.ClusteredVacancyWrapper;
import org.bsgmteam.subsjob.model.vo.vacancy.VacancyPagingWrapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * The project name is subsjob.
 * Created by sergey on 28.11.15 at 20:41.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class VacancyServiceImplTest {
    @Test
    public void testCreateRightURLWithGetParams() {
        String url = "https://api.hh.ru/vacancies";

        Map<String, String[]> params = new HashMap<>();
        params.put("key", new String[]{"test1", "test2"});
        params.put("salary", new String[]{"123"});
        VacancyServiceImpl service = new VacancyServiceImpl();

        assertTrue(service.createURLWithGetParameters(url, params).equals("https://api.hh.ru/vacancies?salary=123&key=\"test1\"&key=\"test2\""));
    }

    @Test
    public void testGetVacanciesWrapperFromHeadHuntersAPI() {
        Map<String, String[]> params = new HashMap<>();

        params.put("key", new String[]{"test1", "test2"});
        params.put("salary", new String[]{"123"});

        VacancyServiceImpl service = new VacancyServiceImpl();

        VacancyPagingWrapper wrapper = service.searchVacancies(params);

        assertNotNull(wrapper);
        assertTrue(wrapper.getPerPage() == 20);//defaultValue
        assertTrue(wrapper.getItems().length != 0);
    }

    @Test
    public void testGetClusters() {
        VacancyServiceImpl service = new VacancyServiceImpl();

        ClusteredVacancyWrapper wrapper = service.getClusteredVacancies();

        assertNotNull(wrapper);
        assertTrue(wrapper.getPerPage() != 0);
        assertTrue(wrapper.getClusters().length != 0);
    }
}
