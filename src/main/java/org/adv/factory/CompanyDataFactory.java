package org.adv.factory;

import java.util.Objects;

public class CompanyDataFactory {
    private static final String TYPE = "*COMP";
    private static final CompanyDataFactory INSTANCE = new CompanyDataFactory(TYPE);

    private final String type;

    public CompanyDataFactory(String type) {
        this.type = type;
    }

    // This is a static factory method that can be called without creating an instance of the class
    public static CompanyDataFactory of(String type) {
        Objects.requireNonNull(type, "Type must not be null"); //if `id` is null, throws a `NullPointerException` with the message "id must not be null"
        if (type.equalsIgnoreCase(TYPE)) {
            return INSTANCE;
        }
        return new CompanyDataFactory(type);
    }


}
