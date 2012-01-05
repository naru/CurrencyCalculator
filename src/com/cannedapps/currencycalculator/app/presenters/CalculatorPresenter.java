package com.cannedapps.currencycalculator.app.presenters;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.cannedapps.currencycalculator.app.models.Currency;
import com.cannedapps.currencycalculator.app.models.Currency.Currencies;
import com.cannedapps.currencycalculator.app.views.interfaces.ICalculatorActivity;
import com.cannedapps.currencycalculator.util.MathUtil;
import com.google.inject.Inject;

public class CalculatorPresenter {
  
  @Inject ICalculatorActivity view;
  @Inject Activity activity;
  
  public void loadCurrencies() {
    
    ArrayAdapter<String> fromSpinnerArrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, Currencies.getNames());
    ArrayAdapter<String> toSpinnerArrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, Currencies.getNames());

    view.setFromAdapter(fromSpinnerArrayAdapter);
    view.setToAdapter(toSpinnerArrayAdapter);
  }

  public void calculate(String currencyFrom, String currencyTo, String fromValue) {
    String toValue = "";
    
    try {
      toValue = MathUtil.round(Currency.calculate(currencyFrom, currencyTo, Float.parseFloat(fromValue)), 2).toString();
    } catch (NumberFormatException e) {
      // ignore
    }
    
    view.setToValue(toValue.toString());
  }

}
