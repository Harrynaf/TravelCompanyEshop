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
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class Service {

    public void runService() {

        //Populate with new customers itineraries and tickets
        Instant instant = Instant.parse("2022-02-01T13:35:00.00Z");
        Itinerary[] Itineraries=null;
        Itineraries[0] = ItineraryService.CreateItinerary("1", "ATH", "BER", "SkyLines", Date.from(instant), new BigDecimal("120"));
        //Main code
        Customer customer = CustomerService.CreateCustomer();
        System.out.println("You are logged in with new user: credentials " + customer);
        
        System.out.println("Enter a number corresponding to a following action: 1.Buy a ticket 2.List of the total number and cost of tickets for all customers 3.List of the total offered itineraries per destination and departure 4.List of the customers who purchased the most tickets and the number of purchases 5.List of the customers who have not purchased any tickets  ");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object     
        String option = myObj.nextLine(); 
        if (option.equals("1"))
        {
      System.out.println("Choose one of the following itineraries by typing the code");
      ItineraryService.showAllItineraries(Itineraries);
      for (int count=0; count<Itineraries.length; count++)
         // if Itineraries[count].getCode().equals("")
        TicketService.BuyTicket(Itineraries[0], customer, "cash");
        
        }
        if (option.equals("2"))
         TicketService.showAllTickets();
        if (option.equals("3"))
         TicketService.showAllItinerariesPerDestDep(option, option);
        if (option.equals("4"))
         CustomerService.showCustomersWithMostTickets();
        if (option.equals("5"))
         CustomerService.showCustomersWithoutTickets();
        
        
        
    }
}
