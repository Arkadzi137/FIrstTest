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
        AlarmFrameWindowPage alarmFrameWindowPage = new AlarmFrameWindowPage();
        AlertsPage alertsPage = new AlertsPage();

        BrowserUtil.openPage();
        Assert.assertTrue(homePage.isOpen(), "Home page opened");
        homePage.clickButtonAlertsFrameWindows();
        BrowserUtil.scroll(250);
        alarmFrameWindowPage.clickButtonAlerts();
        Assert.assertTrue(alertsPage.isOpen(),"form Alerts is visible");
        alertsPage.clickButtonToSeeAlert();
        Assert.assertTrue(Alert.isAlertPresent(),"Alert opened");
        Assert.assertEquals(Alert.getText(),"You clicked a button","Alert with text \"You clicked a button\" opened");
        Alert.accept();
        Assert.assertFalse(Alert.isAlertPresent(),"Alert closed");
        alertsPage.clickButtonConfirmBoxAlert();
        Assert.assertTrue(Alert.isAlertPresent(),"Alert opened");
        Assert.assertEquals(Alert.getText(),"Do you confirm action?","Alert with text \"Do you confirm action?\" opened");
        Alert.accept();
        Assert.assertFalse(Alert.isAlertPresent(),"Alert closed");
        Assert.assertEquals(alertsPage.getTextNextToBtnConfirmBoxAlert(),"You selected Ok","Text \"You selected Ok\" next to button appeared");
        alertsPage.clickButtonPromtAlert();
        Assert.assertTrue(Alert.isAlertPresent(),"Alert opened");
        Assert.assertEquals(Alert.getText(),"Please enter your name","Alert with text \"Please enter your name\" opened");
        String randomText = UtilsMethods.randomText(5);
        Alert.sendKeys(randomText);
        Alert.accept();
        Assert.assertFalse(Alert.isAlertPresent(),"Alert closed");
        Assert.assertEquals(alertsPage.getTextNextToBtnPromtAlert(),"You entered "+ randomText,"Text "+ randomText+" next to button appeared");
        Log.endTestCase("checkAlerts");
    }
//    @Test
//    public void checkIframe() {
//        Log.startTestCase("checkAlerts");
//        HomePage homePage = new HomePage();
//        AlarmFrameWindowPage alarmFrameWindowPage = new AlarmFrameWindowPage();
//        NestedFramesPage nestedFramesPage = new NestedFramesPage();
//        FramesPage framesPage = new FramesPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonAlertsFrameWindows();
//        BrowserUtil.scroll(250);
//        alarmFrameWindowPage.clickButtonNestedFrames();
//        Assert.assertTrue(nestedFramesPage.isOpen(),"nested frames page opened");
//        Assert.assertTrue(nestedFramesPage.iframeContainText(),"In the center of page is text \"Parent frame\" and \"Child Iframe\"");
//        BrowserUtil.scroll(250);
//        nestedFramesPage.clickButtonFrames();
//        Assert.assertTrue(framesPage.isOpen(),"frames page opened");
//        Assert.assertEquals(framesPage.getTextFromBigFrame(), framesPage.getTextFromSmallFrame(), "The caption from the top frame matches the caption from the bottom");
//        Log.endTestCase("checkAlerts");
//    }
//    @Test(dataProvider = "ListOfUsers", dataProviderClass = BaseTest.class)
//    public void checkTables(User user){
//        Log.startTestCase("checkTables");
//        HomePage homePage = new HomePage();
//        ElementsPage elementsPage = new ElementsPage();
//        WebTablesPage webTablesPage = new WebTablesPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonElements();
//        BrowserUtil.scroll(250);
//        elementsPage.clickButtonWebTables();
//        Assert.assertTrue(webTablesPage.isOpen(), "Web Tables opened");
//        BrowserUtil.scroll(0);
//        webTablesPage.clickButtonAdd();
//        webTablesPage.registrationForm.waitUntilRegistrationFormIsVisible();
//        Assert.assertTrue(webTablesPage.registrationForm.isOpen(), "Registration Form opened");
//        webTablesPage.registrationForm.enterUser(user);
//        webTablesPage.registrationForm.clickButtonSubmit();
//        Assert.assertTrue(webTablesPage.userIsAdded(user), "user added");
//        webTablesPage.clickButtonDelete();
//        Assert.assertTrue(webTablesPage.userIsDeleted(user), "user deleted");
//        Assert.assertTrue(webTablesPage.numberUsersChanged(), "number of users changed");
//        Log.endTestCase("checkTables");
//    }
//    @Test
//    public void checkHandles() {
//        Log.startTestCase("checkHandles");
//        HomePage homePage = new HomePage();
//        AlarmFrameWindowPage alarmFrameWindowPage = new AlarmFrameWindowPage();
//        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
//        LinksPage linksPage = new LinksPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonAlertsFrameWindows();
//        alarmFrameWindowPage.clickButtonBrowserWindows();
//        Assert.assertTrue(browserWindowsPage.isOpen(), "browser windows page opened");
//        browserWindowsPage.clickButtonNewTab();
//        Assert.assertTrue(BrowserUtil.newTabIsOpen(), "new tab opened");
//        BrowserUtil.newTabClose();
//        Assert.assertTrue(browserWindowsPage.isOpen(), "browser windows page opened");
//        browserWindowsPage.clickButtonElements();
//        BrowserUtil.scroll(250);
//        browserWindowsPage.waitUntilButtonLinksIsVisible();
//        browserWindowsPage.clickButtonLinks();
//        Assert.assertTrue(linksPage.isOpen(), "links page opened");
//        linksPage.clickButtonHome();
//        BrowserUtil.switchToOtherTab();
//        //Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        BrowserUtil.switchToOtherTab();
//        Assert.assertTrue(linksPage.isOpen(), "links page opened");
//        Log.endTestCase("checkHandles");
//    }
//    @Test
//    public void checkSliderProgressBar() {
//        Log.startTestCase("checkSliderProgressBar");
//        HomePage homePage = new HomePage();
//        WidgetsPage widgetsPage = new WidgetsPage();
//        SliderPage sliderPage = new SliderPage();
//        ProgressBarPage progressBarPage = new ProgressBarPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonWidgets();
//        BrowserUtil.scroll(400);
//        widgetsPage.clickButtonSlider();
//        Assert.assertTrue(sliderPage.isOpen(), "Slider page opened");
//        BrowserUtil.scroll(0);
//        sliderPage.waitUntilSliderIsVisible();
//        int randomNumber = UtilsMethods.randomNumber(100);
//        sliderPage.moveSlider(randomNumber);
//        Assert.assertEquals(randomNumber,sliderPage.getValueAttribute(),"Random value equals value next to slider");
//        BrowserUtil.scroll(400);
//        sliderPage.clickButtonProgressBar();
//        Assert.assertTrue(progressBarPage.isOpen(), "Progress Bar page opened");
//        progressBarPage.waitUntilButtonStartToBeClickable();
//        progressBarPage.clickButtonStartStop();
//        progressBarPage.waitUntilPercentMatchAge();
//        Assert.assertTrue(progressBarPage.precentProgressBarMatchAge(),"The value on the loading bar corresponds to the age of the engineer (the error does not exceed 2%)");
//        Log.endTestCase("checkSliderProgressBar");
//    }
//    @Test
//    public void checkDatePicker(){
//        Log.startTestCase("checkSliderProgressBar");
//        HomePage homePage = new HomePage();
//        WidgetsPage widgetsPage = new WidgetsPage();
//        DatePickerPage datePickerPage = new DatePickerPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonWidgets();
//        BrowserUtil.scroll(400);
//        widgetsPage.clickButtonDataPicker();
//        Assert.assertTrue(datePickerPage.isOpen(), "Date Picker page opened");
//        BrowserUtil.scroll(0);
//        Assert.assertEquals(datePickerPage.getDateOnPage(),UtilsMethods.getDateNow(),"date on page equals date now");
//        Assert.assertEquals(datePickerPage.getDateAndTimeOnPage(),UtilsMethods.getDateAndTimeNow(),"date and time on page equals date and time now");
//        datePickerPage.clickDateInput();
//        datePickerPage.sendDateOnLeapYearToDateInput(datePickerPage.getMonthOfTestingData(),datePickerPage.getDayOfTestingData());
//        Assert.assertEquals(datePickerPage.getDateOnPage(),datePickerPage.getDateOnLeapYear(02,29),"date on page equals entered date");
//    }
//
//    @Test
//    public void checkFiles(){
//        HomePage homePage = new HomePage();
//        ElementsPage elementsPage = new ElementsPage();
//        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage();
//
//        BrowserUtil.openPage();
//        Assert.assertTrue(homePage.isOpen(), "Home page opened");
//        homePage.clickButtonElements();
//        BrowserUtil.scroll(350);
//        elementsPage.clickButtonUploadAndDownload();
//        BrowserUtil.scroll(0);
//        Assert.assertTrue(uploadDownloadPage.isOpen(), "Upload Download page opened");
//        uploadDownloadPage.clickButtonDownload();
//        Assert.assertTrue( uploadDownloadPage.fileIsExists(), "File saved");
//        uploadDownloadPage.fileUpload();
//        Assert.assertTrue(uploadDownloadPage.getTextBelowUploadButton().contains(uploadDownloadPage.getNameFile()),
//                "Text below button has a path containing the name of the file");
//    }
}
