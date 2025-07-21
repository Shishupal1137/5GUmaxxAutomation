package common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

public class SafeActionUmaxx5G extends SyncUmaxx5G {
    public WebDriver driver = BasesetupUmaxx5G.driver; // Set driver globally

    public void safeClick(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Element not found or not clickable: " + locator + " | Error: " + e.getMessage());
        }
    }

    public void safeType(String locator, String value) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(value);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unable to type in element: " + locator + " | Error: " + e.getMessage());
        }
    }

    public void safeClear(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            element.clear();
            Thread.sleep(1000);

            if (!element.getAttribute("value").isEmpty()) {
                element.sendKeys(Keys.CONTROL + "a");
                element.sendKeys(Keys.BACK_SPACE);
            }

            System.out.println("Successfully cleared text field: " + locator);
        } catch (Exception e) {
            System.out.println("Unable to clear text field: " + locator + " | Error: " + e.getMessage());
        }
    }

    public boolean safeIsDisplayed(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Unable to check if element is displayed: " + locator + " | Error: " + e.getMessage());
            return false;
        }
    }

    public boolean safeIsEnabled(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isEnabled();
        } catch (Exception e) {
            System.out.println("Unable to check if element is enabled: " + locator + " | Error: " + e.getMessage());
            return false;
        }
    }

    public boolean safeIsSelected(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isSelected();
        } catch (Exception e) {
            System.out.println("Unable to check if element is selected: " + locator + " | Error: " + e.getMessage());
            return false;
        }
    }

    public String getText(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text from element: " + locator + " | Error: " + e.getMessage());
            return "";
        }
    }

    public String getAttribute(String locator, String attribute) {
        try {
            return driver.findElement(By.xpath(locator)).getAttribute(attribute);
        } catch (Exception e) {
            System.out.println("Unable to get attribute '" + attribute + "' from element: " + locator + " | Error: " + e.getMessage());
            return "";
        }
    }

    public void selectByIndex(String locator, int index) {
        try {
            driver.findElements(By.xpath(locator)).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to select element at index " + index + ": " + locator + " | Error: " + e.getMessage());
        }
    }

    // ---------- SCROLLING METHODS ----------

    public void scrollDown(int pixels) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll down by " + pixels + " pixels | Error: " + e.getMessage());
        }
    }

    public void scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to bottom | Error: " + e.getMessage());
        }
    }

    public void scrollToElement(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element: " + locator + " | Error: " + e.getMessage());
        }
    }

    public void scrollUp(int pixels) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -" + pixels + ")");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll up by " + pixels + " pixels | Error: " + e.getMessage());
        }
    }

    public void scrollToTop() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to top | Error: " + e.getMessage());
        }
    }
    
    public void scrollToElementWithOffset(String locator, int yOffset) {
        try {
            WebElement element = BasesetupUmaxx5G.driver.findElement(By.xpath(locator));
            int y = element.getLocation().getY() + yOffset;
            ((JavascriptExecutor) BasesetupUmaxx5G.driver).executeScript("window.scrollTo(0, arguments[0]);", y);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error while scrolling to element with offset: " + e.getMessage());
        }
    }

    public boolean isElementPresent(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void switchToNewWindowAndCloseIt(String currentWindow, int existingWindowsCount) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> driver.getWindowHandles().size() > existingWindowsCount);

            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(currentWindow)) {
                    driver.switchTo().window(windowHandle);
                    Reporter.log("🔁 Switched to new window/tab", true);
                    BasesetupUmaxx5G.infoLog("🔁 Switched to new window/tab");
                    break;
                }
            }

            Thread.sleep(2000); // Adjust based on invoice/document load time
            driver.close(); // Close the document window/tab

            Reporter.log("❎ Closed new window/tab", true);
            BasesetupUmaxx5G.passLog("❎ Closed new window/tab");

            driver.switchTo().window(currentWindow);
            Reporter.log("🔙 Switched back to main window", true);
            BasesetupUmaxx5G.infoLog("🔙 Switched back to main window");

        } catch (Exception e) {
            Reporter.log("❌ Exception during window switch: " + e.getMessage(), true);
            BasesetupUmaxx5G.failLog("❌ Exception during window switch: " + e.getMessage());
            Assert.fail("Window switch/close failed: " + e.getMessage());
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }


}
