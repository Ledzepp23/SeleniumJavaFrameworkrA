package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
    public static void main(String[] args) {
        googleSearch();
    }

    private static void googleSearch() {

        WebDriver driver = null;

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("https://google.com");
        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
        GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);



        driver.close();
        System.out.println("test completed successfully");
    }

}
