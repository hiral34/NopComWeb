package InfoSys;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDefs extends Utils{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    JewelryPage jewelryPage = new JewelryPage();
    ProductComparison productComparison = new ProductComparison();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    ClothingPage clothingPage = new ClothingPage();
    ShoppingCart shoppingCart = new ShoppingCart();
    CheckoutGuest checkoutGuest = new CheckoutGuest();
    OnePageCheckout onePageCheckout = new OnePageCheckout();
    NewsPage newsPage = new NewsPage();
    NewStoreOpenComment newStoreOpenComment = new NewStoreOpenComment();

    @Given("^user is on register page$")
    public void userIsOnRegisterPage() {
        homePage.clickOnRegistrationLink();
        registrationPage.verifyUserIsOnRegistrationPage();
    }

    @When("^user enters all registration details$")
    public void userEntersAllRegistrationDetails() {
        registrationPage.userEnterRegistrationDetails();
    }

    @Then("^user should able to register successfully$")
    public void userShouldAbleToRegisterSuccessfully() {
        registrationResultPage.verifyUserRegistrationSuccessfulMessage();
    }

    @Given("^User is on Products Page$")
    public void userIsOnProductsPage() {
        homePage.clickOnJewelleryLink();
    }

    @When("^user clicks two products and presses product compare buttons$")
    public void userClicksTwoProductsAndPressesProductCompareButtons() {
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.chooseProductsToCompare();
    }

    @Then("^he should be on product comparison page and his chosen products must be displayed for comparison$")
    public void heShouldBeOnProductComparisonPageAndHisChosenProductsMustBeDisplayedForComparison() {
        productComparison.verifyUserOnProductComparisonPage();
    }

    @Given("^User is on Home page and clicks to register$")
    public void userIsOnHomePageAndClicksToRegister() {
        homePage.clickOnRegistrationLink();
        registrationPage.verifyUserIsOnRegistrationPage();
    }

    @When("^user registers and clicks on refer a friend button$")
    public void userRegistersAndClicksOnReferAFriendButton() {
        registrationPage.userEnterRegistrationDetails();
        Utils.navigateToJewelryPage();
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.chooseAProduct();
        productDetailsPage.referProductToFriend();
        emailAFriendPage.verifyUserOnEmailAFriendPage();
    }

    @And("^enters and fills in refer a friend details$")
    public void entersAndFillsInReferAFriendDetails() {
        emailAFriendPage.enterEmailFormDetails();
    }

    @Then("^he should be able to see Your message sent message$")
    public void heShouldBeAbleToSeeYourMessageSentMessage() {
        emailAFriendPage.verifyReferAFriendMessageSent();
    }

    @Given("^User chooses Products page$")
    public void userChoosesProductsPage() {
        Utils.navigateToJewelryPage();
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.chooseAProduct();
    }

    @When("^user clicks on refer a friend button$")
    public void userClicksOnReferAFriendButton() {
        productDetailsPage.referProductToFriend();
        emailAFriendPage.verifyUserOnEmailAFriendPage();
    }

    @Then("^user should see Only registered user able to refer message$")
    public void userShouldSeeOnlyRegisteredUserAbleToReferMessage() {
        emailAFriendPage.verifyReferAFriendMessage();
    }

    @Given("^User is on Products details page$")
    public void userIsOnProductsDetailsPage() {
        Utils.navigateToClothingPage();
    }

    @When("^user clicks on Sort High to Low dropdown$")
    public void userClicksOnSortHighToLowDropdown() {
        clothingPage.verifyUserIsOnClothingPage();
    }

    @Then("^User should see products in High to Low order$")
    public void userShouldSeeProductsInHighToLowOrder() {
        clothingPage.sortProductsHighToLow();
    }

    @Given("^guest user adds product to basket$")
    public void guestUserAddsProductToBasket() {
        Utils.navigateToJewelryPage();
        jewelryPage.verifyUserIsOnJewelryPage();
        jewelryPage.chooseAProduct();
        productDetailsPage.addProductToCart();
    }

    @When("^guest user fills in single sign on form$")
    public void guestUserFillsInSingleSignOnForm() {
        shoppingCart.checkoutProducts();

    }

    @And("^enters valid bank card details$")
    public void entersValidBankCardDetails() {
        checkoutGuest.CheckoutAsGuest();
    }

    @Then("^checkout as guest user and item ordered successfully$")
    public void checkoutAsGuestUserAndItemOrderedSuccessfully() {
        onePageCheckout.fillFormDetails();
    }

    @Given("^User is on Home Page and clicks News link$")
    public void userIsOnHomePageAndClicksNewsLink() {
        homePage.clickOnNewsLink();
    }

    @When("^guest user fills in comments$")
    public void guestUserFillsInComments() {
       // newsPage.clickOnNewsDetails();
    }

    @Then("^user should see his comment posted$")
    public void userShouldSeeHisCommentPosted() {
        newStoreOpenComment.newStoreOpenComments();
    }

    @When("^user selects a currency of his choice$")
    public void userSelectsACurrencyOfHisChoice() {
        //get the current currency from homepage
    }

    @Then("^he should see prices reflecting in currency symbol$")
    public void heShouldSeePricesReflectingInCurrencySymbol() {
        homePage.getCurrentCurrency();
    }

    @Given("^user is on home page$")
    public void userIsOnHomePage() {
        //asfdasasfasd
    }

    @When("^user should see add to cart button on all featured products$")
    public void userShouldSeeAddToCartButtonOnAllFeaturedProducts() {
        //user should be on home page
    }

    @Then("^user should be able to add the product to the cart$")
    public void userShouldBeAbleToAddTheProductToTheCart() {
        homePage.checkAddToCartButtonOnProducts();
    }

    @Given("^user is on homepage$")
    public void userIsOnHomepage() {

    }

    @When("^user clicks on \"([^\"]*)\" link from top menu$")
    public void userClicksOnLinkFromTopMenu(String category)  {
        homePage.clickOnCategoryLinks(category);
    }

    @Then("^user should able to navigate to \"([^\"]*)\" successfully$")
    public void userShouldAbleToNavigateToSuccessfully(String related_category_page)  {
        Utils.assertURL(related_category_page);
    }

    @When("^he hovers on \"([^\"]*)\" and clicks on \"([^\"]*)\"$")
    public void heHoversOnAndClicksOn(String menu_item, String sub_category) {
        // Write code here that turns the phrase above into concrete actions
        homePage.hoverOverMenus(menu_item,sub_category);
    }

    @Then("^he should be on \"([^\"]*)\" page$")
    public void heShouldBeOnPage(String sub_category)  {
        // Write code here that turns the phrase above into concrete actions
        Utils.assertURL(sub_category);
    }
    @Given("^User on Home page$")
    public void userOnHomePage() {
        //no steps required.
    }
}
