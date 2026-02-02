package com.pichincha.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

import java.time.Duration;

public class CartPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/h2")
    private WebElementFacade titleCart;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    private WebElementFacade btnOrder;

    public boolean isOnCartPage() {
        return titleCart.isVisible();
    }

    public void placeOrder(){
        btnOrder.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10)).click();
    }



}
