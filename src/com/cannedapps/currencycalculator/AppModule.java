package com.cannedapps.currencycalculator;

import com.cannedapps.currencycalculator.app.views.CalculatorActivity;
import com.cannedapps.currencycalculator.app.views.interfaces.ICalculatorActivity;
import com.google.inject.AbstractModule;


public class AppModule extends AbstractModule {

  public AppModule() {}
  
  @Override
  protected void configure() {
    bind(ICalculatorActivity.class).to(CalculatorActivity.class);
  }
  
}
