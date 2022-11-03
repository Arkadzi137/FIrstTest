package Pages;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;



public class LinksPage extends BaseForm {
    public LinksPage(){
        super(new Label(By.xpath("//div[@id ='linkWrapper']"),"Links page"),"Links page");
    }
    private Button buttonHome = new Button(By.xpath("//a[@id='simpleLink']"),"button Home");
    String linksHandle = BrowserUtil.getWindowHandle();

    public void clickButtonHome(){
        buttonHome.click();
    }

}
