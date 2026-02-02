package com.pichincha.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    private WebElementFacade btnAdd;

    public void addToCart() {
        btnAdd.waitUntilClickable()
                .withTimeoutOf(Duration.ofSeconds(100))
                .click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }


}
