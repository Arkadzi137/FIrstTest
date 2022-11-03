package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import Framework.Util.UtilsMethods;
import Framework.Util.ReadJson;
import org.openqa.selenium.By;

public class ProgressBarPage extends BaseForm{
    public ProgressBarPage() {
        super(new Button(By.xpath("//button[contains(@id, 'startStopButton')]"), "button Start-Stop"), "Progress Bar page");
    }

    private Button buttonStartStop = new Button(By.xpath("//button[contains(@id, 'startStopButton')]"), "button Start-Stop");
    private Label precentProgressBar = new Label(By.xpath("//div[@id ='progressBar']//div[@role ='progressbar']"),"precent Progress Bar");
    private long engineerAge = Long.valueOf( (long)ReadJson.getTestingData("age_engineer"));

    public void clickButtonStartStop(){
        buttonStartStop.click();
    }

    public void waitUntilButtonStartToBeClickable(){
        buttonStartStop.waitUntilElementToBeClickable();
    }

    public void waitUntilPercentMatchAge(){
        while (!precentProgressBar.getText().equals(engineerAge+"%")){
            int realPercent;
            if (precentProgressBar.getText().equals(""))realPercent = 0;
            else {realPercent = UtilsMethods.parseString(precentProgressBar.getText());}
            if(realPercent >= engineerAge-2) {
                buttonStartStop.click();
                return;
            }
            if(precentProgressBar.getText().equals(100+"%")) break;
        }
    }

    public boolean precentProgressBarMatchAge(){
        int realPercent = UtilsMethods.parseString(precentProgressBar.getText());
        if (realPercent >= engineerAge-2&&realPercent <= engineerAge+2) return true;
        return false;
    }
}
