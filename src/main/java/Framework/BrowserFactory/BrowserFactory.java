package Framework.BrowserFactory;

import Framework.Log;
import Framework.Util.ReadJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory {
    private BrowserFactory(){}
    protected static WebDriver driver;

    private static String browser = ReadJson.getConfigData("browser").toString().toLowerCase();

    protected static void setDriver() {
        switch (browser) {
            case ("chrome"):
                driver = new ChromeDriver(WebDriverConfig.configChrome());
                break;
            case ("firefox"):
                driver = new FirefoxDriver(WebDriverConfig.configFirefox());
                break;
            case ("opera"):
                driver = new OperaDriver(WebDriverConfig.configOpera());
                break;
            case ("edge"):
                driver = new EdgeDriver(WebDriverConfig.configEdge());
                break;
            default: driver = null;
                Log.error("The driver is incorrectly defined in the configuration");
            throw new RuntimeException("Incorrect BrowserName");
        }
    }





}
