package org.bsgmteam.subsjob.model.repository;

import org.bsgmteam.subsjob.model.search.result.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The project name is subsjob.
 * Created by sergey on 05.12.15 at 18:31.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Repository
public interface TextRepository extends CrudRepository<Text, Integer> {
}
