package org.adv.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedListStart linked = new LinkedListStart(new NodeStart("hello"));
        linked.insert("merhaba");
        linked.insert("privet");
        linked.insert("ola");

        linked.printNode();

        System.out.println("Number of Nodes " + linked.getCount());

        System.out.println(linked.find("privet").getVal());

        linked.deleteAt(1);

        System.out.println("Nodes after Deletion : ");
        linked.printNode();

        System.out.println("Node Count : " + linked.getCount());

    }
}
