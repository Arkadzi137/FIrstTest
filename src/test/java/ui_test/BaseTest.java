package ui_test;


import Framework.BrowserFactory.BrowserUtil;

import Framework.Util.ReadJson;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;


abstract public class BaseTest {

    @AfterMethod
    public void tearDown() {
        BrowserUtil.killDriver();
    }

    @DataProvider(name = "ListOfUsers")
    public static Object[][] ListOfUsers() {
        Object[][] obj = new Object[ReadJson.getUsers().size()][1];
        System.out.println(ReadJson.getUsers().size());
        for (int i = 0; i < ReadJson.getUsers().size(); i++) {
            obj[i][0]=ReadJson.getUsers().get(i);
        }
        return obj;
    }

}

