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
public class Ticket {
    private String passengerCode;
    private String itineraryCode;
    private String paymentMethod;
    private String amountPaid;
}
