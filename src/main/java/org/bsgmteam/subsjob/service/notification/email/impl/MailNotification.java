package org.bsgmteam.subsjob.service.notification.email.impl;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.bsgmteam.subsjob.model.search.result.SearchProperties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MailNotification {
    private VelocityEngine velocityEngine;

    public VelocityEngine getVelocityEngine()
            throws VelocityException, IOException {
        if (this.velocityEngine == null) {
            velocityEngine = new VelocityEngine();
            Properties p = new Properties();
            p.setProperty("resource.loader", "class");
            p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            velocityEngine.init(p);
        }

        return velocityEngine;
    }

    public JavaMailSender getMailSender() throws IOException, ParseException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setJavaMailProperties(getMailProperties());

        mailSender.setUsername(getUserName());
        mailSender.setPassword(getPassword());

        return mailSender;
    }

    public void sendSearchResults(SearchProperties properties) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            message.setTo(properties.getUserEmail());
            message.setFrom(new InternetAddress(getUserName()));
            message.setSubject("Search result by day");

            Map model = new HashMap<>();//FIXME add data and build html

            String body = VelocityEngineUtils.mergeTemplateIntoString(
                    getVelocityEngine(), "velocity/mail.vm", "UTF-8", null);
            message.setText(body, true);
        };
        try {
            JavaMailSender mailSender = getMailSender();
            mailSender.send(preparator);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Properties getMailProperties() {
        Properties props = new Properties();
        JSONParser parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("mail/mail_properties").getFile());

        JSONObject propertiesMarshaler = null;
        try {
            propertiesMarshaler = (JSONObject) parser.parse(new FileReader(file));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        props.put("mail.transport.protocol", propertiesMarshaler.get("mail.transport.protocol"));
        props.put("mail.host", propertiesMarshaler.get("mail.host"));
        props.put("mail.smtp.auth", propertiesMarshaler.get("mail.smtp.auth"));
        props.put("mail.smtp.port", propertiesMarshaler.get("mail.smtp.port"));
        props.put("mail.debug", propertiesMarshaler.get("mail.debug"));
        props.put("mail.smtp.socketFactory.port", propertiesMarshaler.get("mail.smtp.socketFactory.port"));
        props.put("mail.smtp.socketFactory.class", propertiesMarshaler.get("mail.smtp.socketFactory.class"));
        props.put("mail.smtp.socketFactory.fallback", propertiesMarshaler.get("mail.smtp.socketFactory.fallback"));

        return props;
    }

    private String getUserName() {
        ClassLoader classLoader = getClass().getClassLoader();
        JSONParser parser = new JSONParser();
        File file = new File(classLoader.getResource("mail/account_properties").getFile());
        JSONObject propertiesMarshaler = null;
        try {
            propertiesMarshaler = (JSONObject) parser.parse(new FileReader(file));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return (String) propertiesMarshaler.get("email_for_notification");
    }

    private String getPassword() {
        ClassLoader classLoader = getClass().getClassLoader();
        JSONParser parser = new JSONParser();
        File file = new File(classLoader.getResource("mail/account_properties").getFile());
        JSONObject propertiesMarshaler = null;
        try {
            propertiesMarshaler = (JSONObject) parser.parse(new FileReader(file));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return (String) propertiesMarshaler.get("password_for_notification");
    }
}
