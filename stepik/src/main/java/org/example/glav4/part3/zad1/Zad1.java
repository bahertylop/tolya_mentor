package org.example.glav4.part3.zad1;

import java.util.logging.*;

public class Zad1 {

    private static void configureLogging() {
        Logger loggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerClassA.setLevel(Level.ALL);

        Logger loggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerClassB.setLevel(Level.WARNING);

        Logger loggerJava = Logger.getLogger("org.stepic.java");
        loggerJava.setLevel(Level.ALL);
        loggerJava.setUseParentHandlers(false);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());

        loggerJava.addHandler(handler);
    }

}
