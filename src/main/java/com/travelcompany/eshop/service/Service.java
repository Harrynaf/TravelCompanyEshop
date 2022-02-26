/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.IndividualCustomer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import java.util.Scanner;

/**
 *
 * @author hnafp
 */
public class Service {
    // private String Customercode;
//    protected String name;
//    protected String surname;
//    protected String email;
//    protected String adress;
//    protected String nationality;
//    
//    private String passengerCode;
//    private String itineraryCode;
//    private String paymentMethod;
//    private String amountPaid;

   

   

    public void runService() {

        Customer customer = CustomerService.CreateCustomer();
        System.out.println("You are logged in with new user: credentials"+customer);

    }
}
