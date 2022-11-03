package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    public ElementsPage() {
        super(new Label(By.xpath("//div[contains(@class, 'element-list') and contains(@class, 'show')]"),"elements page"),"elements page");
    }

    private Button buttonWebTables = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-3']"),"button Web Tables");
    private Button buttonDownload = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-7']"),"button Upload and Download");

    public void clickButtonWebTables(){
        buttonWebTables.click();
    }

    public void clickButtonUploadAndDownload(){
        buttonDownload.click();
    }


}
