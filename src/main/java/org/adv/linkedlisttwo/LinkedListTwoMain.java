package org.adv.linkedlisttwo;

import org.adv.linkedlist.LinkedListStart;

import java.util.List;

public class LinkedListTwoMain {
    public static void main(String[] args) {
        PersonLinkedList person = new PersonLinkedList();
        List<Person> people = List.of(new Person("Cezmi", "Aktepe", 43),
                new Person("Zuhal", "Aktepe", 40),
                new Person("Leyla", "Aktepe", 15)
                );
        people.forEach(person::insertPerson);

        person.printPersonInfo();
    }
}
