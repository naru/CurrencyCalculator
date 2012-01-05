package com.cannedapps.currencycalculator.app.views.interfaces;

import android.widget.ArrayAdapter;

public interface ICalculatorActivity {
  
  public void setToValue(String value);
  
  public void setFromAdapter(ArrayAdapter<String> fromAdapter);
  
  public void setToAdapter(ArrayAdapter<String> toAdapter);
  
}
