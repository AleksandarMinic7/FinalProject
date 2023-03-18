package utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class Utils {
    private static WebDriver driver;

    private static String browser = Utils.dotEnv().get("BROWSER", "chrome");

//    public static WebDriver getDriver(){
//        if (browser.equalsIgnoreCase("chrome")){
//            ChromeOptions co = new ChromeOptions();
//            co.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(co);
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        }
//
//        Utils.waitForSeconds(3);
//        driver.manage().window().maximize();
//        return driver;
//    }
    public static void waitForSeconds(double seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Dotenv dotEnv(){
        return Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    @DataProvider(name = "dpLoginTest")
    public static Object[][] dpLoginTest(){
        return new Object[][]{
                {"marko@email.com", "sadadad"},
                {"ivan@email.com", "admin!"},
                {"djordjeilic@email.com", "3424134231413243"}
        };
    }
}
