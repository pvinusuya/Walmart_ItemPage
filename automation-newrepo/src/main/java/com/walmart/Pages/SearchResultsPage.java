package com.walmart.Pages;

import org.fluentlenium.core.domain.FluentList;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

    public void selectrandomItem()
    {
        FluentList searchResults = find(By.xpath(".//*[@id='shelf-thumbs']/div/article"));
        System.out.println("Number of items displayed in search results: " + searchResults.size());
        if (searchResults.size() != 0)
        {
            find(By.xpath(".//*[@id='shelf-thumbs']/div/article[1]")).click();
            await().untilPage().isLoaded();
        }
    }
}
