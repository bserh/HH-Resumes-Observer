package org.bsgmteam.subsjob.service;

import org.bsgmteam.subsjob.model.vacancy.VacancyPagingWrapper;

import java.util.Map;

/**
 * The project name is subsjob.
 * Created by sergey on 19.11.15 at 20:20.
 * For more information you should send mail to codedealerb@gmail.com
 */
public interface VacancyService {
    VacancyPagingWrapper searchVacancies(Map<String, String[]> propertiesForURI) throws IllegalArgumentException;
}
