package com.cannedapps.currencycalculator;

import java.util.List;

import com.google.inject.Module;

import roboguice.application.RoboApplication;

public class CurrencyCalculatorApplication extends RoboApplication {

  private Module appModule = new AppModule();
  
  @Override
  protected void addApplicationModules(List<Module> modules) {
    modules.add(appModule);
  }
  
  public void setAppModule(Module appModule) {
    this.appModule = appModule;
  }
  
}
