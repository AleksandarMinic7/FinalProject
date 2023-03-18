package pages;

import com.github.javafaker.Cat;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Utils;

import java.sql.SQLOutput;
import java.util.List;

public class CategoryPage extends BasePage{



    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By signInButton = By.cssSelector("a[data-test='nav-sign-in']");
    private By categoriesButton = By.xpath("//a[@data-test='nav-categories']");
    private By powerToolsButton = By.xpath("//a[@data-test='nav-power-tools']");
    private By drillCheckbox = By.xpath("//input[@data-test='category-11']");
    private By container = By.cssSelector("a[data-test*='product']");
    private By filteredContainer = By.cssSelector("div[class='col-md-9'] a");                  //("a[data-test*='product']");
    private int filteredElementsCount;
    private int elementsCount;


    public CategoryPage(WebDriver driver) {
        super(driver);
    }




    public CategoryPage goToLoginForm(){
        clickOnElement(signInButton);
        return this;
    }
    public CategoryPage fillInTheForm() {
        typeIn(emailField, "markojovic414@email.com");
        typeIn(passwordField, "lozinka123");
        clickOnElement(loginButton);
        return this;
    }

    public CategoryPage goToPowerTools(){
        Utils.waitForSeconds(2);
        clickOnElement(categoriesButton);
        hoverAndClick(powerToolsButton);
        Utils.waitForSeconds(1);
        return this;
    }

    public CategoryPage itemCounter() {
        List<WebElement> elementsBefore = driver.findElements(container);
        elementsCount = elementsBefore.size();
        System.out.println("Total Number of Elements : " + elementsCount);
        return this;
    }

    public CategoryPage chooseDrillBox(){
        WebElement element = driver.findElement(By.xpath("//input[@data-test='category-11']"));
        if(element.isDisplayed() && element.isEnabled()){
            element.click();
        }
        return this;
    }

    public CategoryPage itemCounterAfterFilter() {
        Utils.waitForSeconds(2);
        List<WebElement> elementsAfter = driver.findElements(filteredContainer);
        filteredElementsCount = elementsAfter.size();
        System.out.println("Total Number of Elements : " + filteredElementsCount);
        return this;
    }

    public  CategoryPage verifyNumberOfItems(){
        if(filteredElementsCount < elementsCount) {
            System.out.println("Broj item-a manji nakon filtera.");
            return this;
        } else {
            System.out.println("Broj item-a nije manji nakon filtera.");
            return this;
        }
    }




















}
