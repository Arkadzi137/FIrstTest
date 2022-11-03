package ui_test;

import Entity.User;
import Framework.Alert;
import Framework.BrowserFactory.BrowserUtil;
import Pages.*;
import Framework.Util.UtilsMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import Framework.Log;

public class TestCases extends BaseTest {

    @Test
    public void checkAlerts() {
        Log.startTestCase("checkAlerts");
        HomePage homePage = new HomePage();

        BrowserUtil.openPage();
        Assert.assertTrue(homePage.isOpen(), "Home page opened");
    }

}
