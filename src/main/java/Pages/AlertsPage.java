package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {
    public AlertsPage() {
        super(new Label(By.xpath("//div[@id ='javascriptAlertsWrapper']"),"Alert form"),"alerts form");
    }

    private Button buttonToSeeAlert  = new Button(By.id("alertButton"),"button to see alert");
    private Button buttonConfirmBoxAlert  = new Button(By.id("confirmButton"),"button confirm box alert");
    private Button buttonPromtAlert  = new Button(By.id("promtButton"),"button promt alert");
    private Label textNextToBtnConfirmBoxAlert = new Label(By.id("confirmResult"),"text next to button confirm box alert");
    private Label textNextToBtnPromtAlert = new Label(By.id("promptResult"),"text next to button confirm box alert");

    public void clickButtonToSeeAlert(){
        buttonToSeeAlert.click();
    }

    public void clickButtonConfirmBoxAlert(){
        buttonConfirmBoxAlert.click();
    }

    public void clickButtonPromtAlert(){
        buttonPromtAlert.click();
    }

    public String getTextNextToBtnConfirmBoxAlert() {
        return textNextToBtnConfirmBoxAlert.getText();
    }

    public String getTextNextToBtnPromtAlert() {
        return textNextToBtnPromtAlert.getText();
    }
}
