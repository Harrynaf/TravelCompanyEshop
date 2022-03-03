/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.ItineraryCityCodes;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author hnafp
 */
public class ItineraryRepoImpl implements ItineraryRepo {

    @Override
    public Itinerary CreateItinerary(String code, ItineraryCityCodes departureCode, ItineraryCityCodes destinationCode, String airline, Date departureDate, BigDecimal basicPrice) {
        Itinerary itinerary = new Itinerary(code, departureCode, destinationCode, airline, departureDate, basicPrice);
        return itinerary;
    }
}
