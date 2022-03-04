/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hnafp
 */
public final class TicketRepoImpl implements TicketRepo {

    List<Ticket> Tickets = new ArrayList<>();

    @Override
    public Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid) {
        Ticket ticket = new Ticket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        Tickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> GetTickets() {
        return Tickets;
    }
}
