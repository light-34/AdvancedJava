package org.adv.linkedlisttwo;

public class PersonLinkedList {

    private Person head;

    private int count = 0;

    public PersonLinkedList() {
    }

    public void insertPerson(Person person) {
        Person node = new Person();
        node.setPerson(person);
        head = node;
        count++;
    }

    public void printPersonInfo() {
        Person tempPerson = head;
        while (tempPerson != null) {
            System.out.println("Name : " + tempPerson.getName() + " Last Name : " + tempPerson.getlName() + " Age : " + tempPerson.getAge());
            tempPerson = tempPerson.getPerson();
        }
    }
}
