package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;

public class HelperBase {


    AppiumDriver driver;


    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }
}
