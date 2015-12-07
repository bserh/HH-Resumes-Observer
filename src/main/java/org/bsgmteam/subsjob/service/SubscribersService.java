package org.bsgmteam.subsjob.service;

import org.bsgmteam.subsjob.model.repository.SearchPropertiesRepository;
import org.bsgmteam.subsjob.model.search.result.SearchProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * The project name is subsjob.
 * Created by sergey on 07.12.15 at 2:56.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class SubscribersService {
    @Autowired
    private SearchPropertiesRepository repository;

    public Map<String, SearchProperties> getSearchedPropertiesByEmails() {
        Map<String, SearchProperties> map = new HashMap<>();

        Iterable<SearchProperties> allData = repository.findAll();

        for (SearchProperties s : allData) {
            map.put(s.getUserEmail(), s);
        }

        return map;
    }
}
