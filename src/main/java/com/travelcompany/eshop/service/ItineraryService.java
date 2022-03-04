/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repo.ItineraryRepo;
import java.util.List;

/**
 *
 * @author hnafp
 */
public interface ItineraryService {

    List<Itinerary> showAllItinerariesPerDestDep(String Departure, String Destination);

    ItineraryRepo getiItineraryRepo();
}
