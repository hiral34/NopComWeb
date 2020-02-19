package InfoSys;
import org.openqa.selenium.By;

public class RegistrationPage extends Utils{

        private By _firstName = By.name("FirstName");
        private By _lastName = By.id("LastName");
        private By _email = By.id("Email");
        private By _password = By.id("Password");
        private By _confirmPassword = By.id("ConfirmPassword");
        private By _registrationButton = By.id("register-button");

        private String firstName = "Hiral";
        private String lastName = "Shah";
        private String email = "abd+"+ timeStamp() + "@yahoo.com";

    public void verifyUserIsOnRegistrationPage(){
        assertURL("register");
    }
    public void userEnterRegistrationDetails(){
        writeText(_firstName, firstName);
        writeText(_lastName, lastName);
        writeText(_email,email);
        writeText(_firstName, firstName);
        writeText(_password, "test123");
        writeText(_confirmPassword, "test123");
        clickOnElement(_registrationButton);
    }
}
