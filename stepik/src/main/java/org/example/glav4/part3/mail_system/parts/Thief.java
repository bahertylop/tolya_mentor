package org.example.glav4.part3.mail_system.parts;

import org.example.glav4.part3.mail_system.mail.Sendable;
import org.example.glav4.part3.mail_system.mail.ppackage.MailPackage;
import org.example.glav4.part3.mail_system.mail.ppackage.Package;
import org.example.glav4.part3.mail_system.service.MailService;

import java.awt.*;

public class Thief implements MailService {

    private final int minCost;

    private int stolenValue = 0;

    public Thief(int minCost) {
        this.minCost = minCost;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package packageInMail = ((MailPackage) mail).getContent();

            if (packageInMail.getPrice() >= minCost) {
                stolenValue += packageInMail.getPrice();

                return new MailPackage(
                        mail.getFrom(),
                        mail.getTo(),
                        new Package(
                                "stones instead of " + packageInMail.getContent(),
                                0
                                )
                );
            }
        }
        return mail;
    }

    public int getStolenValue() {
        return stolenValue;
    }
}
