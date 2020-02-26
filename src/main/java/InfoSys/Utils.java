package InfoSys;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils extends BasePage{
    //creating a method to reuse simple time format anywhere in the project
    public static String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DDmmYYHHmmSS");
        Date date=new Date();
        return dateFormat.format(date);
    }
    //creating reusable onClick method
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    //a reusable getText method to use across the project
    public static String getTextElement(By by){
        return driver.findElement(by).getText();
    }
    public static String getTextAttribute(By by){
        return driver.findElement(by).getAttribute("value");
        //return driver.findElement(By.id("email")).getAttribute("value")
    }
    public static void navigateToJewelryPage(){
        driver.get("https://demo.nopcommerce.com/jewelry");
    }
    //creating a select by value method
    public static void selectByValue(By by, String value){
        Select dropdown3 = new Select(driver.findElement(by));
        dropdown3.selectByValue(value);
    }
    public static void selectCountryByIndex(By by, int intNum){
        Select dropdownCountry = new Select(driver.findElement(by));
        dropdownCountry.selectByIndex(intNum);
    }
    public static void selectExpiryMonthByIndex(By by, int intNum) {
        Select dropdownExpiryMonth = new Select(driver.findElement(by));
        dropdownExpiryMonth.selectByIndex(intNum);
    }
    public static void selectStateByValue(By by, String strValue){
        Select dropdownState = new Select(driver.findElement(by));
        dropdownState.selectByValue(strValue);
    }
    public static void selectClothingHighToLowByValue(By by, String value) {
        Select dropdownClothing = new Select(driver.findElement(by));
        dropdownClothing.selectByValue(value);
    }
    //creating reusable array
   /* public static String findArrayElements(By by){
        List<WebElement> priceOrder = driver.findElements(by);
         List<String> allElementsPrice = new ArrayList<>();
         return
    }*/
    //reusable write text method
    public static void writeText(By by, String strValue){
        driver.findElement(by).sendKeys(strValue);
    }

    public static void assertURL(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }
    public static void assertTextMessage(String message, String expected, By by) {
        String actual = getTextElement(by);
        Assert.assertEquals(message, expected, actual);
    }
    public static void navigateToClothingPage(){
        driver.get("https://demo.nopcommerce.com/clothing");
    }
    public static void navigateToTempURL(){driver.get("https://demo.nopcommerce.com/new-online-store-is-open");}
    public static String getCurrentCurrency(By by){
        Select dropdownCurrency = new Select(driver.findElement(by));
        String selectedCurrency = dropdownCurrency.getFirstSelectedOption().getText();
        return selectedCurrency;
    }
    public static String getCurrencyChanged(By by) {
        String changedCurrency = "";
        Select dropdownChangeCurrency = new Select(driver.findElement(by));
        String selectedCurrency = dropdownChangeCurrency.getFirstSelectedOption().getText();
        if (selectedCurrency.equalsIgnoreCase("US Dollar")) {
            dropdownChangeCurrency.selectByVisibleText("Euro");
            changedCurrency = "Euro";
        } else {
            dropdownChangeCurrency.selectByVisibleText("US Dollar");
            changedCurrency = "Dollar";
        }
        return changedCurrency;

    }
}
