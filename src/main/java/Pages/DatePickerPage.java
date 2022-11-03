package Pages;

import Framework.Elements.Input;
import Framework.Elements.Label;
import Framework.Log;
import Framework.Util.KeyboardUtils;
import Framework.Util.ReadJson;
import Framework.Util.UtilsMethods;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatePickerPage extends BaseForm {
    public DatePickerPage() {
        super(new Label(By.xpath("//div[@id = 'datePickerMonthYear']"),"Date Picker page"),"Date Picker page");
    }

    private Input dateInput = new Input(By.xpath("//input[@id = 'datePickerMonthYearInput']"),"Date");
    private Input dateAndTimeInput = new Input(By.xpath("//input[@id = 'dateAndTimePickerInput']"),"Date and time");

    public long getMonthOfTestingData(){
        return (long) ReadJson.getTestingData("month");
    }

    public long getDayOfTestingData(){
        return (long) ReadJson.getTestingData("day");
    }

    public String getDateOnPage(){
        Log.info("Date on page is "+ dateInput.getAttribute("value"));
        return dateInput.getAttribute("value");
    }

    public String getDateAndTimeOnPage(){
        Log.info("Date and time on page is "+ dateInput.getAttribute("value"));
        return dateAndTimeInput.getAttribute("value");
    }

    public String getDateOnLeapYear(long month, long day){
        Calendar nextDateOfLeapYear = new GregorianCalendar();
        Calendar lastDateOfLeapYear = new GregorianCalendar();
        Calendar myCalendar = (Calendar) Calendar.getInstance().clone();
        nextDateOfLeapYear.set(UtilsMethods.getNextLeapYear(), (int)month, (int)day);
        lastDateOfLeapYear.set(UtilsMethods.getLastLeapYear(), (int)month, (int)day);
        int yaer = 0;
        if (Math.abs((myCalendar.getTime().getTime())-(nextDateOfLeapYear.getTime().getTime()))<
                Math.abs((myCalendar.getTime().getTime())-(lastDateOfLeapYear.getTime().getTime()))) {yaer = UtilsMethods.getNextLeapYear();}
        else {yaer = UtilsMethods.getLastLeapYear();}
        if(month>12)throw new RuntimeException("Incorrect month");
        myCalendar.set(yaer, (int) month, 1);
        int maxDays = myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(day>maxDays)throw new RuntimeException("Incorrect day");
        String stringDay =String.valueOf(day);
        if (day<10) stringDay ="0"+stringDay;
        String stringMonth =String.valueOf(month);
        if (month<10) stringMonth ="0"+stringMonth;
        Log.info("The nearest date in a leap year is "+stringMonth+"/"+stringDay+"/"+yaer);
        return stringMonth+"/"+stringDay+"/"+yaer;
    }

    public void clickDateInput(){
        dateInput.click();
    }

    public void sendDateOnLeapYearToDateInput(long month, long day) {
        KeyboardUtils.deleteAll();
        Log.info("Enter date "+getDateOnLeapYear(month, day));
        dateInput.sentKeys(getDateOnLeapYear(month, day));
        KeyboardUtils.clickEnter();
    }

}
