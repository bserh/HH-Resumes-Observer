package org.bsgmteam.subsjob.service.notification.email.impl;

import org.bsgmteam.subsjob.model.search.result.SearchProperties;
import org.junit.Test;

/**
 * The project name is subsjob.
 * Created by sergey on 06.12.15 at 17:51.
 * For more information you should send mail to codedealerb@gmail.com
 */
public class MailNotificationTest {
    @Test
    public void testMailNotify() {
        MailNotification notification = new MailNotification();

        SearchProperties properties = new SearchProperties();
        properties.setCurrency("RUR");
        properties.setPeriod(30);
        properties.setOnlyWithSalary(true);
        properties.setSpecialization("IT");
        properties.setOrderBy("date");
        properties.setSalary(101010);
        properties.setUserEmail("iflash95@gmail.com");
        notification.sendSearchResults("iflash95@gmail.com", "codedealerb@gmail.com", "test");
    }
}
