package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PasswordPge {
    public PasswordPge(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
