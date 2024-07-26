package org.adv.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;


public class UuidDemo {
    private static final Logger LOG = LogManager.getLogger(UuidDemo.class.getName());
    public static void main(String[] args) {

        UUID transactionId = UUID.randomUUID();

        //Add context information
        ThreadContext.push("id", transactionId.toString());

        LOG.warn("Info message Logged");

        ThreadContext.clearMap();

    }
}
