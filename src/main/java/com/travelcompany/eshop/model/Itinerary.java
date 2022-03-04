/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author hnafp
 */
@Data
public class Itinerary {

    private String code;
    private ItineraryAirportCode departureCode;
    private ItineraryAirportCode destinationCode;
    private String airline;
    private Date departureDate;
    private BigDecimal basicPrice;

    public Itinerary(String code, ItineraryAirportCode departureCode, ItineraryAirportCode destinationCode, String airline, Date departureDate, BigDecimal basicPrice) {
        this.code = code;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
        this.airline = airline;
        this.departureDate = departureDate;
        this.basicPrice = basicPrice;
    }

}
