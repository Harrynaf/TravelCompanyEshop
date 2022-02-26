/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;
import lombok.Data;

/**
 *
 * @author hnafp
 */
@Data
public abstract class Customer {
    protected String code;
    protected String name;
    protected String surname;
    protected String email;
    protected String address;
    protected String nationality;

    public Customer(String code, String name, String surname, String email, String address, String nationality) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Customer{" + "code=" + code + ", name=" + name + ", surname=" + surname + ", email=" + email + ", address=" + address + ", nationality=" + nationality + '}';
    }
    
    
}
