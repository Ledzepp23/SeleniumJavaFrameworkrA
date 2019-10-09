package demo;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;



public class FluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    static String projectPath = System.getProperty("user.dir");

    public static void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("ABCD");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);



        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
                if(element.isEnabled()) {
                    System.out.println("element found");
                }
                return element;
            }
        });

        element.click();

        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
