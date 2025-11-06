package org.adv.ticket;

public class AdultTicket extends Ticket{
    private int price;

    public AdultTicket(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "AdultTicket{" +
                "price=" + price +
                '}';
    }
}
