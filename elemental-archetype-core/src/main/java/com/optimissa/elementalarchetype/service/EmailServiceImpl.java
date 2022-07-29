package com.optimissa.elementalarchetype.service;

import com.optimissa.elementalarchetype.config.mail.MailConfig;
import com.optimissa.elementalarchetype.config.mail.MailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by pedro.uceda on 14/03/2017.
 */
@Service
public class EmailServiceImpl implements EmailService {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MailConfig mailConfig;

    public void sendExampleEmail() {
        this.sendHTMLEmail(this.mailConfig.getMailExampleSubject(), this.mailConfig.getFrom(), this.mailConfig.getMailExampleTo(), this.mailConfig.getMailExampleBody());
    }

    public void sendHTMLEmail(String subject, String from, String[] to, String body) {
        this.logger.info("Proceeding to send an email");
        try {
            /*
            A MimeMessage and MimeMessageHelper are used because this is a HTML email. If you don't need the email
            to be HTML formatted, you can use directly a SimpleMailMessage instead, there would not be need to use
            a MimeMessageHelper.
            */
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //We set the second argument to true in order to send a HTML email.
            helper.setText(body, Boolean.TRUE);
            mailSender.send(message);
            this.logger.info("Email sent");
        } catch (Exception e) {
            this.logger.error("An error occurred while sending an email", e);
        }
    }

}
