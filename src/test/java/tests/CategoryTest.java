package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import utils.Utils;

import javax.swing.text.Document;

public class CategoryTest extends BaseTest{
    WebElement element;
    CategoryPage categoryPage;


    @BeforeMethod
    public void localSetup(){

        categoryPage = new CategoryPage(driver);
    }

    @Test
    public void chooseAndVerify(){
        categoryPage.goToLoginForm()
                        .fillInTheForm()
                         .goToPowerTools()
                          .itemCounter();
        Utils.waitForSeconds(2);
        categoryPage.chooseDrillBox()
                            .itemCounterAfterFilter();
        Utils.waitForSeconds(2);
        categoryPage.verifyNumberOfItems();
    }
}
