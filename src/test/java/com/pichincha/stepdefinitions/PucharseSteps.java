package com.pichincha.stepdefinitions;

import com.pichincha.models.User;
import com.pichincha.pages.*;
import com.pichincha.utils.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;


public class PucharseSteps {

    JsonUtils jsonUtils;

    User user = JsonUtils.readJson("src/test/resources/data/userExample.json");

    @Steps
    HomePage homePage;

    @Steps
    ProductPage productPage;

    @Steps
    CartPage cartPage;

    @Steps
    FormPage formPage;

    @Steps
    CheckPage checkPage;


    @Given("que estoy en la página principal")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @When("agrego los productos {string} y {string} al carrito")
    public void addProductsToCart(String product1, String product2) {
        homePage.addProduct(product1);
        productPage.addToCart();

        homePage.openHomePage();

        homePage.addProduct(product2);
        productPage.addToCart();
    }

    @When("visualizo el carrito")
    public void viewCart() {
        homePage.goToCart();
        if (!cartPage.isOnCartPage()) {
            throw new AssertionError("No se visualiza la página del carrito");
        }
        cartPage.placeOrder();

    }

    @When("completo el formulario")
    public void formCompleted() throws InterruptedException {
        formPage.formComplete(user);

    }

    @Then("finalizo la compra exitosamente")
    public void finishPurchase() {
        checkPage.isOnCheckPage();

        if (!checkPage.isOnCheckPage()) {
            throw new AssertionError("No se visualiza la información de venta");
        }

        checkPage.finishPurchase();
    }


}
