package InfoSys;

import org.openqa.selenium.By;

public class ShoppingCart extends Utils{
    private By _chkTermsBox = By.id("termsofservice");
    private By _checkoutButton = By.id("checkout");

    public void checkoutProducts(){
        clickOnElement(_chkTermsBox);
        clickOnElement(_checkoutButton);
    }
}
