package org.bsgmteam.subsjob.service.impl;

import org.bsgmteam.subsjob.model.vo.vacancy.ClusteredVacancyWrapper;
import org.bsgmteam.subsjob.model.vo.vacancy.VacancyPagingWrapper;
import org.bsgmteam.subsjob.service.BaseRestConstants;
import org.bsgmteam.subsjob.service.VacancyService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * The project name is subsjob.
 * Created by sergey on 15.11.15 at 14:14.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class VacancyServiceImpl implements VacancyService {
    private RestTemplate restTemplate = new RestTemplate();

    public VacancyPagingWrapper searchVacancies(Map<String, String[]> propertiesForURI) throws IllegalArgumentException {
        String url = createURLWithGetParameters(BaseRestConstants.BASE_URL, propertiesForURI);
        System.out.println(url);
        HttpEntity<VacancyPagingWrapper> wrapper = restTemplate
                .exchange(url, HttpMethod.GET, BaseRestConstants.getHTTPEntity(), VacancyPagingWrapper.class);
        return wrapper.getBody();
    }

    @Override
    public ClusteredVacancyWrapper getClusteredVacancies() {
        Map<String, String[]> propertiesForURI = new HashMap<>();
        propertiesForURI.put("clusters", new String[]{"true"});
        String url = createURLWithGetParameters(BaseRestConstants.BASE_URL, propertiesForURI);
        System.out.println(url);
        HttpEntity<ClusteredVacancyWrapper> wrapper = restTemplate
                .exchange(url, HttpMethod.GET, BaseRestConstants.getHTTPEntity(), ClusteredVacancyWrapper.class);
        return wrapper.getBody();
    }

    public String createURLWithGetParameters(String baseUrl, Map<String, String[]> propertiesForURI) {
        if (propertiesForURI.size() == 0) {
            return baseUrl;
        } else {
            StringBuilder URLBuilder = new StringBuilder(baseUrl);
            URLBuilder.append("?");

            for (Map.Entry<String, String[]> entry : propertiesForURI.entrySet()) {
                String[] args = entry.getValue();
                String keyPartOfUrl = "";
                for (String arg : args) {
                    keyPartOfUrl += entry.getKey();
                    if (isPartNeedAdditionDelimeters(arg, entry.getKey())) {
                        keyPartOfUrl += "=" + arg + "&";
                    } else {
                        keyPartOfUrl += "=\"" + arg + "\"&";
                    }
                }
                URLBuilder.append(keyPartOfUrl);
            }

            String URLValue = URLBuilder.toString();
            URLValue = URLValue.substring(0, URLValue.length() - 1);

            return URLValue;
        }
    }

    private boolean isArgDigit(String arg) {
        try {
            Integer value = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isPartNeedAdditionDelimeters(String arg, String key) {
        return isArgDigit(arg)
                || key.compareTo("order_by") == 0
                || key.compareTo("currency") == 0
                || key.compareTo("only_with_salary") == 0
                || key.compareTo("clusters") == 0;
    }
}
