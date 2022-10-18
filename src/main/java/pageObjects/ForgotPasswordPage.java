package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div/div/label[2]/div[1]")
    public WebElement textMsgRadioBtn;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div/div/label[1]/div[2]/div/span[2]")
    public WebElement emailName;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div/div/label[2]/div[2]/div/span[2]")
    public WebElement phoneNumber;


 public void clickToSendSms(){
     try {
         WebDriverWait wait = new WebDriverWait(driver, 30);
         WebElement element = wait.until(ExpectedConditions.visibilityOf(textMsgRadioBtn));
     } catch (
             TimeoutException toe) {
         System.out.println("WebElement wasn't found");
     }
   textMsgRadioBtn.click();

 }






}
