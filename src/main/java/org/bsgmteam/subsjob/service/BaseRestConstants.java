package org.bsgmteam.subsjob.service;

import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * The project name is subsjob.
 * Created by sergey on 28.11.15 at 19:52.
 * For more information you should send mail to codedealerb@gmail.com
 */
public abstract class BaseRestConstants {
    public final static String BASE_URL = "https://api.hh.ru/vacancies";

    public static HttpEntity getHTTPEntity() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        headers.set("User-Agent", "subsjob/1.0 (codedealerb@gmail.com)");
        headers.add("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity(headers);

        return entity;
    }
}
