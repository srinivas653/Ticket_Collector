package com.example.TicketSeller.Service;

import com.example.TicketSeller.Domain.EventTicket;

import java.util.List;

public interface ITicketSeller {
    List<EventTicket> getQuantity(int seller_id);
    EventTicket saveTickets(EventTicket eventTicket);
    Integer countTicketsSold(int sellerId);
}
