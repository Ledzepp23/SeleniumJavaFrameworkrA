package test;

import config.PropertiesFile;
import demo.Log4jDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo {

    WebDriver driver = null;
    public static String browserName = null;
    private static Logger logger = LogManager.getLogger(Log4jDemo.class);

    @BeforeTest
    public void setUpTest() {
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();

        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }


    }

    @Test
    public void googleSearch() {

        //goto google.com
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

    }

    @AfterTest
    public void tearDownTest() {
        driver.close();
        //driver.quit();
        System.out.println("test completed successfully");
    }

}
