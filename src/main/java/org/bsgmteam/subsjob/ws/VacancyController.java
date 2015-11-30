package org.bsgmteam.subsjob.ws;

import org.bsgmteam.subsjob.model.vacancy.VacancyPagingWrapper;
import org.bsgmteam.subsjob.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The project name is subsjob.
 * Created by sergey on 30.11.15 at 20:25.
 * For more information you should send mail to codedealerb@gmail.com
 */
@RestController
public class VacancyController {

    @Autowired
    private VacancyService service;

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public VacancyPagingWrapper searchVacancies(
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "only_with_salary", required = false) Boolean onlyWithSalary,
            @RequestParam(value = "specialization", required = false) String specialization,
            @RequestParam(value = "area", required = false) Integer[] area,
            @RequestParam(value = "period", required = false) Integer period,
            @RequestParam(value = "currency", required = false, defaultValue = "USD") String currency,
            @RequestParam(value = "order_by", required = false, defaultValue = "publication_time") String orderBy,
            @RequestParam(value = "salary", required = false) Integer salary) {
        Map<String, String[]> propertiesMap = new HashMap<>();
        if (text != null) {
            propertiesMap.put("text", new String[]{text});
        }
        if (onlyWithSalary != null) {
            propertiesMap.put("only_with_salary", new String[]{String.valueOf(onlyWithSalary)});
        }
        if (specialization != null) {
            propertiesMap.put("specialization", new String[]{specialization});
        }
        if (area != null) {
            ArrayList<String> areas = new ArrayList<>();
            for (Integer anArea : area) {
                areas.add(String.valueOf(anArea));
            }
            if (areas.size() > 0) {
                propertiesMap.put("area", areas.toArray(new String[areas.size()]));
            }
        }
        if (period != null) {
            propertiesMap.put("period", new String[]{String.valueOf(period)});
        }
        propertiesMap.put("order_by", new String[]{String.valueOf(orderBy)});
        propertiesMap.put("currency", new String[]{String.valueOf(currency)});
        if (salary != null) {
            propertiesMap.put("salary", new String[]{String.valueOf(salary)});
        }

        return service.searchVacancies(propertiesMap);
    }
}
