package org.bsgmteam.subsjob.model.vo.vacancy;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 07.12.15 at 2:45.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class ClusteredVacancy implements Serializable {
    private String id;
    private String name;
    private Item[] items;

    public ClusteredVacancy() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}
