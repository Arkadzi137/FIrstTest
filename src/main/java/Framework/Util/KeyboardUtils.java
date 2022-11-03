package Framework.Util;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class KeyboardUtils {
    private static Actions actions = new Actions(BrowserUtil.getDriver());

    public static void clickLeft(){
        Log.info("click ARROW_LEFT");
        actions.sendKeys(Keys.ARROW_LEFT).perform();
    }

    public static void clickRight(){
        Log.info("click ARROW_RIGHT");
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
    }

    public static void clickEnter(){
        Log.info("click ENTER");
        actions.sendKeys(Keys.ENTER).perform();
    }

    public static void deleteAll(){
        Log.info("click LEFT CNTR + A");
        actions.keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL)
                .perform();
        Log.info("click BACKSPACE");
        actions.sendKeys(Keys.BACK_SPACE).perform();
    }
}
