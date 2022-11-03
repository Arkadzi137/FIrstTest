package Framework;

import Framework.BrowserFactory.BrowserUtil;
import org.openqa.selenium.NoAlertPresentException;

public class Alert {

    public static void dismiss(){
        try {
            Log.info("Alert click Cancel");
            BrowserUtil.getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            throwException(e);
        }
    }

    public static void accept(){
        try {
            Log.info("Alert click Ok");
            BrowserUtil.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            throwException(e);
        }
    }

    public static void sendKeys(String messege){
        try {
            Log.info("Send text "+messege+"\" to Alert");
            BrowserUtil.getDriver().switchTo().alert().sendKeys(messege);
        } catch (Exception e) {
            throwException(e);
        }
    }

    public static String getText(){
        try {
            return BrowserUtil.getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            Log.info("Alert is not visible");
            throw new RuntimeException(e);
        }
    }

    public static boolean isAlertPresent()
    {
        try
        {
            BrowserUtil.getDriver().switchTo().alert();
            Log.info("Alert is visible");
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    private static void throwException(Exception e){
        Log.info("Alert is not visible");
        throw new RuntimeException(e);
    }
}
