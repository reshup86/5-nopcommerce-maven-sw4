package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class DeskTopPage extends Utility {
    By sortByName = By.name("products-orderby");
    By addToCart = By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");


    public void selectSortByName(String text) {
        selectByValueFromDropDown(sortByName, text);
    }

    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(addToCart);
    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;

    }
}
