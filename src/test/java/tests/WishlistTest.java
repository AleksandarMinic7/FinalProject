package tests;

import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import pages.WishlistPage;
import utils.Utils;

public class WishlistTest extends BaseTest{

    WebElement element;

    WishlistPage wishlistPage;


    @BeforeMethod
    public void localSetup(){

        wishlistPage = new WishlistPage(driver);
    }

    @Test
    public void moveToWishlist() {
        wishlistPage.goToLoginForm()
                .fillInTheForm()
                 .goToHomepage()
                  .getProductTextName()
                   .verifyNameOnHomepage()
                    .goToProduct()
                     .addToFavourites()
                      .goToFavourites()
                       .verifyNameInFavourites();
    }
}
