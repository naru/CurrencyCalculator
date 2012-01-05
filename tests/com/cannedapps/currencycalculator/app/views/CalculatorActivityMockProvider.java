package com.cannedapps.currencycalculator.app.views;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/* bound as singleton so tests will get the same provider as the production code */
@Singleton
public class CalculatorActivityMockProvider implements Provider<CalculatorActivityMock> {

  CalculatorActivityMock activity = new CalculatorActivityMock();
  
  @Override
  public CalculatorActivityMock get() {
    return activity;
  }

}
