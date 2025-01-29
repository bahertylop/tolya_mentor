package org.example.glav4.part3.mail_system.parts;

import org.example.glav4.part3.mail_system.mail.Sendable;
import org.example.glav4.part3.mail_system.mail.ppackage.MailPackage;
import org.example.glav4.part3.mail_system.service.MailService;
import org.example.glav4.part3.mail_system.service.RealMailService;

public class UntrustworthyMailWorker implements MailService {

    private final RealMailService realMailService = new RealMailService();

    private final MailService[] fakeMailServices;

    public UntrustworthyMailWorker(MailService[] fakeMailServices) {
        this.fakeMailServices = fakeMailServices;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService : fakeMailServices) {
            mail = mailService.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}
