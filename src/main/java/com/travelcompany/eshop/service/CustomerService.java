/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.model.IndividualCustomer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public abstract class CustomerService {
public static final String BUSINESS = "Business";
public static final String INDIVIDUAL = "Individual";
    protected static Customer CreateCustomer() {
        String customerCode;
        String customerName;
        String customerSurname;
        String customerEmail;
        String customerAddress;
        String customerNationality;
        String customerCategory;
        Customer customer;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter customer code,name,surname,email,address,nationality and category, in that order");
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
            customer = new BusinessCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            System.out.println("Customer created");
            return customer;
        } else if (customerCategory.equals(INDIVIDUAL)) {
            System.out.println("Customer created");
            customer = new IndividualCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            return customer;
        } else {
            System.out.println("error creating customer(category wrong)");  // Output user input
        }
        return null;
    }

    protected static void showCustomersWithMostTickets(Customer[] Customers, Ticket[] Tickets) {
        Map<Customer, Integer> CustomerWithTickets = new HashMap<>();
        int totalNumber = 0;
        int maxNumberOfTickets = 0;
        for (int count = 0; count < Customers.length; count++) {
            if (Customers[count] != null) {
                for (int count1 = 0; count1 < Tickets.length; count1++) {

                    if (Tickets[count1] != null) {
                        if (Tickets[count1].getPassengerCode().equals(Customers[count].getCode())) {
                            totalNumber++;

                        }

                    }

                }

                CustomerWithTickets.put(Customers[count], totalNumber);
                if (totalNumber > maxNumberOfTickets) {
                    maxNumberOfTickets = totalNumber;
                }
                totalNumber = 0;
            }

        }

        for (Customer key : CustomerWithTickets.keySet()) {
            if (maxNumberOfTickets == CustomerWithTickets.get(key)) {
                System.out.println(key + " = " + CustomerWithTickets.get(key));
            }

        }

    }

    protected static void showCustomersWithoutTickets(Customer[] Customers, Ticket[] Tickets) {
        Map<Customer, Integer> CustomerWithTickets = new HashMap<>();
        int totalNumber = 0;
        for (int count = 0; count < Customers.length; count++) {
            if (Customers[count] != null) {
                for (int count1 = 0; count1 < Tickets.length; count1++) {

                    if (Tickets[count1] != null) {
                        if (Tickets[count1].getPassengerCode().equals(Customers[count].getCode())) {
                            totalNumber++;
                        }

                    }

                }
                if (totalNumber == 0) {
                    CustomerWithTickets.put(Customers[count], totalNumber);
                }
                totalNumber = 0;

            }

        }
        for (Customer key : CustomerWithTickets.keySet()) {
            System.out.println(key + " = " + CustomerWithTickets.get(key));
        }
    }

}
