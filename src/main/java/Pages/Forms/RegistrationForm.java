package Pages.Forms;

import Pages.BaseForm;
import Framework.Elements.Button;
import Framework.Elements.Input;
import Framework.Elements.Label;
import Entity.User;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
    public RegistrationForm() {
        super(new Label(By.xpath("//div[contains(@class, 'modal-content')]"),"elements page"),"registration form");
    }

    private Input firstName = new Input(By.id("firstName"),"input first name");
    private Input lasrName = new Input(By.id("lastName"),"input first name");
    private Input email = new Input(By.id("userEmail"),"input first name");
    private Input age = new Input(By.id("age"),"input first name");
    private Input salary = new Input(By.id("salary"),"input first name");
    private Input department = new Input(By.id("department"),"input first name");
    private Button buttonSubmit = new Button(By.xpath("//button[contains(@id, 'submit')]"),"button Submit");
    private Input uniqueEl = new Input(By.id("userForm"),"input first name");

    public void enterUser(User user){
        firstName.sentKeys(user.getFirstName());
        lasrName.sentKeys(user.getLastName());
        email.sentKeys(user.getEmail());
        age.sentKeys(String.valueOf(user.getAge()));
        salary.sentKeys(String.valueOf(user.getSalary()));
        department.sentKeys(user.getDepartment());
    }

    public void waitUntilRegistrationFormIsVisible(){
        uniqueEl.waitUntilElementIsAppear();
    }

    public void clickButtonSubmit(){
        buttonSubmit.click();
    }
}
