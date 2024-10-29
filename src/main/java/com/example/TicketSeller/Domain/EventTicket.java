package com.example.TicketSeller.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "ticket")
public class EventTicket {

    private String event_ticket;
    @Id
    private int event_ticket_id;
    @Column(name = "sellerId")
    private int sellerId;
    private int soldBy;
    private int amount;
    private int quantity;

    public EventTicket() {
    }

    public EventTicket(String event_ticket, int event_ticket_id, int sellerId, int soldBy, int amount, int quantity) {
        this.event_ticket = event_ticket;
        this.event_ticket_id = event_ticket_id;
        this.sellerId = sellerId;
        this.soldBy = soldBy;
        this.amount = amount;
        this.quantity = quantity;
    }


    public String getEvent_ticket() {
        return event_ticket;
    }

    public void setEvent_ticket(String event_ticket) {
        this.event_ticket = event_ticket;
    }

    public int getEvent_ticket_id() {
        return event_ticket_id;
    }

    public void setEvent_ticket_id(int event_ticket_id) {
        this.event_ticket_id = event_ticket_id;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(int soldBy) {
        this.soldBy = soldBy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "EventTicket{" +
                "event_ticket='" + event_ticket + '\'' +
                ", event_ticket_id=" + event_ticket_id +
                ", sellerId=" + sellerId +
                ", soldBy=" + soldBy +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
