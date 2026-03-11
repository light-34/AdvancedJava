package org.adv.invocation_handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoked method: " + method.getName());

        /*
         How to distinguish methods effectively
       If you have many methods, using a long if-else chain or a switch statement on method.getName() is common. You can also inspect:
        method.getParameterTypes(): Useful if you have overloaded methods (same name, different arguments).
        method.getAnnotations(): Useful if you want to trigger logic only for methods marked with a custom annotation like @Transactional or @Loggable.*/

//        Important Tip: The Object Methods
//        By default, calls to toString(), equals(), and hashCode() are also sent to your InvocationHandler.
//        If you don't handle them specifically, they will be passed to your target object just like your business methods.
        String methodName = method.getName();
        if ("sendMessage".equals(methodName)) {
            System.out.println("Sending message method is invoked");
        } else if ("clearHistory".equals(methodName)) {
            System.out.println("Clear history method is invoked");
        }

        // Call the actual method on the real object
        Object result = method.invoke(target, args);
        return  result;
    }
}
