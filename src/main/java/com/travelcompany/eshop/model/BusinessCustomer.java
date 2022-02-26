/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;


/**
 *
 * @author hnafp
 */

public class BusinessCustomer extends Customer {

    public BusinessCustomer(String code, String name, String surname,String email, String address, String nationality) {
        super(code,name,surname,email,address,nationality);
    }

    @Override
    public String toString() {
        return "BusinessCustomer{"+ super.toString() + ", category=Business}";
    }
    
}
