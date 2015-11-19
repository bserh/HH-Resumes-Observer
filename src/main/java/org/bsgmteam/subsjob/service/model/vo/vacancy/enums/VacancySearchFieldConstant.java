package org.bsgmteam.subsjob.service.model.vo.vacancy.enums;

/**
 * The project name is subsjob.
 * Created by sergey on 19.11.15 at 20:30.
 * For more information you should send mail to codedealerb@gmail.com
 */
public enum VacancySearchFieldConstant {
    TEXT("text", true),

    ORDER_BY("order_by"),
    PAGE("page"),
    PER_PAGE("per_page");
    private final String name;
    private boolean acceptMultipleValues;

    VacancySearchFieldConstant(String name) {
        this(name, false);
    }

    VacancySearchFieldConstant(String name, boolean acceptMultipleValues) {
        this.name = name;
        this.acceptMultipleValues = acceptMultipleValues;
    }

    public String getName() {
        return name;
    }

    public boolean isAcceptMultipleValues() {
        return acceptMultipleValues;
    }
}
