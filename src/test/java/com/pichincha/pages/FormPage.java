package com.pichincha.pages;

import com.pichincha.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;

public class FormPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElementFacade inputName;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElementFacade inputCountry;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElementFacade inputCity;

    @FindBy(xpath = "//*[@id=\"card\"]")
    private WebElementFacade inputCard;

    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElementFacade inputMonth;

    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElementFacade inputYear;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    private WebElementFacade btnPurchase;


    public void formComplete(User user) throws InterruptedException {

        WebElementFacade tittleName = find(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[1]/label"));
        tittleName.waitUntilVisible().withTimeoutOf(Duration.ofSeconds(60));
        if (tittleName.isVisible() ){

            Thread.sleep(800);
            inputName.type(user.getName());

            Thread.sleep(800);
            inputCountry.type(user.getCountry());

            Thread.sleep(800);
            inputCity.type(user.getCity());

            Thread.sleep(800);
            inputCard.type(String.valueOf(user.getCard()));

            Thread.sleep(800);
            inputMonth.type(String.valueOf(user.getMonth()));

            Thread.sleep(800);
            inputYear.type(String.valueOf(user.getYear()));

            Thread.sleep(800);
            btnPurchase.click();
        }
    }

}
