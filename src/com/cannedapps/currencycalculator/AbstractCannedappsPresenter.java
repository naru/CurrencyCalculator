package com.cannedapps.currencycalculator;

import android.app.Activity;

import com.google.inject.Inject;

public abstract class AbstractCannedappsPresenter<T> {

  @Inject Activity activity;
  
  @SuppressWarnings("unchecked")
  public T getView() {
    return (T) activity;
  }
  
  public Activity getActivity() {
    return activity;
  }

}
