/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;

/**
 *
 * @author hnafp
 */
public class TicketRepoImpl implements TicketRepo{
     @Override
     public Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid) {
        Ticket ticket = new Ticket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        return ticket;
    }
    
}
