package InfoSys;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.xml.dom.ParentSetter;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends BaseTest{

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    JewelryPage jewelryPage = new JewelryPage();
    ProductComparison productComparison = new ProductComparison();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    LoginPage loginPage = new LoginPage();
    ClothingPage clothingPage = new ClothingPage();
    SoftAssert softAssert = new SoftAssert();
    ShoppingCart shoppingCart = new ShoppingCart();
    CheckoutGuest checkoutGuest = new CheckoutGuest();
    OnePageCheckout onePageCheckout = new OnePageCheckout();
    NewsPage newsPage = new NewsPage();
    NewStoreOpenComment newStoreOpenComment = new NewStoreOpenComment();
    @Test
    public void userShouldAbleToRegisterSuccessfully(){

        //click on register
        homePage.clickOnRegistrationLink();
        //chk user on registration page
        registrationPage.verifyUserIsOnRegistrationPage();
        //enter registration details
        registrationPage.userEnterRegistrationDetails();
        //assert message
        registrationResultPage.verifyUserRegistrationSuccessfulMessage();
    }
    @Test
    public void userShouldBeAbleToCompareProducts(){
        //click on jewelery
        homePage.clickOnJewelleryLink();
        //verify user on jewelry page
        jewelryPage.verifyUserIsOnJewelryPage();
        //choose the products to compare
        jewelryPage.chooseProductsToCompare();
        //check user is now on product comparison page
        productComparison.verifyUserOnProductComparisonPage();
    }
    @Test
    public void unregisteredUserShouldNOTBeAbleReferAFriend(){
        //Pre-condition - User is on products page already
        Utils.navigateToJewelryPage();
        jewelryPage.verifyUserIsOnJewelryPage();
        //Choose and click a Product
        jewelryPage.chooseAProduct();
        //Click on refer a product to friend
        productDetailsPage.referProductToFriend();
        //verify user is on Email a friend page
        emailAFriendPage.verifyUserOnEmailAFriendPage();
        //enter email form details
        emailAFriendPage.enterEmailFormDetails();
        //verify refer a friend email form submission message
        emailAFriendPage.verifyReferAFriendMessage();
    }
    @Test
    public void registeredUserShouldBeAbleToReferAFriend(){
        //  Register a User
            homePage.clickOnRegistrationLink();
        //  Verify user on Registration page
            registrationPage.verifyUserIsOnRegistrationPage();
        //  enter registration details
            registrationPage.userEnterRegistrationDetails();
        //  Navigate to Products(Jewelry) Page
            Utils.navigateToJewelryPage();
        //  Verify user is on jewelry page
            jewelryPage.verifyUserIsOnJewelryPage();
        //  Choose and click a Product
            jewelryPage.chooseAProduct();
        //  verify user is on product details page
        //  Click on refer a product to friend
            productDetailsPage.referProductToFriend();
        //  verify user is on Email a friend page
            emailAFriendPage.verifyUserOnEmailAFriendPage();
        //  enter email form details
            emailAFriendPage.enterEmailFormDetails();
        //  verify refer a friend email form submission message sent
            emailAFriendPage.verifyReferAFriendMessageSent();
    }
    @Test
    public void userShouldBeAbleToSortOutProductHighToLow(){
        //  pre-Condition, user should be on Products page
        Utils.navigateToClothingPage();
        //  verify the user is on product page
        clothingPage.verifyUserIsOnClothingPage();
        //  Sort High to Low and Chk the products are displayed in price order High to Low
        clothingPage.sortProductsHighToLow();
    }
    @Test
    public void displayProductPrice(){
        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        //System.out.println(priceList.size());
        for (WebElement we:priceList){
            System.out.println(we.getText());
            System.out.println("*****************");
//            Assert.assertTrue(we.getText().contains("£"),"£ not found in"+we.getText());
            softAssert.assertTrue(we.getText().contains("£"),"£ not found in "+ we.getText());
        }
        softAssert.assertAll();
        System.out.println("my name is raj");
    }
   @Test
   public void guestUserShouldCheckoutSuccessfully(){
        //click on product category and choose a product
        Utils.navigateToJewelryPage();
        jewelryPage.verifyUserIsOnJewelryPage();
        //Choose and click a Product
        jewelryPage.chooseAProduct();
        //add product to cart
        productDetailsPage.addProductToCart();
        //Accept terms and chekout
        shoppingCart.checkoutProducts();
        //Choose guest checkout option
        checkoutGuest.CheckoutAsGuest();
        //Fill in form details
        onePageCheckout.fillFormDetails();
   }
   @Test
    public void guestUserShouldBeAbleToComment(){
        //click on news link
        homePage.clickOnNewsLink();
        //click on news details
        newsPage.clickOnNewsDetails();
        //enter comments
        newStoreOpenComment.newStoreOpenComments();
   }
   @Test
   public void userShouldBeAbleToChangeCurrency(){
        //check the prices change or not on home page once the currency changes
        homePage.getCurrentCurrency();
   }

   @Test
    public void verifyAddToCartButtonForAllFeaturedProducts(){
        //loop through the featured products on home page to look for Add to Cart button
        homePage.checkAddToCartButtonOnProducts();
   }
}
