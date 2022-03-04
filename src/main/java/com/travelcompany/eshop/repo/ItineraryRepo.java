/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.ItineraryAirportCode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hnafp
 */
public interface ItineraryRepo {

    Itinerary CreateItinerary(String code, ItineraryAirportCode departureCode, ItineraryAirportCode destinationCode, String airline, Date departureDate, BigDecimal basicPrice);
    List<Itinerary> GetItineraries();
    void PopulateItineraryRepo();
}
