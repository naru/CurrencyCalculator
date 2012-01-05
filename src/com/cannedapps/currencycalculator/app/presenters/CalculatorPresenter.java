package com.cannedapps.currencycalculator.app.presenters;

import android.widget.ArrayAdapter;

import com.cannedapps.currencycalculator.AbstractCannedappsPresenter;
import com.cannedapps.currencycalculator.app.models.Currency;
import com.cannedapps.currencycalculator.app.models.Currency.Currencies;
import com.cannedapps.currencycalculator.app.views.interfaces.ICalculatorActivity;
import com.cannedapps.currencycalculator.util.MathUtil;

public class CalculatorPresenter extends AbstractCannedappsPresenter<ICalculatorActivity> {
  
  public void loadCurrencies() {
    
    ArrayAdapter<String> fromSpinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Currencies.getNames());
    ArrayAdapter<String> toSpinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Currencies.getNames());

    getView().setFromAdapter(fromSpinnerArrayAdapter);
    getView().setToAdapter(toSpinnerArrayAdapter);
  }

  public void calculate(String currencyFrom, String currencyTo, String fromValue) {
    String toValue = "";
    
    try {
      toValue = MathUtil.round(Currency.calculate(currencyFrom, currencyTo, Float.parseFloat(fromValue)), 2).toString();
    } catch (NumberFormatException e) {
      // ignore
    }
    
    getView().setToValue(toValue.toString());
  }

}
