package com.cannedapps.currencycalculator.app;

import org.junit.runners.model.InitializationError;

import android.app.Application;

import com.cannedapps.currencycalculator.CurrencyCalculatorApplication;
import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner {
  public InjectedTestRunner(Class<?> testClass) throws InitializationError {
      super(testClass);
  }
  
  @Override protected Application createApplication() {
    CurrencyCalculatorApplication application = (CurrencyCalculatorApplication) super.createApplication();
    application.setAppModule(new TestModule());

    return application;
  }

  @Override public void prepareTest(Object test) {
      CurrencyCalculatorApplication application = (CurrencyCalculatorApplication) Robolectric.application;
      Injector injector = application.getInjector();
      //ContextScope scope = injector.getInstance(ContextScope.class);
      //scope.enter(application);      
      injector.injectMembers(test);
  }
}