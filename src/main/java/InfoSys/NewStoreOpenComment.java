package InfoSys;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class NewStoreOpenComment extends Utils{
    SoftAssert softAssert = new SoftAssert();
    LoadProp loadProp = new LoadProp();
    private By _commentTitle = By.className("enter-comment-title");
    private By _commentText = By.id("AddNewComment_CommentText");
    private By _addComment = By.xpath("//input[@name='add-comment']");
    private By _resultmessage = By.xpath("//div[@class='result']");

    private String expected = "News comment is successfully added.";
    private By _arrayCommentsList = By.xpath("//div[@class='comment-content']");
    String commentTitle = loadProp.getProperty("commenttitle");
    String commentDetails = loadProp.getProperty("commentdetails");

    public void newStoreOpenComments(){

        writeText(_commentTitle,commentTitle);
        writeText(_commentText,commentDetails);
        clickOnElement(_addComment);
        String actual = getTextElement(_resultmessage);
        //Assert.assertEquals("comment not added successfully", expected, actual);
        softAssert.assertEquals(actual,expected,"comment not added successfully");
        List<WebElement> listComments = driver.findElements(_arrayCommentsList);
        softAssert.assertTrue(listComments.get(listComments.size()-1).getText().contains("Our area was desperately in need of such store"),"New comment does not match the latest comment displayed at bottom");
        //Assert.assertTrue("New comment does not match the latest comment displayed at bottom",listComments.get(listComments.size()-1).getText().contains("Our area was desperately in need of such store"));
        softAssert.assertAll();
    }

}
