package tests;

import jdk.jshell.execution.Util;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.LoginPage;
import utils.Utils;

public class BasketTest extends BaseTest{



    WebElement element;
    BasketPage basketPage;


    @BeforeMethod
    public void localSetup(){

        basketPage = new BasketPage(driver);
    }

    @Test
    public void finalizePurchase(){
        basketPage.goToLoginForm()
                   .fillInTheForm()
                    .goToHomePage()
                     .addProductsToCart()
                      .verifyNumberOfProductsInCart()
                       .goToCart()
                        .finalSum()
                         .proceedWithThePurchase()
                          .choosePaymentMethod()
                           .verifyThePurchase()
                            .finishThePurchase();



    }

}
