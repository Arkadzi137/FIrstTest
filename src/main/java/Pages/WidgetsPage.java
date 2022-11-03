package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;

public class WidgetsPage extends BaseForm {
    public WidgetsPage() {
        super(new Label(By.xpath("//div[contains(@class, 'element-list') and contains(@class, 'show')]"),"widgets page"),"widgets page");
    }

    private Button buttonSlider = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"),"button Slider");
    private Button buttonDataPicker = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-2']"),"button Data Picker");

    public void clickButtonSlider(){
        buttonSlider.click();
    }

    public void clickButtonDataPicker(){
        buttonDataPicker.click();
    }
}
