package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase {

        @Test
        public void appLaunchTest() {
            System.out.println("App opened!");
            Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());
        }

    @Test
    public void checkLicensesTest() {

        //tap on Hamburger
        app.getMainScreen().tapOnHamburger();
        //tap on Licenses
        app.getMainScreen().pause(1000);
        app.getMainScreen().tapOnLicenses();
        // assert Licenses are opened
        Assert.assertTrue(app.getMainScreen().isTitleLicensesPresent());

        }
    }



