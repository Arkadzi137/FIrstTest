package Pages;

import Framework.Elements.Button;
import Framework.Elements.Label;
import Entity.User;
import Pages.Forms.RegistrationForm;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {

    public WebTablesPage() {
        super(new Label(By.xpath("//div[contains(@class, 'rt-table')]"), "elements page"), "elements page");
    }

    public RegistrationForm registrationForm = new RegistrationForm();
    private Label cellTable = new Label(By.xpath("//div[contains(@class ,'rt-tr')and @role ='row']//div[@role ='gridcell']"), "cell table");
    private Button buttonAdd = new Button(By.xpath("//button[contains(@id, 'addNewRecordButton')]"), "button Add");
    private Button buttonDelete = new Button(By.xpath("//span[contains(@id, 'delete-record-4')]"), "button Delete");
    private int countOfUsers = 0;

    public void clickButtonDelete(){
        buttonDelete.click();
    }

    public void clickButtonAdd(){
        buttonAdd.click();
    }

    public boolean userIsAdded(User user) {
        for (int i = 0; i < cellTable.getElementsCount(); i++) {
            if(cellTable.getTextFromElementByIndex(i)!=null) countOfUsers++;

            if (cellTable.getTextFromElementByIndex(i).equals(user.getEmail())) return true;
        }
        return false;
    }

    public boolean userIsDeleted(User user) {
        for (int i = 0; i < cellTable.getElementsCount(); i++) {
            cellTable.getTextFromElementByIndex(i);
            if (cellTable.getTextFromElementByIndex(i).equals(user.getEmail())) return false;
        }
        return true;
    }

    public boolean numberUsersChanged() {
        int countOfUsersAfterDeleted = 0;
        for (int i = 0; i < cellTable.getElementsCount(); i++) {
            if(cellTable.getTextFromElementByIndex(i)!=null) countOfUsers++;}
        if (countOfUsersAfterDeleted != countOfUsers) return true;
        return false;
    }

}
