/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;

import java.math.BigDecimal;
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
    private BigDecimal amountPaid;

    public Ticket(String passengerCode, String itineraryCode, String paymentMethod, BigDecimal amountPaid) {
        this.passengerCode = passengerCode;
        this.itineraryCode = itineraryCode;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Ticket{" + "passengerCode=" + passengerCode + ", itineraryCode=" + itineraryCode + ", paymentMethod=" + paymentMethod + ", amountPaid=" + amountPaid + '}';
    }
}
