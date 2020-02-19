package InfoSys;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductComparison extends Utils{
    private By _pageTitle = By.xpath("//div [@class='page-title']");

    String expected = "Compare products";

    public void verifyUserOnProductComparisonPage(){
        //assertURL("compareproducts");
        assertTextMessage("Page not found",expected,_pageTitle);

    }
}
