package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.PasswordPge;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPge passwordPage;
    private ProfileInfoPage profileInfoPage;

    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage==null) ? loginPage =new LoginPage(driver):loginPage;
    }

    public PasswordPge getPasswordPage() {
        return (passwordPage==null) ? passwordPage =new PasswordPge(driver) : passwordPage;
    }
    public ProfileInfoPage getProfileInfoPage() {
        return (profileInfoPage==null) ? profileInfoPage =new ProfileInfoPage(driver) : profileInfoPage;
    }


    public HomePage getHomePage() {
        return (homePage==null) ? homePage =new HomePage(driver) : homePage;
    }

}