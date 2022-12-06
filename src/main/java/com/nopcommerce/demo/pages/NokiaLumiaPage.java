package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class NokiaLumiaPage extends Utility {

    By nokiaText = By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]");
    By nokiaPrice = By.xpath("//span[@id='price-value-20']");
    By changeqty = By.cssSelector("#product_enteredQuantity_20");
    By nokiaAddToCart = By.cssSelector("#add-to-cart-button-20");

    By productAddedText = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By clickOnXButton = By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]");

    By mouseHoverShoppingCart = By.xpath("//span[contains(text(),'Shopping cart')]");
    By clickOnCart = By.xpath("//button[contains(text(),'Go to cart')]");
    public String verifyNokiaLumiaText(){
        return getTextFromElement(nokiaText);
    }
    public String verifyPrice(){
        return getTextFromElement(nokiaPrice);
    }
    public void updateNokiaQuantity(String qty){
        driver.findElement (changeqty).clear();
        sendTextToElement(changeqty,qty);
    }
    public void nokiaAddToCartButton(){
        clickOnElement(nokiaAddToCart);
    }
    public String verifyProductAddedToTheCartMessage(){
        return getTextFromElement(productAddedText);
    }
    public void clickOnCrossButton(){
        clickOnElement(clickOnXButton);
    }
    public void clickOnShoppingCart(){
        mouseHoverToElement(mouseHoverShoppingCart);
        clickOnElement(clickOnCart);
    }
}
