/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author hnafp
 */
public class Service {

    public void runService() {

        Customer customer = CustomerService.CreateCustomer();
        System.out.println("You are logged in with new user: credentials " + customer);
        Instant instant = Instant.parse("2022-02-01T13:35:00.00Z");
        System.out.println("Enter a number corresponding to a following action: 1.Create an Itinerary 2. ");
        Itinerary itinerary = ItineraryService.CreateItinerary("1", "ATH", "BER", "SkyLines", Date.from(instant), new BigDecimal("120"));
        TicketService.BuyTicket(itinerary, customer, "cash");
    }
}
