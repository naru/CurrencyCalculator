package com.cannedapps.currencycalculator.app;

import roboguice.config.AbstractAndroidModule;
import android.app.Activity;

import com.cannedapps.currencycalculator.app.views.CalculatorActivityMockProvider;

public class TestModule extends AbstractAndroidModule {
  @Override
  protected void configure() {
    bind(Activity.class).toProvider(CalculatorActivityMockProvider.class);
  }
}