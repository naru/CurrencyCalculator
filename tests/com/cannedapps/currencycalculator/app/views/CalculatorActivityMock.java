package com.cannedapps.currencycalculator.app.views;

import android.widget.ArrayAdapter;

public class CalculatorActivityMock extends CalculatorActivity {

  public String mToValue;
  public ArrayAdapter<String> mFromAdapter, mToAdapter;
  
  @Override
  public void setToValue(String value) {
    mToValue = value;
  }

  @Override
  public void setFromAdapter(ArrayAdapter<String> fromAdapter) {
    mFromAdapter = fromAdapter;
  }

  @Override
  public void setToAdapter(ArrayAdapter<String> toAdapter) {
    mToAdapter = toAdapter;
  }

}
