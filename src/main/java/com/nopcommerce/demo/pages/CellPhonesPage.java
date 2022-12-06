package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class CellPhonesPage extends Utility {

    By cellPhoneText = By.xpath("//div[@class='page-title']/h1[text() = 'Cell phones']");
    By listView = By.xpath("//div/a[text()='List']");

    By productNokiaLumia = By.xpath("//h2/a[text()='Nokia Lumia 1020']");


    public String verifyCellPhonesText(){
        return getTextFromElement(cellPhoneText);
    }
    public void clickOnListView(){
        clickOnElement(listView);
    }
    public void clickOnProductNokia(){
        clickOnElement(productNokiaLumia);
    }
}
