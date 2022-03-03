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

/**
 *
 * @author hnafp
 */
public abstract class TicketService {

    public static final String CASH = "cash";
    public static final String CARD = "card";
    public static final BigDecimal DISCOUNT = new BigDecimal("0.1");
    public static final BigDecimal SURCHARGE = new BigDecimal("0.2");

    protected static Ticket BuyTicket(Itinerary itinerary, Customer customer, String paymentMethod) {
        if (itinerary == null) {
            throw new NullPointerException("the requested itinerary does not exist :itinerary null exception");
        }
        if (customer == null) {
            throw new NullPointerException("the given customer code does not exist :customer null exception");
        }
        String ticketPassengerCode = customer.getCode();
        String ticketItineraryCode = itinerary.getCode();
        String ticketPaymentMethod = paymentMethod;
        BigDecimal ticketAmountPaid = itinerary.getBasicPrice();
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal surcharge = BigDecimal.ZERO;

        if (customer instanceof BusinessCustomer && paymentMethod.equals(CASH)) {
            discount = DISCOUNT;
        } else if (customer instanceof BusinessCustomer && paymentMethod.equals(CARD)) {
            discount = DISCOUNT.add(DISCOUNT);
        } else if (customer instanceof IndividualCustomer && paymentMethod.equals(CASH)) {
            surcharge = SURCHARGE;
        } else if (customer instanceof IndividualCustomer && paymentMethod.equals(CARD)) {
            surcharge = SURCHARGE;
            discount = DISCOUNT;
        } else {
            System.out.println("Wrong input for payment method");
            return null;
        }
        ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
        ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        Ticket ticket = CreateTicket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        System.out.println("Ticket purchase successful " + ticket);
        return ticket;
    }

    protected static Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid) {
        Ticket ticket = new Ticket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);
        return ticket;
    }

    protected static void showAllTickets(Ticket[] Tickets) {
        BigDecimal totalCost = BigDecimal.ZERO;
        int totalNumber = 0;
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
