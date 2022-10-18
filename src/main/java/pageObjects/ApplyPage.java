package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplyPage {
    WebDriver driver;

    public ApplyPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
     @FindBy(how = How.ID, using = "firstName-input")
     public WebElement firstNamePP3;

    @FindBy(how = How.ID, using = "lastName-input")
    public WebElement lastNamePP3;

    @FindBy(how = How.ID, using = "phone1-input")
    public WebElement phonePP3;

    @FindBy(how = How.ID, using = "enterManualLink")
    public WebElement enterAddressManuallyPP3;

    @FindBy(how = How.ID, using = "street1-input")
    public WebElement streetPP3;

    @FindBy(how = How.XPATH, using = "//*[@id='formSubmitButton']/span")
    public WebElement ContinueBtnPP3;

    @FindBy(how = How.XPATH, using = "//h2[text()='Profile Info']")
    public WebElement ProfileInfoScreenPP3;

     @FindBy(how = How.ID, using = "dob-input")
    public WebElement dobPP3;

    @FindBy(how = How.ID, using = "ssn-input")
    public WebElement ssnPP3;

    @FindBy(how = How.ID, using = "monthlyIncome-input")
    public WebElement monthlyIncomePP3;

    @FindBy(how = How.ID, using = "payFrequency-input")
    public WebElement payFrequencyPP3;

    @FindBy(how=How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div/div/form/div/div[6]/label/div[1]")
    public WebElement AgreementCheckBoxPP3;

    @FindBy(how=How.XPATH, using = "//h2[text()='Personal Info']")
    public WebElement PersonalInfoPScreenP3;

    @FindBy(how=How.XPATH, using = "//h2[.='Banking Info']")
    public WebElement BankingInfoPScreenP3;

    @FindBy(how = How.ID, using = "routingNumber-input")
    public WebElement routingNumberPP3;

    @FindBy(how = How.ID, using = "accountNumber-input")
    public WebElement accountNumberPP3;

    @FindBy(how = How.ID, using = "confirmAccountNumber-input")
    public WebElement confirmAccountNumberPP3;

    @FindBy(how = How.XPATH, using = "formSubmitButton")
    public WebElement submitBtnPP3;

    @FindBy(how = How.ID, using = "decision-decisionTitle-lease")
    public WebElement congratulationMessageScreenPP3;

    @FindBy(how = How.XPATH, using = "//*[@id='decision-headerDescription-lease']/div[1]")
    public WebElement approvedSpendingLimitOfMsg;

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div[1]/h3")
    public WebElement spendingLimitText;

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div[1]/ul/li[1]")
    public WebElement easyWeeklyPayments;

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/text()")
    public WebElement Own12MonthOrLess;

    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/u")
    public WebElement Days90SameAsCash;

    @FindBy(how = How.XPATH,using = "//span[.='Start Shopping']")
    public WebElement startShoppingBtn;




































}
