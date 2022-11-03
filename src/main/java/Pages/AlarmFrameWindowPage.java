package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;

import java.text.MessageFormat;

public class AlarmFrameWindowPage extends BaseForm {
    public AlarmFrameWindowPage(){
        super(new Label(By.xpath("//div[@class ='home-content']"),"Alarm Frame Window page"),"Alarm Frame Window page");
    }
    String numberOfButton = "//div[contains(@class, 'show')]//li[@id='item-%d']";

    private Button buttonAlerts = new Button(By.xpath(String.format(numberOfButton,1)),"button Alerts");
    private Button buttonBrowserWindows = new Button(By.xpath(String.format(numberOfButton,0)),"button Browser Windows");
    private Button buttonNestedFrames = new Button(By.xpath(String.format(numberOfButton,3)),"button Nested NestedFramesPage");

    public void clickButtonAlerts(){
        buttonAlerts.click();
    }

    public void clickButtonBrowserWindows(){
        buttonBrowserWindows.click();
    }

    public void clickButtonNestedFrames(){
        buttonNestedFrames.click();
    }

}
