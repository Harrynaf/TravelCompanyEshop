/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.model.exception.CustomerNotFoundException;
import com.travelcompany.eshop.model.exception.ItineraryNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class ServiceConsoleUI {

    public static final String BLANK = "";

    public void runService() {
        //Repo and service
        ItineraryService itineraryServiceImpl = new ItineraryServiceImpl();
        TicketService ticketServiceImpl = new TicketServiceImpl(itineraryServiceImpl.getiItineraryRepo());
        CustomerService customerServiceImpl = new CustomerServiceImpl(ticketServiceImpl.getTicketRepo());
        //Get Repo's data
        List<Customer> Customers = customerServiceImpl.getCustomerRepo().GetCustomers();
        List<Ticket> Tickets = ticketServiceImpl.getTicketRepo().GetTickets();
        List<Itinerary> Itineraries = itineraryServiceImpl.getiItineraryRepo().GetItineraries();
        //Buy some sample tickets
        ticketServiceImpl.BuyTicket(Itineraries.get(0), Customers.get(0), "cash");
        ticketServiceImpl.BuyTicket(Itineraries.get(1), Customers.get(1), "cash");
        ticketServiceImpl.BuyTicket(Itineraries.get(2), Customers.get(2), "cash");

        //Main code
        System.out.println("Please enter customer code,name,surname,email,address,nationality and category(Business/Individual), in that order");
        Customer thisCustomer = null;
        try {
            thisCustomer = customerServiceImpl.CreateCustomer();
            System.out.println("Customer created");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Nevertheless continuing with null customer...");
        }
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
                System.out.println("Would you like to buy by cash or card");
                option = myObj.nextLine();
                try {
                    Ticket boughtTicket = ticketServiceImpl.BuyTicket(chosenItinerary, thisCustomer, option);
                    System.out.println("Ticket purchase successful " + boughtTicket);
                } catch (ItineraryNotFoundException | CustomerNotFoundException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                chosenItinerary = null;
            }
            if (option.equals("2")) {
                for (Ticket Tickett : Tickets) {
                    if (Tickett != null) {
                        System.out.println(Tickett);
                    }
                }
                System.out.println(ticketServiceImpl.showTicketsTotalCost());
                System.out.println(ticketServiceImpl.showTicketsTotalNumber());

            }
            if (option.equals("3")) {
                System.out.println("Enter correctly the itinerary departure and destinaiton codes");
                option = myObj.nextLine();
                option1 = myObj.nextLine();
                List<Itinerary> ChosenItineraries = itineraryServiceImpl.showAllItinerariesPerDestDep(option, option1);
                for (Itinerary key : ChosenItineraries) {
                    System.out.println(key);
                }
            }
            if (option.equals("4")) {
                Map<Customer, Integer> CustomerWithTickets;
                CustomerWithTickets = customerServiceImpl.showCustomersWithMostTickets();
                for (Customer key : CustomerWithTickets.keySet()) {

                    System.out.println(key + " = " + CustomerWithTickets.get(key));

                }
            }
            if (option.equals("5")) {

                Map<Customer, Integer> CustomerWithoutTickets = customerServiceImpl.showCustomersWithoutTickets();
                for (Customer key : CustomerWithoutTickets.keySet()) {

                    System.out.println(key + " = " + CustomerWithoutTickets.get(key));

                }

            }
        }
    }
}
