package org.bsgmteam.subsjob.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 07.12.15 at 2:44.
 * For more information you should send mail to codedealerb@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusteredVacancyWrapper implements Serializable {
    @JsonProperty("per_page")
    private int perPage;
    private ClusteredVacancy[] clusters;
    private int page;
    private int pages;
    private int found;

    public ClusteredVacancyWrapper() {

    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public ClusteredVacancy[] getClusters() {
        return clusters;
    }

    public void setClusters(ClusteredVacancy[] clusters) {
        this.clusters = clusters;
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
