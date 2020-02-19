package InfoSys;

import org.openqa.selenium.By;

public class LoginPage  extends Utils{
    private By _userEmail = By.id("Email");
    private String yourEmail = "abd@yahoo.com";
    private By _password = By.id("Password");
    private String yourPassword = "test123";
    private By _loginButton = By.xpath("//input [@value='Log in']");

    public void enterLoginDetails(){
        writeText(_userEmail,yourEmail);
        writeText(_password, yourPassword);
        clickOnElement(_loginButton);
    }
}
