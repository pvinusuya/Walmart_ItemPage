package com.walmart.Pages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public  class ItemPage extends BasePage {

    @FindBy(xpath = ".//*[@data-automation='cta-button']")
    private FluentWebElement addToCartButton;

    @FindBy(xpath = ".//*[@data-automation='increase-qty']")
    private FluentWebElement increaseQuantityButton;

    @FindBy(xpath = ".//*[@data-automation='decrease-qty']")
    private FluentWebElement decreaseQuantityButton;

    @FindBy(xpath = ".//*[@data-automation='quantity']/input")
    private FluentWebElement quantityText;

    @FindBy(xpath = ".//*[@data-automation='product-title']")
    private FluentWebElement productTitleText;

    @FindBy(xpath = ".//*[@data-automation='review-link']")
    private FluentWebElement reviewLink;

    @FindBy(xpath = ".//*[@data-automation='rating-stars']")
    private FluentWebElement reviewStars;

    @FindBy(xpath = ".//*[@data-automation='buybox-price']")
    private FluentWebElement buyboxPrice;


    public void isAt() {
        await().until(addToCartButton).isDisplayed();
        Assert.assertTrue(url().contains("ip"), "Failed to navigate to Item Page");
        System.out.println("Is at Item page");

    }

    public void increaseQuantity() {
        Assert.assertTrue(increaseQuantityButton.isDisplayed(), "Increase Quantity Button is not displayed");
        increaseQuantityButton.click();
    }

    public void decreaseQuantity() {
        Assert.assertTrue(decreaseQuantityButton.isDisplayed(), "Decrease Quantity Button is not displayed");
        decreaseQuantityButton.click();
    }

    public int getQuantity() {
        String current_quantity = quantityText.getAttribute("value");
        return Integer.parseInt(current_quantity);

    }

    public Boolean additemtocart() {
        if (addToCartButton.isEnabled()) {
            addToCartButton.click();
        }
        return true;
    }

    public String getproductTitle()
    {
        String title = productTitleText.getText();
        return title;
    }

    public String getItemPrice()
    {
        String price = buyboxPrice.getText();
        return price;
    }

    public Boolean isVisibleReviewStars()
    {
        reviewStars.isDisplayed();
        return true;
    }
    public Boolean isVisibleReviewLink()
    {
        reviewLink.isDisplayed();
        return true;
    }
}