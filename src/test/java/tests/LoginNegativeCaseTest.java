package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.Utils;

public class LoginNegativeCaseTest extends BaseTest {


    WebElement element;
    LoginPage loginPage;


    @BeforeMethod
    public void localSetup(){

        loginPage = new LoginPage(driver);
    }


//    @Test
//    public void loginUser(){
//        loginPage.goToLoginForm()
//                .fillInTheForm()
//                .submitLogin();
//
//    }


    @Test
    public void invalidLogin(){
        loginPage.goToLoginForm()
                    .submitLogin();

        Assert.assertTrue(loginPage.textsMatching(), "Test pao, tekstovi se ne poklapaju.");

    }

    // test sa dataProviders

    @Test(dataProvider = "dpLoginTest", dataProviderClass = Utils.class)
    public void dpLoginAndInvalidError(String email, String password){
        loginPage.goToLoginForm()
                .loginUser(email, password)
                .submitLogin();

        Assert.assertTrue(loginPage.invalidTextMatching(), "Test pao, tekst se ne poklapa.");


    }

}
