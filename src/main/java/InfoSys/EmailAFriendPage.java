package InfoSys;
import org.openqa.selenium.By;

public class EmailAFriendPage extends Utils{
    private By _friendEmailAddress = By.id("FriendEmail");
    private By _personalMessage = By.id("PersonalMessage");
    private By _yourEmailAddress = By.id("YourEmailAddress");
    private By _emailButton = By.name("send-email");
    private By _referAFriendMessage = By.xpath("//div [@class='message-error validation-summary-errors']");
    private By _referAFriendMessageSent = By.xpath("//div [@class='result']");

    private String yourEmail = "abd@yahoo.com";
    private String friendEmail = "asdf@sdf.com";
    private String personalMessage = "whatever message you would like to write to your friend along with product link.";
    private String expected = "Only registered customers can use email a friend feature";
    private String expectedSentMsg = "Your message has been sent.";

    public void verifyUserOnEmailAFriendPage(){
        assertURL("productemailafriend");
    }
    public void enterEmailFormDetails(){
        writeText(_friendEmailAddress,friendEmail);
        String doesEmailExist = getTextAttribute(_yourEmailAddress);
        if(doesEmailExist.isEmpty()) {
            writeText(_yourEmailAddress, yourEmail);
        }
        writeText(_personalMessage, personalMessage);
        clickOnElement(_emailButton);
    }
    public void verifyReferAFriendMessage(){
        assertTextMessage("Text Message does not match with expected message", expected,_referAFriendMessage);
    }
    public void verifyReferAFriendMessageSent(){
        assertTextMessage("Text Message does not match with expected message", expectedSentMsg,_referAFriendMessageSent);
    }
}
