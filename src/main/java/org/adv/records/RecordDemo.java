package org.adv.records;

import java.util.ArrayList;
import java.util.List;

/**
 * Records are :
 * Massive Boilerplate Reduction: The compiler automatically generates the constructor, all accessor methods, and reliable implementations of equals(), hashCode(), and toString().
 * Immutability by Default: All components are final, making records inherently immutable.
 * No Inheritance: Records are implicitly final and cannot extend another class (though they can implement interfaces).
 * Records are only available from Java 16 onwards.
 */

public class RecordDemo {
    public static void main(String[] args) {
        FirstRecord firstRecord = new FirstRecord("John", 45);
        FirstRecord secondRecord = new FirstRecord("Ali", 40);
        List<FirstRecord> records = new ArrayList<>();
        records.add(firstRecord);
        records.add(secondRecord);

        records.forEach(rec -> {
            System.out.printf("Name : %s Age : %d \n", rec.name(), rec.age());
        });
    }

}

