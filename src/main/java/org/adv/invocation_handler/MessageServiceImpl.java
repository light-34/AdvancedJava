package org.adv.invocation_handler;

public class MessageServiceImpl implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message : " + message);
    }

    @Override
    public void clearHistory() {
        System.out.println("Clearing history ... ");
    }
}
