package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfileInfoPage {
    WebDriver driver;

    public ProfileInfoPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(how = How.XPATH, using = "//h2[text()='Profile Info']")
    public WebElement profilePage;



}