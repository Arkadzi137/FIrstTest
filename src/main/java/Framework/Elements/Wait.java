package Framework.Elements;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Util.UtilsMethods;
import Framework.Util.ReadJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    final private static int explicitWait = UtilsMethods.parseString(ReadJson.getConfigData("explicit_wait").toString());
    public static void waitUntilWebElementIsVisible(WebElement e) {
        new WebDriverWait(BrowserUtil.getDriver(), Duration.ofSeconds(explicitWait)).until(ExpectedConditions.visibilityOf(e));
    }

    public static void waitUntilWebElementIsAppear(By e) {
        new WebDriverWait(BrowserUtil.getDriver(), Duration.ofSeconds(explicitWait)).until(ExpectedConditions.presenceOfElementLocated(e));
    }

    public static void waitUntilWebElementToBeClickable(WebElement e) {
        new WebDriverWait(BrowserUtil.getDriver(), Duration.ofSeconds(explicitWait)).until(ExpectedConditions.elementToBeClickable(e));
    }

}
