package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
      // 1. Set up the Chrome browser
    static String browser = "Chrome";
      // 2 .Open URL
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
         driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        //giving implicit wait to driver by using the implicit method
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        // 4. Print the Current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // 5. Print the Page source
        System.out.println("Page source: " + driver.getPageSource());

        // 6. Enter the email into the email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("mvthakur2011@gmail.com");

        // 7. Enter the password field into the password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("Mv123");

        // 8. Close the browser
        driver.close();

    }
}
