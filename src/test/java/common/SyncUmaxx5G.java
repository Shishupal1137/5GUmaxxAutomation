package common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncUmaxx5G extends ConstantVariableUmaxx5G {
    public static WebDriver driver;

    public SyncUmaxx5G() {
        // Assign driver from BaseSetup class
        this.driver = BasesetupUmaxx5G.driver;
    }

    // Hard wait (not recommended in real frameworks, use for quick delay/testing only)
    public void needToWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Implicit wait using Selenium 4+ Duration API
    public void safeImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // Explicit wait for visibility of element using xpath
    public void safeExplicitWait(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // Fluent wait (customized polling and timeout)
    public void safeFluentWait(String locator, int maxTimeoutSeconds, int pollingEverySeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(maxTimeoutSeconds))
            .pollingEvery(Duration.ofSeconds(pollingEverySeconds))
            .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
