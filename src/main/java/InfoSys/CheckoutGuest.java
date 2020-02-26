package InfoSys;

import org.openqa.selenium.By;

public class CheckoutGuest extends Utils{
    private By _chkoutAsGuestButton = By.xpath("//input [contains (@class,'checkout-as-guest-button')]");
    public void CheckoutAsGuest(){
        clickOnElement(_chkoutAsGuestButton);
    }
}
