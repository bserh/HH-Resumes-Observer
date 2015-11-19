package org.bsgmteam.subsjob.service.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 19.11.15 at 20:04.
 * For more information you should send mail to codedealerb@gmail.com
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyPagingWrapper implements Serializable {
    @JsonProperty("per_page")
    private int perPage;
    private Vacancy[] items;
    private int page;
    private int pages;
    private int found;

    public VacancyPagingWrapper() {

    }


    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public Vacancy[] getItems() {
        return items;
    }

    public void setItems(Vacancy[] items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }
}
