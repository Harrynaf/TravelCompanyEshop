/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;

/**
 *
 * @author hnafp
 */
public abstract class Service implements CustomerService,TicketService {
//    protected String code;
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
    
    public Customer CreateCustomer(){
    
        System.out.println("Please enter customer code,name,surname,email,address,nationality and category, in that order");
        
        
        return null;
    
    }
    public void BuyTicket(Itinerary itinerary,Customer customer){
        
        //CreateTicket(getter itinerary.code, itinerary.airline, customer.name);
    }
    public Ticket CreateTicket(String code, String airline, String passenger){
    
    return null;}
}
