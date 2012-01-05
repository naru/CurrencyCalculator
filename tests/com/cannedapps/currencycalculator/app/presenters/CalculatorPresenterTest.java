package com.cannedapps.currencycalculator.app.presenters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cannedapps.currencycalculator.app.InjectedTestRunner;
import com.cannedapps.currencycalculator.app.models.Currency;
import com.cannedapps.currencycalculator.app.models.Currency.Currencies;
import com.cannedapps.currencycalculator.app.views.CalculatorActivityMockProvider;
import com.cannedapps.currencycalculator.util.MathUtil;
import com.google.inject.Inject;

@RunWith(InjectedTestRunner.class)
public class CalculatorPresenterTest {

  @Inject CalculatorPresenter presenter;
  @Inject CalculatorActivityMockProvider activityProvider;

  @Before
  public void setup() {
  }

  @Test
  public void shouldCalculateWithRightParams() throws Exception {

    String currencyFrom = Currencies.USD.name();
    String currencyTo = Currencies.EUR.name();
    Double expectedValue = MathUtil.round(Currency.calculate(currencyFrom, currencyTo, 10.0f), 2);

    presenter.calculate(currencyFrom, currencyTo, "10.00");

    assertThat(activityProvider.get().mToValue, equalTo(expectedValue.toString()));
  }

  @Test
  public void shouldRespondWithNoValue() throws Exception {

    String currencyFrom = Currencies.USD.name();
    String currencyTo = Currencies.EUR.name();
    String fromValue = "";

    presenter.calculate(currencyFrom, currencyTo, fromValue);

    assertThat(activityProvider.get().mToValue, equalTo(""));
  }

  @Test
  public void shouldRespondWithString() throws Exception {

    String currencyFrom = Currencies.USD.name();
    String currencyTo = Currencies.EUR.name();
    String fromValue = "asdgsadg";

    presenter.calculate(currencyFrom, currencyTo, fromValue);

    assertThat(activityProvider.get().mToValue, equalTo(""));
  }

  @Test
  public void shouldLoadCurrencies() throws Exception {
    presenter.loadCurrencies();

    assertThat(activityProvider.get().mFromAdapter.getCount(), equalTo(Currencies.values().length));
    assertThat(activityProvider.get().mToAdapter.getCount(), equalTo(Currencies.values().length));
  }

}
