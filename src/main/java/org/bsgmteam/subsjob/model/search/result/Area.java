package org.bsgmteam.subsjob.model.search.result;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 01.12.15 at 0:24.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Entity
public class Area implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer areaId;

    @ManyToOne(fetch = FetchType.LAZY)
    private SearchProperties searchProperties;

    public Area() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public SearchProperties getSearchProperties() {
        return searchProperties;
    }

    public void setSearchProperties(SearchProperties searchProperties) {
        this.searchProperties = searchProperties;
    }
}
