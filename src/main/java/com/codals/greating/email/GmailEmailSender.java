package com.codals.greating.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Log4j2
@Service
@RequiredArgsConstructor
public class GmailEmailSender implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Override
    public void sendEmail(String toEmail, String subject, String templateName, Context context) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject(subject);

            String htmlContent = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error("Failed to send email : {}", e);
        }
    }
}
