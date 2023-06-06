package com.codals.greating.email;

import org.thymeleaf.context.Context;

public interface EmailSender {

    void sendEmail(String toEmail, String subject, String templateName, Context context);
}
