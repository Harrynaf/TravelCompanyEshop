/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.BusinessCustomer;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.IndividualCustomer;
import com.travelcompany.eshop.model.exception.WrongEmailArgumentException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hnafp
 */
public final class CustomerRepoImpl implements CustomerRepo {

    List<Customer> Customers = new ArrayList<>();

    @Override
    public Customer CreateBusinessCustomer(String code, String name, String surname, String email, String address, String nationality) throws WrongEmailArgumentException {
        if (!email.endsWith("@travelcompany.com")) {
            throw new WrongEmailArgumentException();
        }
        Customer customer = new BusinessCustomer(code, name, surname, email, address, nationality);
        Customers.add(customer);
        return customer;
    }

    public CustomerRepoImpl() {
        PopulateCustomerRepo();
    }

    @Override
    public Customer CreateIndividualCustomer(String code, String name, String surname, String email, String address, String nationality) {
        if (!email.endsWith("@travelcompany.com")) {
            throw new WrongEmailArgumentException();
        }
        Customer customer = new IndividualCustomer(code, name, surname, email, address, nationality);
        Customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> GetCustomers() {

        return Customers;
    }

    @Override
    public void PopulateCustomerRepo() {
        CreateBusinessCustomer("A1", "Harry", "Naf", "asdas@@travelcompany.com", "asda", "Greek");
        CreateBusinessCustomer("A2", "1", "1", "1asdas@@travelcompany.com", "1asda", "Greek");
        CreateIndividualCustomer("B3", "2", "2", "21asdas@@travelcompany.com", "21asda", "Chinese");
        CreateIndividualCustomer("G3", "2", "2", "21asdas@@travelcompany.com", "21asda", "Japanese");
    }
}
