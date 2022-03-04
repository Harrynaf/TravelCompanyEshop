/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.model;

/**
 *
 * @author hnafp
 */
public enum ItineraryAirportCode {
    ATH("ATH"),BER("BER"),AUS("AUS"),NYC("NYC"),JPN("JPN"),CHN("CHN"),PAR("PAR");
    
        private String value;

    ItineraryAirportCode(String value){
        this.value = value;
    }

    public boolean equalValue(String passedValue){
        return this.value.equals(passedValue);
    }

    
}
