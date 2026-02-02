package com.pichincha.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;

public class CheckPage extends PageObject {

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    private WebElementFacade btnOK;

    public boolean isOnCheckPage(){
        WebElementFacade modal = find(By.xpath("/html/body/div[10]"));
        modal.waitUntilVisible().withTimeoutOf(Duration.ofSeconds(60));
        return modal.isVisible();
    }

    public void finishPurchase(){
        btnOK.click();
    }

}
