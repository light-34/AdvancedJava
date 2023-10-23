package org.adv.linkedlist;

public class LinkedListStart {
    private NodeStart head;
    private int count = 1;

    public LinkedListStart(NodeStart head) {
        this.head = head;
    }

    public void insert(String val) {
        NodeStart node = new NodeStart(val);
        node.setNext(head);
        head = node;
        count++;
    }

    public int getCount() {
        return count;
    }

    public NodeStart find(String val) {
        NodeStart item = head;

        while (item != null) {
            if (item.getVal().equals(val))
                return item;
            else
                item = item.getNext();
        }
        return null;
    }

    public void deleteAt(int index) {
        if (index > count - 1)
            return;
        if (index == 0) {
            head = head.getNext();
        }
        else {
            int tempIndex = 0;
            NodeStart node = head;
            while (tempIndex < index - 1) {
                node = node.getNext();
                tempIndex++;
            }
            node.setNext(node.getNext().getNext());
            count--;
        }

    }

    public void printNode() {
        NodeStart tempNode = head;
        while (tempNode != null) {
            System.out.println("Node : " + tempNode.getVal());
            tempNode = tempNode.getNext();
        }
    }
}
