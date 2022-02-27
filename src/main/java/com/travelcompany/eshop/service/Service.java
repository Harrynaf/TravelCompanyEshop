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
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class Service {

    public static final int SIZE = 10;
    public static final String BLANK = "";

    public void runService() {

        //Populate with new customers itineraries and tickets
        Instant instant = Instant.parse("2022-02-01T13:35:00.00Z");
        Instant instant1 = Instant.parse("2022-04-01T13:35:00.00Z");
        Itinerary[] Itineraries = new Itinerary[SIZE];
        Itineraries[0] = ItineraryService.CreateItinerary("1", "ATH", "BER", "SkyLines", Date.from(instant), new BigDecimal("120"));
        Itineraries[1] = ItineraryService.CreateItinerary("2", "ATH", "PAR", "SkyLines", Date.from(instant1), new BigDecimal("140"));
        Itineraries[2] = ItineraryService.CreateItinerary("3", "ATH", "NYC", "SkyLines", Date.from(instant), new BigDecimal("180"));
        Itineraries[3] = ItineraryService.CreateItinerary("4", "ATH", "AUS", "SkyLines", Date.from(instant1), new BigDecimal("170"));
        Itineraries[4] = ItineraryService.CreateItinerary("5", "ATH", "CHN", "SkyLines", Date.from(instant), new BigDecimal("190"));
        Itineraries[5] = ItineraryService.CreateItinerary("6", "ATH", "JPN", "SkyLines", Date.from(instant1), new BigDecimal("195"));

        Customer[] Customers = new Customer[SIZE];
        Customers[1] = new BusinessCustomer("A1", "Harry", "Naf", "asdas@dasd.com", "asda", "Greek");
        Customers[2] = new BusinessCustomer("A2", "1", "1", "1asdas@dasd.com", "1asda", "Greek");
        Customers[3] = new IndividualCustomer("B3", "2", "2", "21asdas@dasd.com", "21asda", "Chinese");
        Customers[4] = new IndividualCustomer("G3", "2", "2", "21asdas@dasd.com", "21asda", "Japanese");
        Ticket[] Tickets = new Ticket[SIZE];
        int ticketBoughtCount = 3;
        Tickets[0] = TicketService.BuyTicket(Itineraries[1], Customers[1], "cash");
        Tickets[1] = TicketService.BuyTicket(Itineraries[2], Customers[2], "cash");
        Tickets[2] = TicketService.BuyTicket(Itineraries[3], Customers[3], "card");

        //Main code
        Customers[0] = CustomerService.CreateCustomer();
        String option = BLANK;
        String option1 = BLANK;
        Itinerary chosenItinerary = null;
        System.out.println("You are logged in with new user: credentials " + Customers[0]);
        while (!option.equals("exit")) {
            System.out.println("Enter a number corresponding to a following action: 1.Buy a ticket 2.List of the total number and cost of tickets for all customers 3.List of the total offered itineraries per destination and departure \n4.List of the customers who purchased the most tickets and the number of purchases 5.List of the customers who have not purchased any tickets  ");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object     
            option = myObj.nextLine();
            if (option.equals("1")) {
                System.out.println("Choose one of the following itineraries by typing the code");
                ItineraryService.showAllItineraries(Itineraries);
                option = myObj.nextLine();
                for (int count = 0; count < Itineraries.length; count++) {
                    if (Itineraries[count] != null) {
                        if (Itineraries[count].getCode().equals(option)) {
                            chosenItinerary = Itineraries[count];
                        }
                    }
                }
                System.out.println("Would you like to buy buy cash or card");
                option = myObj.nextLine();
                Tickets[ticketBoughtCount] = TicketService.BuyTicket(chosenItinerary, Customers[0], option);
                ticketBoughtCount++;

            }
            if (option.equals("2")) {
                TicketService.showAllTickets(Tickets);
            }
            if (option.equals("3")) {
                System.out.println("Enter correctly the itinerary departure and destinaiton codes");
                option = myObj.nextLine();
                option1 = myObj.nextLine();
                ItineraryService.showAllItinerariesPerDestDep(Itineraries, option, option1);
            }
            if (option.equals("4")) {
                CustomerService.showCustomersWithMostTickets(Customers, Tickets);
            }
            if (option.equals("5")) {
                CustomerService.showCustomersWithoutTickets(Customers, Tickets);
            }
        }
    }
}
