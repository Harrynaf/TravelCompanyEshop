/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author hnafp
 */
public interface TicketService {

    Ticket BuyTicket(Itinerary itinerary, Customer customer, String paymentMethod);

    BigDecimal showTicketsTotalCost(List<Ticket> Tickets);

    int showTicketsTotalNumber(List<Ticket> Tickets);
}
