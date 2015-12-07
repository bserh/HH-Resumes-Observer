package org.bsgmteam.subsjob.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 07.12.15 at 2:46.
 * For more information you should send mail to codedealerb@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {
    private String name;
    private String url;
    private int count;

    public Item() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
