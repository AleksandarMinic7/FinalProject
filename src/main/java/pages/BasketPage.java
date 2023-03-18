package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;



public class BasketPage extends BasePage {


    private By signInButton = By.cssSelector("a[data-test='nav-sign-in']");
    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By homeButton = By.xpath("//a[@data-test='nav-home' and contains(text(), 'Home')]");
    private By product1 = By.cssSelector("a[data-test*='2'] h5[class*='card-title']");
    private By plusButton = By.xpath("//button[@id='btn-increase-quantity']");
    private By addToCartButton = By.xpath("//button[@id='btn-add-to-cart']");
    private By product2 = By.cssSelector("a[data-test*='7'] h5[class*='card-title']");
    private By cartBubble = By.xpath("//span[@id='lblCartCount']");
//    private By product1FinalPrice = By.xpath("//td[@class='col-md-2 align-middle']//following-sibling::td//following-sibling::td");
    private By product1FinalPrice = By.xpath("(//td[@class='col-md-2 align-middle'])[3]");
    private By product2FinalPrice = By.xpath("(//td[@class='col-md-2 align-middle'])[6]");
    private By totalPrice = By.xpath("(//td[@class='col-md-2'])[6]");
    private By goToCartButton = By.xpath("//a[@data-test='nav-cart']");
    private By proceedButton = By.xpath("//button[@data-test='proceed-1']");
    private By proceedButton2 = By.xpath("//button[@data-test='proceed-2']");
    private By proceedButton3 = By.xpath("//button[@data-test='proceed-3']");
    Select se;
    private By accName = By.xpath("//input[@id='account-name']");
    private By  accNumber = By.xpath("//input[@id='account-number']");
    private By finishButton = By.xpath("//button[@data-test='finish']");
    private By verifyPayment = By.xpath("//div[@class='help-block']");


    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public BasketPage goToLoginForm() {
        clickOnElement(signInButton);
        return this;
    }

    public BasketPage fillInTheForm() {
        typeIn(emailField, "markojovic747@email.com");
        typeIn(passwordField, "lozinka123");
        clickOnElement(loginButton);
        return this;
    }
//    public BasketPage submitLogin(){
//        clickOnElement(loginButton);
//        return this;
//    }

    public BasketPage goToHomePage() {
        clickOnElement(homeButton);
        return this;
    }

    public BasketPage addProductsToCart() {
        clickOnElement(product1);
        clickOnElement(plusButton);
        clickOnElement(addToCartButton);
        clickOnElement(homeButton);
        clickOnElement(product2);
        clickOnElement(addToCartButton);
        return this;
    }

    public BasketPage verifyNumberOfProductsInCart() {
        String a = getTextFromElement(cartBubble);
        System.out.println("Broj artikala u korpi je: " + a);
        Assert.assertEquals(a, "3");
        return this;
    }

    public BasketPage goToCart(){
        clickOnElement(goToCartButton);
        return this;
    }

    public BasketPage finalSum() {
        String cena1 = getTextFromElement(product1FinalPrice); //.split("^[0-9]",4));
        String cena2 = getTextFromElement(product2FinalPrice);
        String ukupnaCena = getTextFromElement(totalPrice);
        double d1 = Double.parseDouble(cena1.replaceAll("[^\\d.]", ""));
        double d2 = Double.parseDouble(cena2.replaceAll("[^\\d.]", ""));
        double finalnaCena = Double.parseDouble(ukupnaCena.replaceAll("[^\\d.]", ""));

        double zbirCena = d1 + d2;

        System.out.println("Cena prvog artikla/artikala: $" + d1);
        System.out.println("Cena prvog artikla/artikala: $" + d2);
        System.out.println("Cena svih artikala: $" + zbirCena);
        System.out.println("Krajnji racun: $" + finalnaCena);


        Assert.assertTrue(finalnaCena == zbirCena, "Test pao, finalna cena nije jednaka zbirnoj ceni proizvoda!");
        return this;
    }

    public BasketPage proceedWithThePurchase(){
        clickOnElement(proceedButton);
        clickOnElement(proceedButton2);
        clickOnElement(proceedButton3);
        return this;
    }

    public BasketPage choosePaymentMethod (){
        se = new Select(driver.findElement(By.xpath("//select[@id='payment-method']")));
        se.selectByValue("3: Credit Card");
        typeIn(accName,"Marko Jovic");
        typeIn(accNumber, "548312156454");
        clickOnElement(finishButton);
        return this;
    }

    public BasketPage verifyThePurchase(){
        Assert.assertEquals(getTextFromElement(verifyPayment), "Payment was successful");
        return this;
    }

    public BasketPage finishThePurchase(){
        clickOnElement(finishButton);
        return this;
    }
}
