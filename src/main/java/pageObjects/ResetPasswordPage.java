package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   @FindBy(how = How.XPATH, using = "//h3[text()='How would you like to reset your password?" +
           " You can verify by email or request a text to be sent to the mobile number linked to your account.']")
    public WebElement ChangePsdText;
    @FindBy(how = How.ID, using = "password-input")
    public WebElement psdInputBox;
    @FindBy(how = How.ID, using = "notYou-button")
    public WebElement notYouBtn;
    @FindBy(how = How.XPATH, using = "//span[text()='Change Password']")
    public WebElement changePassword;
}
