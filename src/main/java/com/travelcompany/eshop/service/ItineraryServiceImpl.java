/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repo.ItineraryRepo;
import com.travelcompany.eshop.repo.ItineraryRepoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hnafp
 */
public class ItineraryServiceImpl implements ItineraryService {

    ItineraryRepo itineraryRepoImpl = new ItineraryRepoImpl();
    List<Itinerary> Itineraries = itineraryRepoImpl.GetItineraries();

    @Override
    public List<Itinerary> showAllItinerariesPerDestDep(String Departure, String Destination) {
        List<Itinerary> ChosenItineraries = new ArrayList<>();
        for (int count = 0; count < Itineraries.size(); count++) {
            if (Itineraries.get(count) != null) {
                if (Itineraries.get(count).getDestinationCode().equalValue(Destination) && Itineraries.get(count).getDepartureCode().equalValue(Departure)) {
                    ChosenItineraries.add(Itineraries.get(count));

                }
            }

        }
        return ChosenItineraries;
    }
    @Override
     public ItineraryRepo getiItineraryRepo() {
        return itineraryRepoImpl;
    }
}
