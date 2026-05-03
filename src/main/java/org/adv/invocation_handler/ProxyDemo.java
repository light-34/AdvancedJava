package org.adv.invocation_handler;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyDemo {
    public static void main(String[] args) {
        MessageService messageService = new MessageServiceImpl();

        // Create the proxy
        MessageService proxy = (MessageService) Proxy.newProxyInstance(
                MessageService.class.getClassLoader(),
                new Class[]{MessageService.class}, //can be added many interfaces
                new LoggingHandler(messageService));

        // Call the proxy, not the real service directly
        proxy.sendMessage("Hello World");
        proxy.clearHistory();
    }
}
