package org.example.glav4.part3.mail_system.service;

import org.example.glav4.part3.mail_system.mail.Sendable;

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
public interface MailService {
    Sendable processMail(Sendable mail);
}
