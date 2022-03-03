/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Ticket;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hnafp
 */
public interface CustomerService {

    Customer CreateCustomer();

    Map<Customer, Integer> showCustomersWithMostTickets(List<Customer> Customers, List<Ticket> Tickets);

    Map<Customer, Integer> showCustomersWithoutTickets(List<Customer> Customers, List<Ticket> Tickets);

}
