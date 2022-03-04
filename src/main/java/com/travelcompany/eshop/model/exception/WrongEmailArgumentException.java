/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model.exception;

/**
 *
 * @author hnafp
 */
public class WrongEmailArgumentException extends IllegalArgumentException {

    public WrongEmailArgumentException() {
        System.out.println("WrongEmailArgumentException: Email must end with @travelcompany.com");
    }
    
}
