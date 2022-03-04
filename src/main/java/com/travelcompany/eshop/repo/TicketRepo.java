/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author hnafp
 */
public interface TicketRepo {

    Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid);
    List<Ticket> GetTickets();
}
