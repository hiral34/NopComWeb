package InfoSys;

import org.openqa.selenium.By;

public class ProductDetailsPage extends Utils{
    private By _emailAFriendLink = By.xpath("//input [@value='Email a friend']");

    public void referProductToFriend(){
        clickOnElement(_emailAFriendLink);
    }
}
