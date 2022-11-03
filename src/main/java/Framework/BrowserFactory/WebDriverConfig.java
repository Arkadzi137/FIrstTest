package Framework.BrowserFactory;

import Framework.Util.ReadJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.*;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

abstract public class WebDriverConfig {
    private final  static String location = ReadJson.getConfigData("locale").toString().toLowerCase();
    private final  static String language = ReadJson.getConfigData("language").toString().toLowerCase();
    private final  static String browser = ReadJson.getConfigData("browser").toString().toLowerCase();
    private final  static String downloadDirectory = ReadJson.getConfigData("downloadDirectory").toString();

    private static boolean incognitoIsTrue(){
        return (boolean) ReadJson.getConfigData("incognito");
    }

    protected static ChromeOptions configChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDirectory);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs",prefs);
        return options;
    }

    protected static FirefoxOptions configFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        options.addPreference("browser.download.dir", downloadDirectory);
        options.addPreference("browser.download.folderList",2);
        return options;
    }

    protected static OperaOptions configOpera() {
        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        return options;
    }

    protected static EdgeOptions configEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        return options;
    }

    private static String localeAndLanguage() {
        return "--lang=" + language.toLowerCase() + "-" + location.toUpperCase();
    }

    private static String configIncognito() {
        String incognito;
        switch (browser) {
            case ("chrome"):
                incognito = "--incognito";
                break;
            case ("firefox"):
                incognito = "-private";
                break;
            case ("opera"):
                incognito = "private";
                break;
            case ("edge"):
                incognito = "inprivate";
                break;
            default:
                incognito = null;
        }
        return incognito;
    }
}
