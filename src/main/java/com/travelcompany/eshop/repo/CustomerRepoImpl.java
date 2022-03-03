/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.IndividualCustomer;

/**
 *
 * @author hnafp
 */
public class CustomerRepoImpl implements CustomerRepo {

    @Override
    public Customer CreateBusinessCustomer(String code, String name, String surname, String email, String address, String nationality) {

        Customer customer = new BusinessCustomer(code, name, surname, email, address, nationality);
        return customer;
    }

    @Override
    public Customer CreateIndividualCustomer(String code, String name, String surname, String email, String address, String nationality) {

        Customer customer = new IndividualCustomer(code, name, surname, email, address, nationality);
        return customer;
    }
}
