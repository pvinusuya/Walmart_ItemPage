package modules;

import com.walmart.Pages.BasePage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class AddItemToCartModule extends BasePage{

    @FindBy(css = "#atc-root")
    private FluentWebElement cartpopupwindow;

    @FindBy(css = "div[data-automation=atcmodal-title]")
    private FluentWebElement atcmodalTitle;

    @FindBy(css = "span[data-automation=atcmodal-price]")
    private FluentWebElement atcmodalPrice;

    public Boolean setCartpopupwindowDisplayed()
    {
        if(cartpopupwindow.isDisplayed());
        return true;
    }

    public String getModaltitle()
    {
        String title = atcmodalTitle.getText();
        return title;
    }

    public String getModalPrice()
    {
        String title = atcmodalPrice.getText();
        return title;
    }

}
