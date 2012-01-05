package com.cannedapps.currencycalculator.app.views;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cannedapps.currencycalculator.R;
import com.cannedapps.currencycalculator.app.presenters.CalculatorPresenter;
import com.cannedapps.currencycalculator.app.views.interfaces.ICalculatorActivity;
import com.google.inject.Inject;

public class CalculatorActivity extends RoboActivity implements ICalculatorActivity {
  
  @InjectView(R.id.edittext) EditText mEditText;
  @InjectView(R.id.spinner1) Spinner mFromSpinner;
  @InjectView(R.id.spinner2) Spinner mToSpinner;
  @InjectView(R.id.result) TextView mResultView;
  
  @Inject CalculatorPresenter mPresenter;
  
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mPresenter.loadCurrencies();

        mFromSpinner.setOnItemSelectedListener(currencySpinnerListener);
    }
    
    @Override
    public void setToValue(String value) {
      mResultView.setText(value);
    }


    @Override
    public void setFromAdapter(ArrayAdapter<String> fromAdapter) {
      mFromSpinner.setAdapter(fromAdapter);
    }


    @Override
    public void setToAdapter(ArrayAdapter<String> toAdapter) {
      mToSpinner.setAdapter(toAdapter);
    }

    OnItemSelectedListener currencySpinnerListener = new OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        String fromCurrency = (String) mFromSpinner.getSelectedItem();
        String toCurrency = (String) mToSpinner.getSelectedItem();
        
        mPresenter.calculate(fromCurrency, toCurrency, mEditText.getText().toString());
      }

      @Override
      public void onNothingSelected(AdapterView<?> arg0) {
      }
    };


}