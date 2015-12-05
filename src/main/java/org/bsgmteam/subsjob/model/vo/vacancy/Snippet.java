package org.bsgmteam.subsjob.model.vo.vacancy;

import java.io.Serializable;

/**
 * The project name is subsjob.
 * Created by sergey on 19.11.15 at 21:36.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class Snippet implements Serializable {
    private String requirement;
    private String responsibility;

    public Snippet() {

    }


    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
