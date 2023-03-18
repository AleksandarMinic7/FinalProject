package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage{

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By signInButton = By.cssSelector("a[data-test='nav-sign-in']");
//    private By userNameInMenu = By.id("user-menu");
    private By requiredEmail = By.xpath("//div[@data-test='email-error']//div");
    private By requiredPassword = By.xpath("//div[@data-test='password-error']//div");

    private By invalidEmailOrPassword = By.cssSelector(".alert-danger .help-block");

    public LoginPage(WebDriver driver) {
        super(driver);
    }




    public LoginPage goToLoginForm(){
        clickOnElement(signInButton);
        return this;
    }

//    public LoginPage fillInTheForm (){
//        typeIn(emailField, "markojovic123@email.com");
//        typeIn(passwordField, "lozinka123!");
//        return this;
//    }
    public LoginPage submitLogin(){
        clickOnElement(loginButton);
        return this;
    }





    public LoginPage loginUser(String email, String password){
        typeIn(emailField, email);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }

    protected boolean isElementVisible(By locator){
        List<WebElement> list = driver.findElements(locator);
        if (!list.isEmpty() && (list.get(0)!=null)){
            return list.get(0).isDisplayed();
        }
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return false;
    }

//    public boolean emailRequired(){
//        String actualEmailTextError[] = getTextFromElement(requiredEmail).split("(?<=.)");
//        String actualEmailText = actualEmailTextError [0];
//
//        String emailFieldExpectedText = "E-mail is required.";
//        String actual[] = getTextFromElement(requiredEmail).split("(?<=.)");
//
//
//
//        return actualEmailText.equals(emailFieldExpectedText);
//    }
//
//    public boolean passwordRequired(){
//        String actualPasswordTextError[] = getTextFromElement(requiredPassword).split("(?<=.)");
//        String actualPasswordText = actualPasswordTextError [0];
//
//        String passwordFieldExpectedText = "Password is required.";
//        String actual[] = getTextFromElement(requiredPassword).split("(?<=.)");
//
//
//
//        return actualPasswordText.equals(passwordFieldExpectedText);
//
//    }

    public boolean textsMatching(){
        matchesExpectedText(requiredEmail, "E-mail is required.");
        matchesExpectedText(requiredPassword, "Password is required.");
        return true;
    }


    public boolean invalidTextMatching(){
        matchesExpectedText(invalidEmailOrPassword, "Invalid email or password");
        return true;
    }




}
