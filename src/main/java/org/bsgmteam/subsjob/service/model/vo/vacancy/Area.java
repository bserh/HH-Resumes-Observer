package org.bsgmteam.subsjob.service.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 15.11.15 at 16:17.
 * For more information you should send mail to codedealerb@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Area implements Serializable {
    private String id;
    private String name;
    @JsonProperty("parent_id")
    private String parentId;

    public Area() {

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
