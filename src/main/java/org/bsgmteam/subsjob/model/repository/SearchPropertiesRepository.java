package org.bsgmteam.subsjob.model.repository;

import org.bsgmteam.subsjob.model.search.result.SearchProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The project name is subsjob.
 * Created by sergey on 05.12.15 at 17:51.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Repository
public interface SearchPropertiesRepository extends CrudRepository<SearchProperties, Integer> {
}
