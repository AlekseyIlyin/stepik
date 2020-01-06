package org.stepik.task.task03.task0308;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) {
    }

    private static void configureLogging() {
        Logger logger_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        logger_A.setLevel(Level.ALL);

        Logger logger_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        logger_B.setLevel(Level.WARNING);

        Logger logger_C = Logger.getLogger("org.stepic.java");
        java.util.logging.ConsoleHandler handlerC = new ConsoleHandler();
        handlerC.setLevel(Level.ALL);
        handlerC.setFormatter(new XMLFormatter());
        logger_C.addHandler(handlerC);
        logger_C.setUseParentHandlers(false);
    }
}
