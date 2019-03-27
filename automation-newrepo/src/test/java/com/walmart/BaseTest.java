package com.walmart;


import manager.VariableManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageregistry.PageRegistry;

public abstract class BaseTest extends PageRegistry{

    WebDriver driver;
    VariableManager variableManager = new VariableManager();
    @BeforeClass(alwaysRun = true)
    public void setWebdriver()
    {
        if (variableManager.browser.contains("Chrome"))

        {
            System.setProperty("webdriver.chrome.driver","/Users/palaniv/Documents/temp/driver/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        driver.get(variableManager.url);
        initFluent(driver);
        init();
    }
    @AfterClass(alwaysRun = true)
    public void teardown()
    {
        driver.close();
        driver.quit();
    }



}
