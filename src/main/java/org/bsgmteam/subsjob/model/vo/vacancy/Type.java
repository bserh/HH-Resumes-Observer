package org.bsgmteam.subsjob.model.vo.vacancy;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 19.11.15 at 20:02.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class Type implements Serializable {
    private String id;
    private String name;

    public Type() {
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
}
