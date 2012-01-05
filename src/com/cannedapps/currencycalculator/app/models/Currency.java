package com.cannedapps.currencycalculator.app.models;

import java.util.ArrayList;

public class Currency {
  
  /*
   * Currencies relative to base currency EURO
   */
  public enum Currencies {
    EUR(1.00),
    SEK(8.886), 
    USD(1.321),
    YEN(99.93);
    
    private final Double mRate;
    
    public static ArrayList<String> getNames() {
      ArrayList<String> ret = new ArrayList<String>();

      for (int i = 0; i < values().length; i++) {
        ret.add(Currencies.values()[i].name());
      }
      
      return ret;
    }
    
    public static Double getRate(String name) {
      return Currencies.values()[Currencies.getNames().indexOf(name)].mRate;
    }
    
    private Currencies(Double rate) {
      mRate = rate;
    }
    
    public Double getRate() {
      return mRate;
    }
  }

  public static Double calculate(String currencyFrom, String currencyTo, float fromValue) {
    Double fromRate = Currencies.getRate(currencyFrom);
    Double toRate = Currencies.getRate(currencyTo);
    
    if (currencyFrom != Currencies.EUR.name()) {
      return (fromValue / fromRate) * toRate;
    } else {
      return fromValue * toRate;
    }
  }
  

}
