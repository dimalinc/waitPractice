import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class testCucumberPromocode {
    WebDriver driver;


    @Test
    public void Test1() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().setPosition(new Point(1400,0));
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //explicit wait
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement((By.cssSelector("button.promoBtn"))).click();

        //explicit wait
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());;


/*
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}
*/

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
