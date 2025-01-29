package org.example.glav4.part3.mail_system.service;

import org.example.glav4.part3.mail_system.mail.Sendable;
import org.example.glav4.part3.mail_system.service.MailService;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
