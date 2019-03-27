package com.walmart;

import org.fluentlenium.core.domain.FluentList;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public  class ItemPageTest extends BaseTest{


    public void goToItemPageBySearch()
    {
        System.out.println("Item to be searched: " + variableManager.searchString);
        homePage.searchByItemName(variableManager.searchString);
        searchResultsPage.selectrandomItem();
        await().untilPage().isLoaded();
        itemPage.isAt();
    }

    //Test Scenario 1:
    //Add the item to the Cart
    @Test(priority = 1, groups = "Item Page")
    public void addItemToCart()
    {
        goToItemPageBySearch();
        if(itemPage.additemtocart().equals(true))
        {

            await().explicitlyFor(5, TimeUnit.SECONDS);
            FluentList addTocartmodal = find(By.cssSelector("#atc-root"));
            Assert.assertTrue(addTocartmodal.size() == 1,"Pop up window not shown");
        }
        else
        {
            System.out.println("Add to cart button is disabled - Item cannot be added to the cart");
        }

        String MainWindow = driver.getWindowHandle();

        for (String activeHandle : driver.getWindowHandles()) {
            if (!activeHandle.equals(MainWindow)) {
                driver.switchTo().window(activeHandle);
            }
            Assert.assertTrue(itemPage.getproductTitle().equalsIgnoreCase(addItemToCartModule.getModaltitle()));
            Assert.assertTrue(itemPage.getItemPrice().equalsIgnoreCase(addItemToCartModule.getModalPrice()));
        }
    }

    //Test Scenario 2:
    //Increase/Decrease the Quantity
    @Test(priority = 2,groups = "Item Page")
    public void quantityTest()
    {
        goToItemPageBySearch();
        int quantityBeforeUpdate = itemPage.getQuantity();
        System.out.println("Displayed Quantity in the Item Page: "+ quantityBeforeUpdate);
        itemPage.increaseQuantity();
        int quantityafterincrease = itemPage.getQuantity();
        Assert.assertTrue((quantityBeforeUpdate+1)==quantityafterincrease,
                "Quantity not Increased, Expected_value : " + (quantityBeforeUpdate+1)+"  Actual_Value : "+quantityafterincrease);

        itemPage.decreaseQuantity();
        int quantityafterdecrease = itemPage.getQuantity();
        Assert.assertTrue((quantityBeforeUpdate)==quantityafterdecrease,
                "Quantity not Decreased, Expected_value : " + (quantityBeforeUpdate)+"  Actual_Value : "+quantityafterdecrease);


    }

    //Test Scenario 3:
    //Check the review Stars, Review Link and product title is displayed.
    @Test(priority = 3,groups = "Item Page")
    public void visibilityTest()
    {
        Assert.assertTrue(itemPage.getproductTitle().contains(variableManager.searchString));
        Assert.assertTrue(itemPage.isVisibleReviewLink());
        Assert.assertTrue(itemPage.isVisibleReviewStars());
    }

}
