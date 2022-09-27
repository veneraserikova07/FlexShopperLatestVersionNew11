package pageObjects;



import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;



    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }



    @FindBy(how= How.ID, using = "email-input")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = "//h3[text()='Welcome to']")
    public WebElement welcomeText;

    @FindBy(how = How.XPATH, using = "//span[@label='Invalid email address']")
    public WebElement errorMsg;

    public void enter_email(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void getEmailScreen() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

}