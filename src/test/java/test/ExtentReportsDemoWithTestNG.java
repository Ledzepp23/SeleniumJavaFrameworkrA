package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReportsDemoWithTestNG {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;


    @BeforeTest
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void test1() throws IOException {
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        test.log(Status.INFO, "This step shows usage of log(status, details)");


        test.info("This step shows usage of info(details)");


        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());


        test.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

}
