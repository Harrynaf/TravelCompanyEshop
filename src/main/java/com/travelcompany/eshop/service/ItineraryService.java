/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.ItineraryCityCodes;
import com.travelcompany.eshop.model.Itinerary;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author hnafp
 */
public abstract class ItineraryService {

    protected static Itinerary CreateItinerary(String code, ItineraryCityCodes departureCode, ItineraryCityCodes destinationCode, String airline, Date departureDate, BigDecimal basicPrice) {
        Itinerary itinerary = new Itinerary(code, departureCode, destinationCode, airline, departureDate, basicPrice);
        return itinerary;
    }

    protected static void showAllItineraries(Itinerary[] Itineraries) {
        for (int count = 0; count < Itineraries.length; count++) {
            if (Itineraries[count] != null) {
                System.out.println(Itineraries[count]);
            }
        }
    }

    protected static void showAllItinerariesPerDestDep(Itinerary[] Itineraries, String Departure, String Destination) {
        Itinerary chosenItinerary;
        for (int count = 0; count < Itineraries.length; count++) {
            if (Itineraries[count] != null) {
                if (Itineraries[count].getDestinationCode().equalValue(Destination) && Itineraries[count].getDepartureCode().equalValue(Departure)) {
                    chosenItinerary = Itineraries[count];
                    System.out.println(chosenItinerary);

                }
            }

        }
    }
}