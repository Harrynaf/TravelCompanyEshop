/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.repo.CustomerRepo;
import com.travelcompany.eshop.repo.CustomerRepoImpl;
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

    @Override
    public Customer CreateCustomer() {
        CustomerRepo customerRepoImpl = new CustomerRepoImpl();
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
        if (!customerEmail.endsWith("@travelcompany.com")) {
            throw new IllegalArgumentException("Incorrect email, must end with @travelcompany.com");
        }
        customerAddress = myObj.nextLine();  // Read user input
        customerNationality = myObj.nextLine();  // Read user input
        customerCategory = myObj.nextLine();  // Read user input
        if (customerCategory.equals(BUSINESS)) {
            customer = customerRepoImpl.CreateBusinessCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            return customer;
        } else if (customerCategory.equals(INDIVIDUAL)) {
            customer = customerRepoImpl.CreateIndividualCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            return customer;
        } else {
        }
        return null;
    }

    @Override
    public Map<Customer, Integer> showCustomersWithMostTickets(List<Customer> Customers, List<Ticket> Tickets) {
        Map<Customer, Integer> CustomerWithTickets = new HashMap<>();
        Map<Customer, Integer> toRemove = new HashMap<>();
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
    public Map<Customer, Integer> showCustomersWithoutTickets(List<Customer> Customers, List<Ticket> Tickets) {
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

}
