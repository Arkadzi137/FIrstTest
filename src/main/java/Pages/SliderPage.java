package Pages;

import Framework.Elements.Button;
import Framework.Elements.Input;
import Framework.Elements.Label;
import Framework.Elements.Slider;
import Framework.Util.UtilsMethods;
import org.openqa.selenium.By;

public class SliderPage extends BaseForm {
    public SliderPage() {
        super(new Slider(By.xpath("//input[@class = 'range-slider range-slider--primary']"),"slider page"),"slider page");
    }
    private Slider slider = new Slider(By.xpath("//input[@class = 'range-slider range-slider--primary']"),"slider");
    private Label procentSlider = new Label(By.xpath("//input[@id = 'sliderValue']"),"procent of slider");
    private Button buttonProgressBar = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-4']"),"button Progress Bar");
    private Input sliderValue = new Input(By.xpath("//input[@id = 'sliderValue']"),"procent of slider");

    public int getValueAttribute(){
        return UtilsMethods.parseString(sliderValue.getAttribute("value"));
    }

    public void waitUntilSliderIsVisible(){
        procentSlider.waitUntilElementIsVisible();
    }

    public void clickButtonProgressBar(){
        buttonProgressBar.click();
    }

    public void moveSlider(int percent){
        slider.moveSliderHorizontally(percent);
    }
}
