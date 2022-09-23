package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.PasswordPage;
import pageObjects.ProfileInfoPage;
import pageObjects.HomePage;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private ProfileInfoPage profileInfoPage;

    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage==null) ? loginPage =new LoginPage(driver):loginPage;
    }

    public PasswordPage getPasswordPage() {
        return (passwordPage==null) ? passwordPage =new PasswordPage(driver) : passwordPage;
    }
     public ProfileInfoPage getProfileInfoPage() {
        return (profileInfoPage==null) ? profileInfoPage =new ProfileInfoPage(driver) : profileInfoPage;
     }


    public HomePage getHomePage() {
        return (homePage==null) ? homePage =new HomePage(driver) : homePage;
    }

}
