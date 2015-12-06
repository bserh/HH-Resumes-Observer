package org.bsgmteam.subsjob.model.repository;

import org.bsgmteam.subsjob.model.search.result.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The project name is subsjob.
 * Created by sergey on 05.12.15 at 18:30.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
