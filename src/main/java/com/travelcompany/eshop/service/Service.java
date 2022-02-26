/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;

/**
 *
 * @author hnafp
 */
public class Service {

    public void runService() {

        Customer customer = CustomerService.CreateCustomer();
        System.out.println("You are logged in with new user: credentials"+customer);

    }
}
