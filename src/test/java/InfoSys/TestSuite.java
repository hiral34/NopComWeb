package InfoSys;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
