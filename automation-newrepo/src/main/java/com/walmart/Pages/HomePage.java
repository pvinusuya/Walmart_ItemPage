package com.walmart.Pages;


import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    @FindBy(xpath = ".//*[@data-automation='search-form-input']")
    private FluentWebElement searchBoxText;

    @FindBy(xpath = ".//*[@data-automation='search-form-submit']")
    private FluentWebElement searchButton;


    public void searchByItemName(String searchitem)
    {
        Assert.assertTrue(isVisible(searchBoxText));
        searchBoxText.clear().text(searchitem);
        searchButton.click();
        await().explicitlyFor(10, TimeUnit.SECONDS).untilPage().isLoaded();

    }

    public Boolean isVisible(FluentWebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
