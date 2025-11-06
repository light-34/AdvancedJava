package org.adv.linkedlist;

public class NodeStart {
    private String val;
    private NodeStart next = null;

    public NodeStart(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public NodeStart getNext() {
        return next;
    }

    public void setNext(NodeStart next) {
        this.next = next;
    }
}
