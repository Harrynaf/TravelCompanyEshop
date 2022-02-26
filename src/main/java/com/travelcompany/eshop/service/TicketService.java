/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import java.math.BigDecimal;

/**
 *
 * @author hnafp
 */
public abstract class TicketService {

    public static void BuyTicket(Itinerary itinerary, Customer customer, String paymentMethod) {
        String ticketPassengerCode=customer.getCode();
        String ticketItineraryCode=itinerary.getCode();
        String ticketPaymentMethod=paymentMethod;
        BigDecimal ticketAmountPaid=itinerary.getBasicPrice();
        
        if(customer instanceof BusinessCustomer && paymentMethod.equals("cash"))
        ticketAmountPaid=ticketAmountPaid;
        
        
        Ticket ticket = CreateTicket(ticketPassengerCode,ticketItineraryCode,ticketPaymentMethod,ticketAmountPaid);
    }

    public static Ticket CreateTicket(String ticketPassengerCode, String ticketItineraryCode, String ticketPaymentMethod, BigDecimal ticketAmountPaid) {

        return null;
    }
    public static void showAllTickets(){}
    public static void showAllItinerariesPerDestDep(String Destination, String Departure){}
    
}
