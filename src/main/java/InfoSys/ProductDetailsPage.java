package InfoSys;

import org.openqa.selenium.By;

public class ProductDetailsPage extends Utils{
    private By _emailAFriendLink = By.xpath("//input [@value='Email a friend']");
    private By _addToCartButton = By.id("add-to-cart-button-41");
    private By _shoppingCartLink = By.xpath("//a/span [text()='Shopping cart']");

    public void referProductToFriend(){
        clickOnElement(_emailAFriendLink);
    }

    public void addProductToCart(){
        clickOnElement(_addToCartButton);
        clickOnElement(_shoppingCartLink);
    }
}
