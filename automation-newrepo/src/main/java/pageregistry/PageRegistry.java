package pageregistry;

import com.walmart.Pages.HomePage;
import com.walmart.Pages.ItemPage;
import com.walmart.Pages.SearchResultsPage;
import modules.AddItemToCartModule;
import org.fluentlenium.adapter.FluentAdapter;
import org.fluentlenium.core.annotation.Page;

public class PageRegistry extends FluentAdapter{


    @Page
    public HomePage homePage;

    @Page
    public ItemPage itemPage;

    @Page
    public SearchResultsPage searchResultsPage;

    @Page
    public AddItemToCartModule addItemToCartModule;

}
