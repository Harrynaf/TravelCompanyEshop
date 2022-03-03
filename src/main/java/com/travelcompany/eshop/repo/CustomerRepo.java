/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Customer;

/**
 *
 * @author hnafp
 */
public interface CustomerRepo {
     Customer CreateBusinessCustomer(String code, String name, String surname, String email, String address, String nationality);
     Customer CreateIndividualCustomer(String code, String name, String surname, String email, String address, String nationality);
}
