package org.bsgmteam.subsjob.model.repository;

import org.bsgmteam.subsjob.configuration.RepositoryConfiguration;
import org.bsgmteam.subsjob.model.search.result.Area;
import org.bsgmteam.subsjob.model.search.result.SearchProperties;
import org.bsgmteam.subsjob.model.search.result.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The project name is subsjob.
 * Created by sergey on 05.12.15 at 17:55.
 * For more information you should send mail to codedealerb@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class SearchPropertiesRepositoryTest {
    @Autowired
    private SearchPropertiesRepository repository;

    @Test
    public void testCRUDSearchRepository() {
        //setup product
        SearchProperties properties = new SearchProperties();
        properties.setCurrency("RUR");
        properties.setPeriod(30);
        properties.setOnlyWithSalary(true);
        properties.setSpecialization("IT");
        properties.setOrderBy("date");
        properties.setSalary(101010);

        Area area = new Area();
        area.setAreaId(112);
        area.setSearchProperties(properties);

        List<Area> areas = new ArrayList<>();
        areas.add(area);
        properties.setAreas(areas);

        Text text = new Text();
        text.setText("soome text");
        text.setSearchProperties(properties);

        List<Text> texts = new ArrayList<>();
        texts.add(text);
        properties.setText(texts);

        //save properties, verify have ID value after save
        assertNull(properties.getId());//null before save
        repository.save(properties);
        assertNotNull(properties.getId());//not null after save

        //fetch from DB
        SearchProperties fetchedProperties = repository.findOne(properties.getId());

        //should not be null
        assertNotNull(fetchedProperties);

        //should equal
        assertEquals(fetchedProperties.getId(), properties.getId());
        assertEquals(properties.getSalary(), fetchedProperties.getSalary());

        assertNotNull(fetchedProperties.getAreas());
        assertTrue(fetchedProperties.getAreas().get(0).getAreaId().equals(112));

        //update description and save
        fetchedProperties.setSalary(150000);
        repository.save(fetchedProperties);

        //get from DB, should be updated
        SearchProperties fetchedUpdatedProperties = repository.findOne(fetchedProperties.getId());
        assertEquals(fetchedProperties.getSalary(), fetchedUpdatedProperties.getSalary());

        //verify count of products in DB
        long propsCount = repository.count();
        assertEquals(propsCount, 1);

        //get all products, list should only have one
        Iterable<SearchProperties> searchProperties = repository.findAll();

        int count = 0;

        for (SearchProperties p : searchProperties) {
            count++;
        }

        assertEquals(count, 1);
    }
}
