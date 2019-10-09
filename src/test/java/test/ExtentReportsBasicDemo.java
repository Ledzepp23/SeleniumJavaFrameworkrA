package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class ExtentReportsBasicDemo {

    private static WebDriver driver = null;

    public void runTest() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReporter.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test1 = extent.createTest("My first test", "Sample description");

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        test1.log(Status.INFO, "Starting Test Case");
        driver.get("https://google.com");
        test1.pass("Navigated to google.com");
        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
        GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);

        driver.close();
        test1.info("Test Completed");

        extent.flush();
    }
}
