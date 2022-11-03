package Framework.BrowserFactory;

import Framework.Log;
import Framework.Util.ReadJson;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserUtil {

    public static WebDriver getDriver() {
        if (BrowserFactory.driver == null) {
            BrowserFactory.setDriver();
            setBrowserWindowConfiguration();
        }
        return BrowserFactory.driver;
    }

    public static void killDriver() {
        BrowserUtil.getDriver().quit();
        BrowserFactory.driver = null;
    }

    private static void setBrowserWindowConfiguration(){
        Log.info("Maximize window of browser");
        getDriver().manage().window().maximize();
    }


    public static void openPage(){
        Log.info("open page: "+ ReadJson.getConfigData("base_url").toString().toLowerCase());
        getDriver().get(ReadJson.getConfigData("base_url").toString().toLowerCase());
    }

    public static void scroll(int i){
        JavascriptExecutor jse = (JavascriptExecutor)(getDriver());
        Log.info("scroll");
        jse.executeScript("window.scrollBy(0,"+i+")", "");
    }

    public static void switchToIframe(String nameOrId){
        getDriver().switchTo().frame(nameOrId);
    }

    public static String getWindowHandle(){
       return getDriver().getWindowHandle();
    }

    public static void switchToIframe(int index){
        getDriver().switchTo().frame(index);
    }

    public static void switchToParentFrame(){
        getDriver().switchTo().parentFrame();
    }

    public static void switchToBasePage(){
        getDriver().switchTo().defaultContent();
    }

    public static void switchToTab(String handle){
        getDriver().switchTo().window(handle);
    }

    public static void switchToOtherTab(){
        String mainWindowHandle = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);
                break;
            }
        }
    }

    public static boolean newTabIsOpen(){
        String mainWindowHandle = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                return true;
            }
        }
        return false;
    }

    public static void newTabClose() {
        String mainWindowHandle = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);
                getDriver().close();
                getDriver().switchTo().window(mainWindowHandle);
                break;
            }
        }
    }
}
