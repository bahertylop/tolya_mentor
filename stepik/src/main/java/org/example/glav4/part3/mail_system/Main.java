package org.example.glav4.part3.mail_system;

import org.example.glav4.part3.mail_system.mail.message.MailMessage;
import org.example.glav4.part3.mail_system.parts.Spy;
import org.example.glav4.part3.mail_system.parts.UntrustworthyMailWorker;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new Spy[]{new Spy(Logger.getLogger(Spy.class.getName()))});

        worker.processMail(new MailMessage("Austin Powers", "Lev", "sdjcnksjdncksjnc"));
        worker.processMail(new MailMessage("ROMAN", "Austin Powers", "sdjcnksjdncksjnc"));
        worker.processMail(new MailMessage("DK", "CMH", "dksjncs"));
    }
}
