package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class WishlistPage extends BasePage{

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By signInButton = By.cssSelector("a[data-test='nav-sign-in']");
    private By homeButton = By.cssSelector("a[class*='nav-link active']");
    private By productNameButton = By.cssSelector("a[data-test*='2'] h5[class*='card-title']");
    private By addToFavouritesButton = By.xpath("//button[@id='btn-add-to-favorites']");
    private By userMenuButton = By.xpath("//a[@id='user-menu']");
    private By myFavourites = By.xpath("//a[@routerlink='/account/favorites']");
    private By productInFavourites = By.xpath("//div[@data-test='favorite-2']//h5");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public WishlistPage goToLoginForm(){
        clickOnElement(signInButton);
        return this;
    }
        public WishlistPage fillInTheForm() {
        typeIn(emailField, "markojovic414@email.com");
        typeIn(passwordField, "lozinka123");
        clickOnElement(loginButton);
        return this;
    }

    public WishlistPage goToHomepage(){
        Utils.waitForSeconds(1.5);
        clickOnElement(homeButton);
        return this;
    }

    public WishlistPage getProductTextName(){
        Utils.waitForSeconds(1.5);

        getTextFromElement(productNameButton);


        return this;
    }
    public WishlistPage goToProduct(){
        hoverAndClick(productNameButton);
        return this;
    }

    public WishlistPage addToFavourites(){
        clickOnElement(addToFavouritesButton);
        return this;
    }

    public WishlistPage goToFavourites(){
        hoverAndClick(userMenuButton);
        Utils.waitForSeconds(2);
        hoverAndClick(myFavourites);
        return this;
    }

    public WishlistPage getProductName(){
         getTextFromElement(productNameButton);
        return this;
    }

    public WishlistPage getFavouritesProductName(){
        getTextFromElement(productInFavourites);
        return this;
    }
    public WishlistPage verifyNameOnHomepage(){
        matchesExpectedText(productNameButton, "Pliers");

            return this;


    }

    public WishlistPage verifyNameInFavourites() {
        matchesExpectedText(productInFavourites, "Pliers");
        return this;
    }

}
