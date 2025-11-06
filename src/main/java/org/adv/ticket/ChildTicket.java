package org.adv.ticket;

public class ChildTicket extends Ticket{
    private int price;

    public ChildTicket(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ChildTicket{" +
                "price=" + price +
                '}';
    }
}
