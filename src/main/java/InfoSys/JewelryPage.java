package InfoSys;

import org.openqa.selenium.By;

public class JewelryPage extends Utils{
    private By _product1 = By.xpath("//input [contains(@onclick, '/compareproducts/add/41')]");
    private By _product2 = By.xpath("//input [contains(@onclick, '/compareproducts/add/42')]");
    private By _product3 = By.xpath("//input [contains(@onclick, '/compareproducts/add/40')]");
    private By _comparisonLink = By.xpath("//a [text()='product comparison']");
    private By _productBracelet = By.xpath("//img [@src='//demo.nopcommerce.com/images/thumbs/0000072_flower-girl-bracelet_415.jpg']");

    public void verifyUserIsOnJewelryPage(){
        assertURL("jewelry");
    }
    public void chooseProductsToCompare(){
        clickOnElement(_product1);
        clickOnElement(_product2);
        clickOnElement(_product3);
        clickOnElement(_comparisonLink);
    }
    public void chooseAProduct(){
        clickOnElement(_productBracelet);
    }

}
