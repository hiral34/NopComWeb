package InfoSys;

import InfoSys.Utils;
import org.openqa.selenium.By;

public class HomePage extends Utils {

    private By _registrationLink = By.linkText("Register");
    private By _jewelryLink = By.linkText("Jewelry");
    private By _loginLink = By.linkText("Log in");
    public void clickOnRegistrationLink(){
        clickOnElement(_registrationLink);
    }
    public void clickOnJewelleryLink(){
        clickOnElement(_jewelryLink);
    }
}
