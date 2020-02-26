package InfoSys;

import org.junit.Assert;
import org.openqa.selenium.By;

public class OnePageCheckout extends Utils{
    LoadProp loadProp = new LoadProp();

    private By _firstName = By.id("BillingNewAddress_FirstName");
    private By _lastName = By.id("BillingNewAddress_LastName");
    private By _email = By.id("BillingNewAddress_Email");
    private By _city = By.id("BillingNewAddress_City");
    private By _country = By.id("BillingNewAddress_CountryId");
    private By _state = By.id("BillingNewAddress_StateProvinceId");
    private By _address1 = By.id("BillingNewAddress_Address1");
    private By _postcode = By.id("BillingNewAddress_ZipPostalCode");
    private By _phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private By _continueButton1 = By.xpath("//input [contains (@class,'new-address-next-step-button')]");
    private By _shippingbutton = By.xpath("//input [contains (@class,'shipping-method-next-step-button')]");
    private By _paymentMethod = By.id("paymentmethod_1");
    private By _paymentContinueButton = By.xpath("//input [contains (@class,'payment-method-next-step-button')]");
    private By _cardholderName = By.id("CardholderName");
    private By _cardNumber = By.id("CardNumber");
    private By _expiryMonth = By.id("ExpireMonth");
    private By _cvvCardNumber = By.id("CardCode");
    private By _paymentContinueButton2 = By.xpath("//input [contains (@class,'payment-info-next-step-button')]");
    private By _paymentConfirmationButton = By.xpath("//input [contains (@class,'confirm-order-next-step-button')]");
    private By _orderTitle = By.xpath("//div[@class='section order-completed']/div[@class='title']");

    String strfirstName = loadProp.getProperty("firstName");
    String strlastName = loadProp.getProperty("lastName");
    String strEmail = loadProp.getProperty("email");
    String strCity = loadProp.getProperty("city");
    String strAddress1 = loadProp.getProperty("address");
    String strPostcode = loadProp.getProperty("postcode");
    String strPhoneNumber = loadProp.getProperty("phonenumber");
    String strCardNumber = loadProp.getProperty("cardnumber");
    String strCVVCardCode = loadProp.getProperty("cardcode");
    String expected = "Your order has been successfully processed!";
    public void fillFormDetails(){
        writeText(_firstName,strfirstName);
        writeText(_lastName,strlastName);
        writeText(_email,strEmail);
        writeText(_city,strCity);
        selectCountryByIndex(_country,1);
        selectStateByValue(_state,"54");
        writeText(_address1,strAddress1);
        writeText(_postcode,strPostcode);
        writeText(_phoneNumber,strPhoneNumber);
        clickOnElement(_continueButton1);
        clickOnElement(_shippingbutton);
        clickOnElement(_paymentMethod);
        clickOnElement(_paymentContinueButton);
        writeText(_cardholderName,strfirstName);
        writeText(_cardNumber,strCardNumber);
        selectExpiryMonthByIndex(_expiryMonth,10);
        writeText(_cvvCardNumber,strCVVCardCode);
        clickOnElement(_paymentContinueButton2);
        clickOnElement(_paymentConfirmationButton);
        String actual = getTextElement(_orderTitle);
        Assert.assertEquals("Order processed message does not match",expected,actual);

    }
}
