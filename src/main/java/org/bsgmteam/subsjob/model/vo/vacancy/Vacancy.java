package org.bsgmteam.subsjob.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 15.11.15 at 13:14.
 * For more information you should send mail to codedealerb@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancy implements Serializable {
    private String id;
    private boolean premium;
    private Address address;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    private Salary salary;
    private String name;
    private Area area;
    private String url;
    @JsonProperty("published_at")
    private String publishedAt;
    private Employer employer;
    private Type type;
    private Snippet snippet;

    public Vacancy() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id='" + id + '\'' +
                ", premium=" + premium +
                ", address=" + address +
                ", alternateUrl='" + alternateUrl + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", url='" + url + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", employer=" + employer +
                ", type=" + type +
                ", snippet=" + snippet +
                '}';
    }
}
