package Pages;

import Framework.Elements.Button;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {
    public BrowserWindowsPage(){
        super(new Button(By.xpath("//button[@id ='tabButton']"),"Browser Windows page"),"Browser Windows page");
    }

    private Button buttonElements = new Button(By.xpath("//div[@class ='accordion']/div[1]"),"button Elements");
    private Button buttonLinks = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-5']"),"button Links");
    private Button buttonNewTab = new Button(By.id("tabButton"),"button New Tab");

    public void waitUntilButtonLinksIsVisible(){
        buttonLinks.waitUntilElementIsAppear();
    }

    public void clickButtonElements(){
        buttonElements.click();
    }

    public void clickButtonLinks(){
        buttonLinks.click();
    }

    public void clickButtonNewTab(){
        buttonNewTab.click();
    }
}
