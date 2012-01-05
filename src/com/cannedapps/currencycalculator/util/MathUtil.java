package com.cannedapps.currencycalculator.util;

import java.math.BigDecimal;

public class MathUtil {

  public static Double round(double d, int decimalPlace){
    // see the Javadoc about why we use a String in the constructor
    // http://java.sun.com/j2se/1.5.0/docs/api/java/math/BigDecimal.html#BigDecimal(double)
    BigDecimal bd = new BigDecimal(Double.toString(d));
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
    return bd.doubleValue();
  }
  
  
}
