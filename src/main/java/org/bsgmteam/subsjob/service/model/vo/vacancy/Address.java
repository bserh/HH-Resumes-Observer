package org.bsgmteam.subsjob.service.model.vo.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 15.11.15 at 14:10.
 * For more information you should send mail to codedealerb@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {
    private String city;
    private String street;
    private String building;
    private double lat;
    private double lng;

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
