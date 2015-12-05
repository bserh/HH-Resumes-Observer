package org.bsgmteam.subsjob.model.search.result;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 01.12.15 at 0:24.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Entity
public class Text implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private SearchProperties searchProperties;
    private String text;

    public Text() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SearchProperties getSearchProperties() {
        return searchProperties;
    }

    public void setSearchProperties(SearchProperties searchProperties) {
        this.searchProperties = searchProperties;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
