package InfoSys;

import org.openqa.selenium.By;

public class RegistrationResultPage extends Utils{

        private By _registrationSuccessfulMessage = By.className("result");

        String expected = "Your registration completed.";

    public void verifyUserRegistrationSuccessfulMessage(){
        assertURL("registerresult");
        assertTextMessage("Registration not successful", expected, _registrationSuccessfulMessage);
    }
}
