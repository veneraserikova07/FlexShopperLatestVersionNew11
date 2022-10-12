package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {


    WebDriver driver;



    public ForgotPasswordPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(how = How.XPATH, using = "//h3[text()='How would you like to reset your password? " +
                                      "You can verify by email or request a text to be sent " +
                                       "to the mobile number linked to your account.']")
    public WebElement resetPasswordText;

    @FindBy(how =How.XPATH, using = "//p[text()='Please choose one of the options below:']")
    public WebElement chooseOptionsText;

    @FindBy(how = How.XPATH, using = "//span[text()='Send email to:']")
    public WebElement email;
    @FindBy(how = How.XPATH, using = "//span[text()='Send SMS text with code to:']")
    public WebElement txtMsg;
    @FindBy(how = How.XPATH, using = "//span[text()='Continue']")
    public WebElement continueBtn;
    @FindBy(how = How.XPATH, using = "//a[text()='Return to Password Sign In']")
    public WebElement returnToPwd;
     @FindBy(how = How.XPATH, using = "(//div[@class='sc-fMiknA erPZuz'])[1]")
    public WebElement emailRadioBtn;
    @FindBy(how = How.XPATH, using = "(//div[@class='sc-fMiknA erPZuz'])[2]")
    public WebElement textMsgRadioBtn;


}
