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
import com.travelcompany.eshop.repo.TicketRepo;
import com.travelcompany.eshop.repo.TicketRepoImpl;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author hnafp
 */
public class TicketServiceImpl implements TicketService {

    public static final String CASH = "cash";
    public static final String CARD = "card";
    public static final BigDecimal DISCOUNT = new BigDecimal("0.1");
    public static final BigDecimal SURCHARGE = new BigDecimal("0.2");

    @Override
    public Ticket BuyTicket(Itinerary itinerary, Customer customer, String paymentMethod) {
        TicketRepo ticketRepoImpl = new TicketRepoImpl();

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
            throw new IllegalArgumentException("Incorrect payment method, must be cash or card");
        }
        ticketAmountPaid = ticketAmountPaid.add(ticketAmountPaid.multiply(surcharge));
        ticketAmountPaid = ticketAmountPaid.subtract(ticketAmountPaid.multiply(discount));
        Ticket ticket = ticketRepoImpl.CreateTicket(ticketPassengerCode, ticketItineraryCode, ticketPaymentMethod, ticketAmountPaid);

        return ticket;
    }

    @Override
    public BigDecimal showTicketsTotalCost(List<Ticket>  Tickets) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (int count = 0; count < Tickets.size(); count++) {
            if (Tickets.get(count) != null) {
                totalCost = totalCost.add(Tickets.get(count).getAmountPaid());
            }
        }
        return totalCost;

    }

    @Override
    public int showTicketsTotalNumber(List<Ticket>  Tickets) {
        int totalNumber = 0;
        for (int count = 0; count < Tickets.size(); count++) {
            if (Tickets.get(count) != null) {
                totalNumber++;

            }
        }
        return totalNumber;

    }

}
