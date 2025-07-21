
package common;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasesetupUmaxx5G {

    public static WebDriver driver;
    ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        String browser = ConfigReaderUmaxx5G.getKeyValue("BROWSERNAME");
        System.out.println("Browser Selected: " + browser);

        switch (browser.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;

            case "FF":
                driver = new FirefoxDriver();
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser specified in config: " + browser);
        }

        driver.get(ConfigReaderUmaxx5G.getKeyValue("URL"));
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Setup Extent Report
        ExtentSparkReporter reporter = new ExtentSparkReporter("UmaxxPhonePage.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Automation Test Report");
        reporter.config().setReportName("Umaxx Test Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Tester", "Shishupal");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        extentTest = extentReports.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method) throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + method.getName() + ".png");
        dest.getParentFile().mkdirs(); // Ensure the folder exists
        FileHandler.copy(src, dest);

        extentTest.info("Final Screenshot:",
                MediaEntityBuilder.createScreenCaptureFromPath(dest.getPath()).build());
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();

        if (driver != null) {
            driver.quit();
        }
    }

    // Logging helper methods
    public static void setDes(String des) {
        extentTest.getModel().setDescription(des);
    }

    public static void passLog(String steps) {
        extentTest.log(Status.PASS, steps);
    }

    public static void failLog(String steps) {
        extentTest.log(Status.FAIL, steps);
    }

    public static void warningLog(String steps) {
        extentTest.log(Status.WARNING, steps);
    }

    public static void infoLog(String steps) {
        extentTest.log(Status.INFO, steps);
    }

    public static void skipLog(String steps) {
        extentTest.log(Status.SKIP, steps);
    }
}
