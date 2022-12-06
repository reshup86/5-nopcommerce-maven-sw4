package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class PaymentMethodCheckOutPage extends Utility {
    By creditcard = By.cssSelector("#paymentmethod_1");
    By continuebutton = By.xpath("//ol[1]/li[4]/div[2]/div[1]/button[1]");


    public void clickOnCreditCard() {
        clickOnElement(creditcard);
    }

    public void clickOnContinue() {
        clickOnElement(continuebutton);
    }
}
