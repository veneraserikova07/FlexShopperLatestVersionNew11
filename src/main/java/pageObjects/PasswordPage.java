package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    WebDriver driver;


    public PasswordPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
     @FindBy(how = How.ID,using = "password-input")
    public WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//span[text()='Invalid email or password: please check your details and try again']")
    public WebElement errorMsg;

    @FindBy(how= How.XPATH, using = "//span[@label='Required']")
    public  WebElement errMsgReq;


    @FindBy(how = How.ID, using = "formSubmitButton")
    public WebElement signInBtn;


    public  void enter_password(String password) {
        passwordField.sendKeys(password);
    }

}
