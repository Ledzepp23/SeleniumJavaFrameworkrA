package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.GoogleSearchPage;

public class DesiredCapabilitiesDemo {
    public static void main(String[] args) {
        googleSearch();
    }

    private static void googleSearch() {

        WebDriver driver = null;

        String projectPath = System.getProperty("user.dir");

    //    DesiredCapabilities caps = new DesiredCapabilities();
    //    caps.setCapability("ignoreProtectedModeSettings", true);

        System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();


        driver.get("https://google.com");
        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
        GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);



        driver.close();
        System.out.println("test completed successfully");
    }

}
