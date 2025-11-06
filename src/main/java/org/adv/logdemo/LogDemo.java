package org.adv.logdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogDemo {
    private static final Logger LOG = LogManager.getLogger(LogDemo.class);

    public static void main(String[] args) {
        String value = "Debug value";
        LOG.atInfo().log("Application Started");

        if (LOG.isDebugEnabled()) {
            LOG.atDebug().log(value);
        }

        try {
            int num = 10 / 0;
        } catch (ArithmeticException e) {
            LOG.atError().log("Arithmetic Exception occured {}", e.getMessage());
        }

        LOG.atWarn().log("This is a warning log message");
        LOG.atInfo().log("Application Terminated");
    }
}
