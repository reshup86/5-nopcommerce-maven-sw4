package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsPageTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    HomePage homePage = new HomePage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    NokiaLumiaPage nokiaLumiaPage = new NokiaLumiaPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutAsGuestPage checkOutAsGuestPage = new CheckOutAsGuestPage();
    RegisterPage registerPage = new RegisterPage();
    ShippingMethodCheckOutPage shippingMethodCheckOutPage = new ShippingMethodCheckOutPage();
    BillingCheckOutPage billingCheckOutPage = new BillingCheckOutPage();
    PaymentMethodCheckOutPage paymentMethodCheckOutPage = new PaymentMethodCheckOutPage();
    PaymentCheckOutPage paymentCheckOutPage = new PaymentCheckOutPage();

    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
    CompletedCheckOutPage completedCheckOutPage = new CompletedCheckOutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhoneAndClick();
        Assert.assertEquals(cellPhonesPage.verifyCellPhonesText(), "Cell phones", "Invalid Data");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhoneAndClick();
        Assert.assertEquals(cellPhonesPage.verifyCellPhonesText(), "Cell phones", "Invalid Data");
        cellPhonesPage.clickOnListView();
        Thread.sleep(2000);
        cellPhonesPage.clickOnProductNokia();

        Assert.assertEquals(nokiaLumiaPage.verifyNokiaLumiaText(), "Nokia Lumia 1020", "Invalid Text");
        Assert.assertEquals(nokiaLumiaPage.verifyPrice(), "$349.00", "Invalid Price");

        nokiaLumiaPage.updateNokiaQuantity("2");
        nokiaLumiaPage.nokiaAddToCartButton();
        Assert.assertEquals(nokiaLumiaPage.verifyProductAddedToTheCartMessage(), "The product has been added to your shopping cart", "Invalid Text");
        nokiaLumiaPage.clickOnCrossButton();
        Thread.sleep(2000);
        nokiaLumiaPage.clickOnShoppingCart();

        Assert.assertEquals(shoppingCartPage.verifyTheShoppingCartText(),"Shopping cart","Invalid Text");
        Assert.assertEquals(shoppingCartPage.verifyProductQuantity(), "2", "Quantity is not matching" );
        Assert.assertEquals(shoppingCartPage.verifyTotalPrice(),"$698.00","Priced is not matched");

        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckOutButton();

        Assert.assertEquals(checkOutAsGuestPage.verifyTheWelComeText(),"Welcome, Please Sign In!","Invalid data");
        checkOutAsGuestPage.clickOnRegisterTab();
        Assert.assertEquals(registerPage.verifyRegisterText(),"Register","Invalid Text");

        registerPage.enterFirstName("Shane");
        registerPage.enterLastName("James");
        registerPage.email("shanj4@example.com");
        registerPage.enterPassword("shane12345");
        registerPage.enterConfirmPassword("shane12345");
        registerPage.clickOnRegisterButton();

        Assert.assertEquals(registerPage.verifyRegistration(),"Your registration completed","Invalid Text");
        registerPage.clickOnContinue();

        Assert.assertEquals(shoppingCartPage.verifyTheShoppingCartText(),"Shopping cart","Invalid Text");
        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckOutButton();

        billingCheckOutPage.selectCountryFromDropDown("233");
        billingCheckOutPage.selectStateFromDropDown("0");
        billingCheckOutPage.enterBillingCity("London");
        billingCheckOutPage.enterBillingAddress("3,BondStreet");
        billingCheckOutPage.enterBillingZipcode("W2 5RT");
        billingCheckOutPage.enterBillingPhoneNumber("9858552255");
        registerPage.clickOnContinueTab();
        shippingMethodCheckOutPage.clickOn2ndDayAir();
        shippingMethodCheckOutPage.clickOnContinue();
        paymentMethodCheckOutPage.clickOnCreditCard();
        paymentMethodCheckOutPage.clickOnContinue();

        paymentCheckOutPage.selectCardTypeFromDropDown("visa");
        paymentCheckOutPage.enterCardHolderName("Shane James");
        paymentCheckOutPage.enterCardNumber("4222222222222");
        paymentCheckOutPage.selectExpiryMonthFromDropDown("10");
        paymentCheckOutPage.selectExpiryYearFromDropDown("2024");
        paymentCheckOutPage.enterCardCode("123");
        paymentCheckOutPage.clickOnContinueButton();

        Assert.assertEquals(confirmOrderPage.verifyCreditCardPaymentMethod(),"Credit Card","Invalid Text");
        Assert.assertEquals(confirmOrderPage.verifyShippingMethod2ndDayAir(),"2nd Day Air","Invalid Text");
        Assert.assertEquals(confirmOrderPage.verifyTheNokiaTotalPrice(),"$698.00","Invalid Text");
        confirmOrderPage.clickOnConFirm();

        Assert.assertEquals(completedCheckOutPage.verifyThankYouText(),"Thank you","Invalid Text");
        Assert.assertEquals(completedCheckOutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text isnot Display");
        completedCheckOutPage.clickOnContinue();

        Assert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Invalid Text");
        homePage.clickOnLogOut();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(baseUrl,currentUrl,"Invalid URL");
    }

}
