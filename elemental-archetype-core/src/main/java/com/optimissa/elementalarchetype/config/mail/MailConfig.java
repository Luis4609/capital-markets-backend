package com.optimissa.elementalarchetype.config.mail;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by pedro.uceda on 10/11/2016.
 */
@Configuration
@PropertySource("file:${ELEMENTAL_ARCHETYPE_HOME}/Development/mail.properties")
public class MailConfig {

    @Value("${mail.transport.protocol}")
    private String protocol;
    @Value("${mail.smtp.host}")
    private String host;
    @Value("${mail.smtp.port}")
    private Integer port;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.smtp.auth}")
    private String auth;
    @Value("${mail.smtp.starttls.enable}")
    private String starTTLSEnable;
    @Value("${mail.from}")
    private String from;

    @Value("${mail.example.subject}")
    private String mailExampleSubject;
    @Value("#{'${mail.example.to}'.split(',')}")
    private String[] mailExampleTo;
    @Value("${mail.example.body}")
    private String mailExampleBody;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getStarTTLSEnable() {
        return starTTLSEnable;
    }

    public void setStarTTLSEnable(String starTTLSEnable) {
        this.starTTLSEnable = starTTLSEnable;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMailExampleSubject() {
        return mailExampleSubject;
    }

    public void setMailExampleSubject(String mailExampleSubject) {
        this.mailExampleSubject = mailExampleSubject;
    }

    public String[] getMailExampleTo() {
        return mailExampleTo;
    }

    public void setMailExampleTo(String[] mailExampleTo) {
        this.mailExampleTo = mailExampleTo;
    }

    public String getMailExampleBody() {
        return mailExampleBody;
    }

    public void setMailExampleBody(String mailExampleBody) {
        this.mailExampleBody = mailExampleBody;
    }
}
