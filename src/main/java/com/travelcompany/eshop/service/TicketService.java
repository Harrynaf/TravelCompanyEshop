/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.IndividualCustomer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;
import java.util.Locale;

/**
 *
 * @author hnafp
 */
public abstract class TicketService {

    public static Ticket BuyTicket(Itinerary itinerary, Customer customer, String paymentMethod) {
        String ticketPassengerCode = customer.getCode();
        String ticketItineraryCode = itinerary.getCode();
        String ticketPaymentMethod = paymentMethod;
        BigDecimal ticketAmountPaid = itinerary.getBasicPrice();
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal surcharge = BigDecimal.ZERO;

        if (customer instanceof BusinessCustomer && paymentMethod.equals("cash")) {
            discount = new BigDecimal("0.1");
            ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
            ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        } else if (customer instanceof BusinessCustomer && paymentMethod.equals("card")) {
            discount = new BigDecimal("0.2");
            ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
            ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        }
        if (customer instanceof IndividualCustomer && paymentMethod.equals("cash")) {
            surcharge = new BigDecimal("0.2");
            ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
            ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        } else if (customer instanceof IndividualCustomer && paymentMethod.equals("card")) {
            surcharge = new BigDecimal("0.2");
            discount = new BigDecimal("0.1");
            ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
            ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        }

        Ticket ticket = CreateTicket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        System.out.println("Ticket purchase successful " + ticket);
        return ticket;
    }

    public static Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid) {
        Ticket ticket = new Ticket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        return ticket;
    }

    public static void showAllTickets(Ticket[] Tickets) {
        BigDecimal totalCost= BigDecimal.ZERO;
        int totalNumber=0;
        for (int count = 0; count < Tickets.length; count++) {
            if (Tickets[count] != null) {
                System.out.println(Tickets[count]);
                totalNumber++;
                totalCost = totalCost.add(Tickets[count].getAmountPaid());
            }
        }
        System.out.println(totalCost);
        System.out.println(totalNumber);
        
    }

}
