package org.adv.ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketMain {
    public static void main(String[] args) {
        List<Ticket> tickets = flattenedList(Arrays.asList(
                Arrays.asList(new ChildTicket(20), new ChildTicket(20), new ChildTicket(20)),
                Arrays.asList(new AdultTicket(25), new AdultTicket(25), new AdultTicket(25))
        ));

        System.out.println(getTotalPrice(tickets));

    }

    public static <T> List<T> flattenedList(List<List<T>> nested ) {
        List<T> flattened = new ArrayList<>();

        nested.forEach(flattened::addAll);

        return flattened;
    }

    public static int getTotalPrice(List<? extends Ticket> tickets) {
        return tickets.stream().map(Ticket::getPrice).mapToInt(Integer::intValue).sum();
    }
}
