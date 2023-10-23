package org.adv.linkedlisttwo;

public class PersonNode {

    private Person input;
    private Person next = null;

    public PersonNode(Person input) {
        this.input = input;
    }

    public Person getInput() {
        return input;
    }

    public void setInput(Person input) {
        this.input = input;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}
