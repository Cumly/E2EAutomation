package com.pichincha.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;

public class HomePage extends PageObject {

    @FindBy(id = "cartur")
    private WebElementFacade btnCart;

    public void openHomePage() {
        openUrl("https://www.demoblaze.com/");
    }

    public void addProduct(String productName) {
        find(By.linkText(productName)).waitUntilClickable()
                .withTimeoutOf(Duration.ofSeconds(10))
                .click();
    }

    public void goToCart() {
        btnCart.waitUntilClickable()
                .withTimeoutOf(Duration.ofSeconds(10))
                .click();
    }

}