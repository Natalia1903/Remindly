package com.telran.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemindersHelper extends HelperBase {

    public RemindersHelper(AppiumDriver driver) {

        super(driver);
    }

    public void tapOnAddReminder() {

        tap(By.id("add_reminder"));
    }

    public void fillReminderTitle(String title) {
        type(By.id("reminder_title"),title);
        hideKeyboard();
    }


    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDataField() {

        tap(By.id("date"));
    }

    public void selectMonth(String time) {
        pause(1000);
        if (time.equals("past")) {
            swipeDown();
        } else if (time.equals("future")) {
            swipeUp();
        }
    }

    public void selectDay(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnOK() {

        tap(By.id("ok"));
    }

    public void selectCertainMonth(String type, int number, String month) {
        pause(1000);
        if (!selectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (type.equals("future")) {
                    swipeUp();
                } else if (type.equals("past")) {
                    swipeDown();
                }
            }
        }
    }

    //id date_picker_month
    private String selectedMonth() {
        return driver.findElement(By.id("date_picker_month")).getText();
    }


   // public boolean isTitleOfReminderPresent() {
   //     return isElementPresent(By.id("recycle_title"));
   // }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void selectYear(String type1, String year) {
        pause(2000);
        if (!getSelectYear().equals(year)) {
            if (type1.equals("future")) {
                swipeUpUntilNeededYear(year);
            } else if (type1.equals("past")) {
                swipeDownUntilNeededYear(year);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeDownUntilNeededYear(String year) {
        while (!getSelectYear().equals(year)) {
            moveDown(By.className("android.widget.ListView"));
            getSelectYear();
        }
    }


    private void swipeUpUntilNeededYear(String year) {
        while (!getSelectYear().equals(year)) {
            moveUp(By.className("android.widget.ListView"));
            getSelectYear();

        }
    }

    private String getSelectYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }


    public void tapOnTime() {
        tap(By.id("time"));
    }


    public void selectTimeOfDay(String td) {
        if (td.equals("am")) {
            tapWithCoordinates(284,1351);
        } else if (td.equals("pm")) {
          tapWithCoordinates(793,1323);
        }
    }



    public void tapOnRepeatSwitch() {
        tap(By.id("repeat_switch"));
    }

    public void enterRepeatNumber(String s) {
        tap(By.id("RepeatNo"));
        type(By.xpath("//*[@class='android.widget.EditText']"), s);
        hideKeyboard();
        pause(2000);
        tap(By.xpath("//*[@text='OK']"));
    }
    public void SelectRepeatTime(String month){
        tap(By.id("RepeatType"));
        tap(By.xpath("//*[@text='Month']"));
    }

    public boolean isTitleOfReminderPresent() {
        return isElementPresent(By.id("recycle_title"));
    }

    public void selectRepeatTime(String month) {
        tap(By.id("RepeatType"));
        tap(By.xpath("//*[@text='Month']"));
    }
}