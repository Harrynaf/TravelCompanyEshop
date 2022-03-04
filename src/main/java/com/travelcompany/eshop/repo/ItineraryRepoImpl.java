/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repo;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.ItineraryAirportCode;
import com.travelcompany.eshop.model.exception.ItineraryAirportCodeNotFoundException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hnafp
 */
public final class ItineraryRepoImpl implements ItineraryRepo {

    List<Itinerary> Itineraries = new ArrayList<>();

    @Override
    public Itinerary CreateItinerary(String code, ItineraryAirportCode departureCode, ItineraryAirportCode destinationCode, String airline, Date departureDate, BigDecimal basicPrice) throws ItineraryAirportCodeNotFoundException {
        if (departureCode == null) {//Mono an null alli periptosi den yparxi afou pernei typou ItineraryAirportCode
            throw new ItineraryAirportCodeNotFoundException();
        }
        Itinerary itinerary = new Itinerary(code, departureCode, destinationCode, airline, departureDate, basicPrice);
        Itineraries.add(itinerary);
        return itinerary;
    }

    public ItineraryRepoImpl() {
        PopulateItineraryRepo();
    }

    @Override
    public List<Itinerary> GetItineraries() {

        return Itineraries;
    }

    @Override
    public void PopulateItineraryRepo() {
        Instant instant = Instant.parse("2022-02-01T13:35:00.00Z");
        Instant instant1 = Instant.parse("2022-04-01T13:35:00.00Z");
        try {
            CreateItinerary("1", ItineraryAirportCode.ATH, ItineraryAirportCode.BER, "SkyLines", Date.from(instant), new BigDecimal("120"));
            CreateItinerary("2", ItineraryAirportCode.ATH, ItineraryAirportCode.PAR, "SkyLines", Date.from(instant1), new BigDecimal("140"));
            CreateItinerary("3", ItineraryAirportCode.AUS, ItineraryAirportCode.NYC, "SkyLines", Date.from(instant), new BigDecimal("180"));
            CreateItinerary("4", ItineraryAirportCode.NYC, ItineraryAirportCode.AUS, "SkyLines", Date.from(instant1), new BigDecimal("170"));
            CreateItinerary("5", ItineraryAirportCode.CHN, ItineraryAirportCode.JPN, "SkyLines", Date.from(instant), new BigDecimal("190"));
            CreateItinerary("6", ItineraryAirportCode.ATH, ItineraryAirportCode.NYC, "SkyLines", Date.from(instant1), new BigDecimal("195"));
        } catch (ItineraryAirportCodeNotFoundException e) {
            System.out.println("whatever I dont care exception caught");
        }
    }

}
