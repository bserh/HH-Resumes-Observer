package org.bsgmteam.subsjob.model.search.result;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The project name is subsjob.
 * Created by sergey on 30.11.15 at 23:55.
 * For more information you should send mail to codedealerb@gmail.com
 */
@Entity
public class SearchProperties implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "searchProperties")
    private List<Text> text;
    private boolean onlyWithSalary;
    private String specialization;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "searchProperties")
    private List<Area> areas;
    private int period;
    private String currency;
    private String orderBy;
    private int salary;

    public SearchProperties() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Text> getText() {
        return text;
    }

    public void setText(List<Text> text) {
        this.text = text;
    }

    public boolean isOnlyWithSalary() {
        return onlyWithSalary;
    }

    public void setOnlyWithSalary(boolean onlyWithSalary) {
        this.onlyWithSalary = onlyWithSalary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
