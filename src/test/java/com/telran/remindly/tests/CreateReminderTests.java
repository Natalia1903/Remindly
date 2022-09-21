package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateReminderTests extends TestBase {



    @Test
    public void addReminderWithDefaultDataTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        //tap on add reminder
        app.getReminders().tapOnAddReminder();
        //fill reminder title
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Test");
        //save reminder
        app.getReminders().saveReminder();
        //assert to add new reminder
        app.getReminders().pause(2000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);
    }

    @Test
    public void addReminderWithDefaultDataAndTitleTextAssertTest() {
        //tap on add reminder
        app.getReminders().tapOnAddReminder();
        //fill reminder title
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Test");
        //save reminder
        app.getReminders().saveReminder();
        app.getReminders().pause(2000);
        //assert to add new reminder for title text
        Assert.assertTrue(app.getReminders().isTitleOfReminderPresent());

    }

    @Test
    public void addReminderWithRandomSwipeTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        //tap on add reminder
        app.getReminders().tapOnAddReminder();
        //fill reminder title
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Test");
        //tap on data field
        app.getReminders().tapOnDataField();
        //choose month
        app.getReminders().pause(500);
        app.getReminders().selectMonth("future");
        //select day
        app.getReminders().selectDay(19);
        //tap on OK
        app.getReminders().tapOnOK();
        //save reminder
        app.getReminders().saveReminder();
        //assert to add new reminder
        app.getReminders().pause(2000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
       Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);
    }
    @Test
    public void addReminderWitAllDataTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();

        //tap on add reminder
        app.getReminders().tapOnAddReminder();
        //fill reminder title
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Christmas");
        //tap on data field
        app.getReminders().tapOnDataField();
        //choose month
        app.getReminders().selectCertainMonth("future",4,"Dec");
        //select day
        app.getReminders().selectDay(23);
        //tap on yer
        app.getReminders().tapOnYear();
        //select Year
        app.getReminders().selectYear("past", "2020");
        //tap on OK
        app.getReminders().tapOnOK();
        //tap on time
        app.getReminders().tapOnTime();
        //select time of day
        app.getReminders().pause(500);
        app.getReminders().selectTimeOfDay("am");
        //select hours and minutes
        app.getReminders().tapWithCoordinates(269,924 );
        app.getReminders().tapWithCoordinates(550,1250);
        //tap on ok
        app.getReminders().tapOnOK();
        //switch off repeat
        app.getReminders().tapOnRepeatSwitch();

        // enter repeat number
        app.getReminders().enterRepeatNumber("3");
        // swipe up
        app.getReminders().swipeUp();
        //select repeat time
        app.getReminders().selectRepeatTime("Month");
        //save reminder
        app.getReminders().saveReminder();
        //assert to add new reminder
        app.getReminders().pause(2000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd+1);
    }

}
