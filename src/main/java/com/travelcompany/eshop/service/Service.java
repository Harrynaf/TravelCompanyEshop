/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.ItineraryCityCodes;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.repo.CustomerRepo;
import com.travelcompany.eshop.repo.CustomerRepoImpl;
import com.travelcompany.eshop.repo.ItineraryRepo;
import com.travelcompany.eshop.repo.ItineraryRepoImpl;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class Service {

    public static final int SIZE = 10;
    public static final String BLANK = "";

    public void runService() {
        //Repo and service
        ItineraryRepo itineraryRepoImpl = new ItineraryRepoImpl();
        CustomerRepo customerRepoImpl = new CustomerRepoImpl();
        TicketService ticketServiceImpl = new TicketServiceImpl();
        CustomerService customerServiceImpl = new CustomerServiceImpl();
        ItineraryService itineraryServiceImpl = new ItineraryServiceImpl();
        //Populate with new customers itineraries and tickets
        Instant instant = Instant.parse("2022-02-01T13:35:00.00Z");
        Instant instant1 = Instant.parse("2022-04-01T13:35:00.00Z");
        List<Itinerary> Itineraries = new ArrayList<>();
        //Itinerary[] Itineraries = new Itinerary[SIZE];
        Itineraries.add(itineraryRepoImpl.CreateItinerary("1", ItineraryCityCodes.ATH, ItineraryCityCodes.BER, "SkyLines", Date.from(instant), new BigDecimal("120")));
        Itineraries.add(itineraryRepoImpl.CreateItinerary("2", ItineraryCityCodes.ATH, ItineraryCityCodes.PAR, "SkyLines", Date.from(instant1), new BigDecimal("140")));
        Itineraries.add(itineraryRepoImpl.CreateItinerary("3", ItineraryCityCodes.AUS, ItineraryCityCodes.NYC, "SkyLines", Date.from(instant), new BigDecimal("180")));
        Itineraries.add(itineraryRepoImpl.CreateItinerary("4", ItineraryCityCodes.NYC, ItineraryCityCodes.AUS, "SkyLines", Date.from(instant1), new BigDecimal("170")));
        Itineraries.add(itineraryRepoImpl.CreateItinerary("5", ItineraryCityCodes.CHN, ItineraryCityCodes.JPN, "SkyLines", Date.from(instant), new BigDecimal("190")));
        Itineraries.add(itineraryRepoImpl.CreateItinerary("6", ItineraryCityCodes.ATH, ItineraryCityCodes.NYC, "SkyLines", Date.from(instant1), new BigDecimal("195")));
        // Customer[] Customers = new Customer[SIZE];
        List<Customer> Customers = new ArrayList<>();
        Customers.add(customerRepoImpl.CreateBusinessCustomer("A1", "Harry", "Naf", "asdas@dasd.com", "asda", "Greek"));
        Customers.add(customerRepoImpl.CreateBusinessCustomer("A2", "1", "1", "1asdas@dasd.com", "1asda", "Greek"));
        Customers.add(customerRepoImpl.CreateIndividualCustomer("B3", "2", "2", "21asdas@dasd.com", "21asda", "Chinese"));
        Customers.add(customerRepoImpl.CreateIndividualCustomer("G3", "2", "2", "21asdas@dasd.com", "21asda", "Japanese"));
        List<Ticket> Tickets = new ArrayList<>();
        //Ticket[] Tickets = new Ticket[SIZE];
        //int ticketBoughtCount = 3;
        Tickets.add(ticketServiceImpl.BuyTicket(Itineraries.get(0), Customers.get(0), "cash"));
        Tickets.add(ticketServiceImpl.BuyTicket(Itineraries.get(1), Customers.get(1), "cash"));
        Tickets.add(ticketServiceImpl.BuyTicket(Itineraries.get(2), Customers.get(2), "card"));
        //Main code
        System.out.println("Please enter customer code,name,surname,email,address,nationality and category(Business/Individual), in that order");
        Customer thisCustomer = customerServiceImpl.CreateCustomer();
        Customers.add(thisCustomer);
        System.out.println("Customer created");
        String option = BLANK;
        String option1;
        Itinerary chosenItinerary = null;
        System.out.println("You are logged in with new user: credentials " + thisCustomer);
        while (!option.equals("exit")) {
            System.out.println("Enter a number corresponding to a following action: 1.Buy a ticket 2.List of the total number and cost of tickets for all customers 3.List of the total offered itineraries per destination and departure \n4.List of the customers who purchased the most tickets and the number of purchases 5.List of the customers who have not purchased any tickets, 'exit' to close");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object     
            option = myObj.nextLine();
            if (option.equals("1")) {
                System.out.println("Choose one of the following itineraries by typing the code");
                for (Itinerary Itinerarie : Itineraries) {
                    System.out.println(Itinerarie);
                }
                option = myObj.nextLine();
                for (Itinerary Itinerarie : Itineraries) {
                    if (Itinerarie != null) {
                        if (Itinerarie.getCode().equals(option)) {
                            chosenItinerary = Itinerarie;
                        }
                    }
                }
                System.out.println("Would you like to buy buy cash or card");
                option = myObj.nextLine();
                Ticket boughtTicket = ticketServiceImpl.BuyTicket(chosenItinerary, thisCustomer, option);
                Tickets.add(boughtTicket);
                System.out.println("Ticket purchase successful " + boughtTicket);

            }
            if (option.equals("2")) {
                for (Ticket Tickett : Tickets) {
                    if (Tickett != null) {
                        System.out.println(Tickett);
                    }
                }
                System.out.println(ticketServiceImpl.showTicketsTotalCost(Tickets));
                System.out.println(ticketServiceImpl.showTicketsTotalNumber(Tickets));

            }
            if (option.equals("3")) {
                System.out.println("Enter correctly the itinerary departure and destinaiton codes");
                option = myObj.nextLine();
                option1 = myObj.nextLine();
                List<Itinerary> ChosenItineraries = itineraryServiceImpl.showAllItinerariesPerDestDep(Itineraries, option, option1);
                for (Itinerary key : ChosenItineraries) {
                    System.out.println(key);
                }
            }
            if (option.equals("4")) {
                Map<Customer, Integer> CustomerWithTickets;
                CustomerWithTickets = customerServiceImpl.showCustomersWithMostTickets(Customers, Tickets);
                for (Customer key : CustomerWithTickets.keySet()) {

                    System.out.println(key + " = " + CustomerWithTickets.get(key));

                }
            }
            if (option.equals("5")) {

                Map<Customer, Integer> CustomerWithoutTickets = customerServiceImpl.showCustomersWithoutTickets(Customers, Tickets);;
                for (Customer key : CustomerWithoutTickets.keySet()) {

                    System.out.println(key + " = " + CustomerWithoutTickets.get(key));

                }

            }
        }
    }
}
