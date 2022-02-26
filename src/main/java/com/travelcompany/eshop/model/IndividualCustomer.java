/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;


/**
 *
 * @author hnafp
 */

public class IndividualCustomer extends Customer{

    public IndividualCustomer(String code, String name, String surname, String email, String address, String nationality) {
        super(code, name, surname, email, address, nationality);
    }
     @Override
    public String toString() {
        return "IndividualCustomer{"+ super.toString() + ", category=Individual}";
    }
    
    
}
