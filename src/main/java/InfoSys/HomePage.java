package InfoSys;

import InfoSys.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.awt.event.AWTEventListenerProxy;
import java.util.List;

public class HomePage extends Utils {
    SoftAssert softAssert = new SoftAssert();


    private By _registrationLink = By.linkText("Register");
    private By _jewelryLink = By.linkText("Jewelry");
    private By _loginLink = By.linkText("Log in");
    private By _newsLink = By.xpath("//a[@class='read-more' and @href='/new-online-store-is-open']");
    private By _currentCurrency = By.id("customerCurrency");

    public void clickOnRegistrationLink(){
        clickOnElement(_registrationLink);
    }
    public void clickOnJewelleryLink(){
        clickOnElement(_jewelryLink);
    }
    public void clickOnNewsLink(){
        clickOnElement(_newsLink);
    }
    public void checkAddToCartButtonOnProducts(){
        List<WebElement> buttonList = driver.findElements(By.xpath("//div[@class='product-item']"));
        for (WebElement web:buttonList){
            softAssert.assertTrue(web.getAttribute("innerHTML").contains("Add to cart"),"Add to Cart button not found in "+ web.getText());
            //System.out.println(web.getAttribute("innerHTML"));
        }
        softAssert.assertAll();
    }
    public void hoverOverMenus(String main_menu, String sub_category){
        Actions builder = new Actions(driver);
        Action mouseOverMenus = builder
                .moveToElement(driver.findElement(By.linkText(main_menu)))
                //.moveToElement(driver.findElement(By.linkText("Clothing")))
                //.click()
                .build();
                mouseOverMenus.perform();
                clickOnSubCategory(sub_category);
    }
    public void clickOnSubCategory(String sub_category){
        Actions builder = new Actions(driver);
        Action mouseClickSub = builder
                //.moveToElement(driver.findElement(By.linkText(main_menu)))
                .moveToElement(driver.findElement(By.linkText(sub_category)))
                .click()
                .build();
                mouseClickSub.perform();
    }
    public void getCurrentCurrency(){
        String strCurrentSymbol = "";
        String strChangedSymbol = "";
        String strChangedCur = "";
        String strCurrentCurrency = getCurrentCurrency(_currentCurrency);
        //get the current currency
        if (strCurrentCurrency.equalsIgnoreCase("US Dollar")){
             strCurrentSymbol = "$";
             List<WebElement> priceList = driver.findElements(By.className("prices"));
            //check correct currency symbol is displayed
             for (WebElement weprices:priceList) {
                 softAssert.assertTrue(weprices.getText().contains(strCurrentSymbol),"$ not found in "+ weprices.getText());
             }
             strChangedCur = getCurrencyChanged(_currentCurrency);
            //change currency
             if (strChangedCur.equalsIgnoreCase("Euro")){
                 strChangedSymbol = "Ђ";
                 List<WebElement> changedpriceList = driver.findElements(By.className("prices"));
                 //check the currency for products changed or not
                 for (WebElement wechangedprices:changedpriceList) {
                     softAssert.assertTrue(wechangedprices.getText().contains(strChangedSymbol),"Ђ not found in "+ wechangedprices.getText());
                 }
             }else{
                 softAssert.assertTrue(strChangedCur.equalsIgnoreCase("Euro"),"Currency swap didn't work.");
             }
        }else if (strCurrentCurrency.equalsIgnoreCase("Euro")) {
            strCurrentSymbol = "Ђ";
            List<WebElement> priceList = driver.findElements(By.className("prices"));
            for (WebElement weprices:priceList) {
                softAssert.assertTrue(weprices.getText().contains(strCurrentSymbol),"Ђ not found in "+ weprices.getText());
            }
            strChangedCur = getCurrencyChanged(_currentCurrency);
            if (strChangedCur.equalsIgnoreCase("US Dollar")){
                strChangedSymbol = "$";
                List<WebElement> changedpriceList = driver.findElements(By.className("prices"));
                for (WebElement wechangedprices:changedpriceList) {
                    softAssert.assertTrue(wechangedprices.getText().contains(strChangedSymbol),"$ not found in "+ wechangedprices.getText());
                }
            }else{
                softAssert.assertTrue(strChangedCur.equalsIgnoreCase("US Dollar"),"Currency swap didn't work.");
            }
        }
        softAssert.assertAll();
    }
    public void clickOnCategoryLinks(String category){
        driver.findElement(By.linkText(category)).click();
    }
}
