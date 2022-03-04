/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model.exception;

/**
 *
 * @author hnafp
 */
public class CustomerNotFoundException extends NullPointerException {

    public CustomerNotFoundException() {
        System.out.println("CustomerNotFoundException: Customer not found");
    }
    
}
