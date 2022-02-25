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
    private String departureCode;
    private String destinationCode;
    private String airline;
    private BigDecimal basicPrice;
    private Date departureDate;
}
