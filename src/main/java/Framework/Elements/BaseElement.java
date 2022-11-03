package Framework.Elements;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class BaseElement {
    protected By locator;
    protected String name;

    public BaseElement(By locator,String name){
        this.locator = locator;
        this.name = name;
    }
    protected List<WebElement> findElements(){
        return BrowserUtil.getDriver().findElements(locator);
    }

    public String getTextFromElementByIndex(int index){
        Log.info("get Text fron "+name);
        return findElements().get(index).getText();
    }

    public int getElementsCount(){
        return findElements().size();
    }
    public void click(){
        Log.info("click "+name);
        BrowserUtil.getDriver().findElement(locator).click();
    }

    public String getText(){
        Log.info("get Text fron "+name);
        return BrowserUtil.getDriver().findElement(locator).getText();
    }

    public boolean isVisible(){
        Log.info("Check that " + name + " is visible");
        List <WebElement> list = BrowserUtil.getDriver().findElements(locator);
        if (list == null) {return false;}
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDisplayed()) return true;
        }
        return false;
    }

    private WebElement getWebElement(){
        return BrowserUtil.getDriver().findElement(locator);
    }
    public void waitUntilElementIsVisible() {
        Wait.waitUntilWebElementIsVisible(this.getWebElement());
    }
    public void waitUntilElementIsAppear() {
        Wait.waitUntilWebElementIsAppear(locator);
    }
    public void waitUntilElementToBeClickable() {
        Wait.waitUntilWebElementToBeClickable(this.getWebElement());
    }
    public String getAttribute(String attribute){
        Log.info("get value attribute " + attribute);
        return BrowserUtil.getDriver().findElement(locator).getAttribute(attribute);
    }

}
