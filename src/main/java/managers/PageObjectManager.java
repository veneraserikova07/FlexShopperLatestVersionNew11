package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private ProfileInfoPage profileInfoPage;
    private ForgotPasswordPage forgotPasswordPage;
    private HomePage homePage;
    private CodeScreenPage codeScreenPage;
    private ResetPasswordPage changePasswordScreen;

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

    public ForgotPasswordPage getForgotPasswordPage() {return (forgotPasswordPage==null) ? forgotPasswordPage =
            new ForgotPasswordPage(driver) : forgotPasswordPage;
    }
    public CodeScreenPage getCodeScreenPage (){return (codeScreenPage==null) ? codeScreenPage=
            new CodeScreenPage(driver) : codeScreenPage;
    }
    public ResetPasswordPage getChangePasswordScreen (){return (changePasswordScreen==null) ? changePasswordScreen=
            new ResetPasswordPage(driver) : changePasswordScreen;
    }

}