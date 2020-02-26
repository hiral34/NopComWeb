package InfoSys;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ClothingPage extends Utils{
    private By _dropDownPrice = By.id("products-orderby");
    private By _arrayName = By.className("prices");
    public void verifyUserIsOnClothingPage(){
        assertURL("clothing");
    }
    public void sortProductsHighToLow(){
        selectClothingHighToLowByValue(By.id("products-orderby"),"https://demo.nopcommerce.com/clothing?orderby=11");
       //comment the above and uncomment the bottom line to cross-check prices low to high
       // selectClothingHighToLowByValue(By.id("products-orderby"),"https://demo.nopcommerce.com/clothing?orderby=10");
        List<WebElement> priceOrder = driver.findElements(_arrayName);
        List<String> allElementsPrice = new ArrayList<>();
        //declaring and initialising local variable needed to compare products
        float fPrice2 = 0.0f;
        boolean hightolow = false;
        //loop to store and compare prices
        for (int i=0;i<priceOrder.size();i++){
            allElementsPrice.add(priceOrder.get(i).getText());
            //System.out.println(priceOrder.get(i).getText());
            String strPrice1 =  priceOrder.get(i).getText().substring(priceOrder.get(i).getText().indexOf("$")+1,priceOrder.get(i).getText().length());
            float fPrice1 = Float.parseFloat(strPrice1);
            System.out.println(fPrice1);
            //logic to only compare until last product and not go beyond
            if(i<priceOrder.size()-1){
                String strPrice2 =  priceOrder.get(i+1).getText().substring(priceOrder.get(i+1).getText().indexOf("$")+1,priceOrder.get(i+1).getText().length());
                fPrice2 = Float.parseFloat(strPrice2);
                //comparing price of product 1 with product 2 and storing the result in boolean variable
                if(fPrice1 >= fPrice2){
                    hightolow = true;
                }else{
                    hightolow = false;
                }
            }
            //System.out.println(hightolow);
            Assert.assertTrue("Prices are not in High to Low order", hightolow);
        }
    }
}
