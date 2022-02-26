/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.IndividualCustomer;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public abstract class CustomerService {

    public static Customer CreateCustomer() {
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
        customerAddress = myObj.nextLine();  // Read user input
        customerNationality = myObj.nextLine();  // Read user input
        customerCategory = myObj.nextLine();  // Read user input
        if (customerCategory.equals("Business")) {
            customer = new BusinessCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            System.out.println("Customer created");
            return customer;
        } else if (customerCategory.equals("Individual")) {
            System.out.println("Customer created");
            customer = new IndividualCustomer(customerCode, customerName, customerSurname, customerEmail, customerAddress, customerNationality);
            return customer;
        } else {
            System.out.println("error creating customer(category wrong)");  // Output user input
        }
        return null;
    }
}
