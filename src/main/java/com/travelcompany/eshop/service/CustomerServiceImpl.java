/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.model.exception.WrongEmailArgumentException;
import com.travelcompany.eshop.repo.CustomerRepo;
import com.travelcompany.eshop.repo.CustomerRepoImpl;
import com.travelcompany.eshop.repo.TicketRepo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class CustomerServiceImpl implements CustomerService {

    public static final String BUSINESS = "Business";
    public static final String INDIVIDUAL = "Individual";
    CustomerRepo customerRepoImpl = new CustomerRepoImpl();
    List<Customer> Customers = customerRepoImpl.GetCustomers();
    TicketRepo ticketRepoImpl;
    List<Ticket> Tickets;

    @Override
    public Customer CreateCustomer() throws IllegalArgumentException {
        String customerCode;
        String customerName;
        String customerSurname;
        String customerEmail;
        String customerAddress;
        String customerNationality;
        String customerCategory;
        Customer customer;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        customerCode = myObj.nextLine();  // Read user input
        customerName = myObj.nextLine();  // Read user input
        customerSurname = myObj.nextLine();  // Read user input
        customerEmail = myObj.nextLine();  // Read user input
        customerAddress = myObj.nextLine();  // Read user input
        customerNationality = myObj.nextLine();  // Read user input
        customerCategory = myObj.nextLine();  // Read user input
        if (customerCategory.equals(BUSINESS)) {
            try {
                customer = customerRepoImpl.CreateBusinessCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
                return customer;
            } catch (WrongEmailArgumentException e) {
                System.out.println("Nevertheless continuing with wrong email...");
                System.out.println("Don't believe the following line:");
            }
        } else if (customerCategory.equals(INDIVIDUAL)) {
            try {
                customer = customerRepoImpl.CreateIndividualCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
                return customer;
            } catch (WrongEmailArgumentException e) {
                System.out.println("Nevertheless continuing with wrong email...");
                System.out.println("Don't believe the following line:");
            }
        } else if (!customerCategory.equals(INDIVIDUAL) && !customerCategory.equals(BUSINESS)) {
            throw new IllegalArgumentException("IllegalArgumentException: Category false");
        }
        return null;
    }

    @Override
    public Map<Customer, Integer> showCustomersWithMostTickets() {
        Map<Customer, Integer> CustomerWithTickets = new HashMap<>();
        int totalNumber = 0;
        int maxNumberOfTickets = 0;
        for (int count = 0; count < Customers.size(); count++) {
            if (Customers.get(count) != null) {
                for (int count1 = 0; count1 < Tickets.size(); count1++) {

                    if (Tickets.get(count1) != null) {
                        if (Tickets.get(count1).getPassengerCode().equals(Customers.get(count).getCode())) {
                            totalNumber++;

                        }

                    }

                }

                CustomerWithTickets.put(Customers.get(count), totalNumber);
                if (totalNumber > maxNumberOfTickets) {
                    maxNumberOfTickets = totalNumber;
                }
                totalNumber = 0;
            }

        }

        for (Iterator<Map.Entry<Customer, Integer>> it = CustomerWithTickets.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Customer, Integer> entry = it.next();
            if (maxNumberOfTickets > entry.getValue()) {
                it.remove();
            }
        }

        return CustomerWithTickets;
    }

    @Override
    public Map<Customer, Integer> showCustomersWithoutTickets() {
        Map<Customer, Integer> CustomerWithTickets = new HashMap<>();
        int totalNumber = 0;
        for (int count = 0; count < Customers.size(); count++) {
            if (Customers.get(count) != null) {
                for (int count1 = 0; count1 < Tickets.size(); count1++) {

                    if (Tickets.get(count1) != null) {
                        if (Tickets.get(count1).getPassengerCode().equals(Customers.get(count).getCode())) {
                            totalNumber++;
                        }

                    }

                }
                if (totalNumber == 0) {
                    CustomerWithTickets.put(Customers.get(count), totalNumber);
                }
                totalNumber = 0;

            }

        }
        return CustomerWithTickets;
    }

    @Override
    public CustomerRepo getCustomerRepo() {
        return customerRepoImpl;
    }

    public CustomerServiceImpl(TicketRepo ticketRepoImpl) {
        this.ticketRepoImpl = ticketRepoImpl;
        Tickets = ticketRepoImpl.GetTickets();
    }
}
