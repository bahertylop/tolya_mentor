package org.example.glav4.part3.mail_system.parts;

import org.example.glav4.part3.mail_system.exception.IllegalPackageException;
import org.example.glav4.part3.mail_system.exception.StolenPackageException;
import org.example.glav4.part3.mail_system.mail.Sendable;
import org.example.glav4.part3.mail_system.mail.ppackage.MailPackage;
import org.example.glav4.part3.mail_system.mail.ppackage.Package;
import org.example.glav4.part3.mail_system.service.MailService;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            String content = ((MailPackage) mail).getContent().getContent();
            if (content.contains("weapons") || content.contains("banned substance")) {
                throw new IllegalPackageException();
            }
            if (content.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
