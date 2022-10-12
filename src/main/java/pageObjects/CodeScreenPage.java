package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CodeScreenPage {
    WebDriver driver;

    public CodeScreenPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//h1[text()='We sent you a code']")
    public WebElement firstText;
    @FindBy(how = How.XPATH, using = "//p[text()='Enter verification code we sent to']")
    public WebElement secondText;
    @FindBy(how = How.XPATH, using = "")
    public WebElement email;
    @FindBy(how = How.XPATH, using = "//span[text()='nann40547@gmail.com'][@class='sc-kxynE caPLwN']")
    public WebElement emailText;
    @FindBy(how = How.ID,using = "code-input")
    public WebElement securityBox;
    @FindBy(how = How.XPATH, using = "//button[text()='No code received?']")
    public WebElement NoCodeReceivedBtn;
    @FindBy(how = How.XPATH, using = "//span[text()='Submit']")
    public WebElement SubmitBtn;
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    public WebElement securityCodeText;




}
