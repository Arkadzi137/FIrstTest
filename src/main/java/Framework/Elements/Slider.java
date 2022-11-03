package Framework.Elements;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Log;
import Framework.Util.KeyboardUtils;
import Framework.Util.UtilsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Slider extends BaseElement {
    By locator;
    public Slider(By locator, String name){
        super(locator, name);
        this.locator = locator;
    }

    public void moveSliderHorizontally(int percent){
        WebElement slider = BrowserUtil.getDriver().findElement(locator);
        Log.info("move slider to "+ percent + "%");
        slider.click();
        int sliderValue = UtilsMethods.parseString(slider.getAttribute("value"));
        if (percent <= sliderValue) {
            while (percent != sliderValue) {
                KeyboardUtils.clickLeft();
                sliderValue = UtilsMethods.parseString(slider.getAttribute("value"));
                if (0==sliderValue||100==sliderValue) {Log.error("Slider don't stop moving");
                break;}
            }
        } else {
            while (percent != sliderValue) {
                KeyboardUtils.clickRight();;
                sliderValue = UtilsMethods.parseString(slider.getAttribute("value"));
                if (0==sliderValue||100==sliderValue) {Log.error("Slider don't stop moving");
                break;}
            }
        }
    }
}
