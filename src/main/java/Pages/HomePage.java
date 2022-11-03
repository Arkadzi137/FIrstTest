package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {
    public HomePage(){
        super(new Label(By.xpath("//div[@class ='home-content']"),"home page"),"home page");
    }

    private Button buttonAlertsFrameWindows = new Button(By.xpath("//h5[contains(text(),'lerts')]//parent::div//parent::div//parent::div"),"button Alerts, Frame & Windows");
    private Button buttonElements = new Button(By.xpath("//h5[contains(text(),'lement')]//parent::div//parent::div//parent::div"),"button Elements");
    private Button buttonWidgets = new Button(By.xpath("//h5[contains(text(),'idgets')]//parent::div//parent::div//parent::div"),"button Widgets");

    public void clickButtonAlertsFrameWindows(){
        buttonAlertsFrameWindows.click();
    }

    public void clickButtonElements(){
        buttonElements.click();
    }

    public void clickButtonWidgets(){
        buttonWidgets.click();
    }

}
