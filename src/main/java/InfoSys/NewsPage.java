package InfoSys;

import org.openqa.selenium.By;

public class NewsPage extends Utils{
    private By _detailsButton2 = By.xpath("//div[@class='news-head']/a[@href='/new-online-store-is-open']");
    private By _detailsButton = By.xpath("//a[@href='/new-online-store-is-open' and @class='news-title']");
                                            //a[@class='news-title' and @href='/new-online-store-is-open']
    public void clickOnNewsDetails(){
        clickOnElement(_detailsButton);
    }
}
