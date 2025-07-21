package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class LatestNewsPage extends SafeActionUmaxx5G {
	
	public void clickNavbarHamburger() {
	    String locator = "(//button[@class='navbar-toggler mx-3 btn-close-white'])[1]";
	    int extendedWait = LONGWAIT + 5; // Add extra time if navbar loads slowly

	    try {
	        safeExplicitWait(locator, extendedWait);         // Wait until element is present
	        scrollToElement(locator);                         // Optional: ensure visibility
	        safeClick(locator);                               // Click the button

	        Reporter.log("✅ Clicked on navbar hamburger button", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on navbar hamburger button");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on navbar hamburger: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on navbar hamburger: " + e.getMessage());
	        Assert.fail("Navbar hamburger click failed due to: " + e.getMessage());
	    }
	    
	    }
	public void clickLatestNews() {
	    String locator = "(//a[normalize-space()='Latest News'])[1]";
	    
	    try {
	        safeExplicitWait(locator, LONGWAIT);  // Wait for the element to be clickable
	        scrollToElement(locator);               // Scroll to it if necessary
	        safeClick(locator);                     // Perform the click

	        Reporter.log("✅ Clicked on 'Latest News' link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Latest News' link");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'Latest News': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Latest News': " + e.getMessage());
	        Assert.fail("Latest News click failed due to: " + e.getMessage());
	    }
	}
	public void verifyLatestNewsHeading() {
	    String latestNewsHeadingLoc = "//h1[normalize-space()='Latest News']";
	    String expectedHeading = "Latest News";

	    try {
	        safeExplicitWait(latestNewsHeadingLoc, NORAMALWAIT); // Wait for heading
	        String actualHeading = getText(latestNewsHeadingLoc).trim(); // Fetch and trim text

	        Assert.assertEquals(actualHeading, expectedHeading, "❌ Latest News heading does not match!");

	        Reporter.log("✅ Verified Latest News heading: " + actualHeading, true);
	        BasesetupUmaxx5G.passLog("✅ Verified Latest News heading: " + actualHeading);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify Latest News heading: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify Latest News heading: " + e.getMessage());
	        Assert.fail("Verification failed: " + e.getMessage());
	    }
	}

	public void verifyUmaxxLaunchArticleText() {
	    String articleLocator = "(//a[contains(text(),\"UMAXX Launches\")])[1]";
	    String partialExpectedText = "UMAXX Launches World"; // or longer if needed

	    try {
	        safeExplicitWait(articleLocator, LONGWAIT);
	        scrollToElement(articleLocator);
	        String actualText = getText(articleLocator).trim();

	        Assert.assertTrue(actualText.contains(partialExpectedText),
	            "❌ Article title does not contain expected text!");

	        Reporter.log("✅ Verified partial article text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified partial article text: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify article text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify article text: " + e.getMessage());
	        Assert.fail("Failed to verify article text due to: " + e.getMessage());
	    }
	}


	public void verifyLatestNewsArticleTitle() {
	    String locator = "(//a[contains(text(),\"SuperCloud International Bursts On The Scene With\")])[1]";
	    String expectedPartialText = "SuperCloud International Bursts On The Scene With The World";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        String actualText = getText(locator).trim();
	        String actualLower = actualText.toLowerCase();
	        String expectedLower = expectedPartialText.toLowerCase();

	        Assert.assertTrue(actualLower.contains(expectedLower),
	            "❌ Article title does not contain expected text!\nExpected: " + expectedPartialText + "\nFound: " + actualText);

	        Reporter.log("✅ Article title verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Article title verified: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying article title: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying article title: " + e.getMessage());
	        Assert.fail("❌ Exception occurred during verification: " + e.getMessage());
	    }
	}

	public void verifyRural5GHeadingText() {
	    String locator = "(//h1[@dir='ltr'])[1]";
	    String expectedText = "Understanding the Importance of 5G Internet in Rural Areas";

	    try {
	        safeExplicitWait(locator, LONGWAIT);         // Wait for element
	        scrollToElement(locator);                    // Scroll into view
	        String actualText = getText(locator).trim(); // Get actual text

	        Assert.assertEquals(actualText, expectedText,
	            "❌ Text mismatch!\nExpected: " + expectedText + "\nFound: " + actualText);

	        Reporter.log("✅ Heading text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Heading text verified: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify heading: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify heading: " + e.getMessage());
	        Assert.fail("Verification failed due to: " + e.getMessage());
	    }
	}

	
	public void clickUmaxxLaunchesWorldFirstArticle() {
	    String locator = "//div[@class='container latest-news-background']//li[1]//a[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);       // Wait for the element to be visible
	        scrollToElement(locator);                  // Scroll to the element to avoid interception
	        safeClick(locator);                        // Click the article link

	        Reporter.log("✅ Clicked on 'UMAXX Launches World's First...' article link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'UMAXX Launches World's First...' article link");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'UMAXX Launches World's First...' article: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'UMAXX Launches World's First...' article: " + e.getMessage());
	        Assert.fail("Click failed on 'UMAXX Launches World's First...' article: " + e.getMessage());
	    }
	}


	public void clickThirdLatestNewsLink() {
	    String locator = "//div[@class='container latest-news-background']//li[3]//a";

	    try {
	        safeExplicitWait(locator, LONGWAIT);            // Wait for visibility
	        scrollToElement(locator);                       // Scroll to element

	        WebElement link = driver.findElement(By.xpath(locator));

	        // Use JavaScript click to bypass overlay issues
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

	        Reporter.log("✅ Clicked on 3rd Latest News link using JS click", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 3rd Latest News link using JS click");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click 3rd Latest News link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click 3rd Latest News link: " + e.getMessage());
	        Assert.fail("Click on 3rd Latest News link failed due to: " + e.getMessage());
	    }
	}
	
	public void switchToNewWindowAndCloseIt() {
	    try {
	        String originalWindow = driver.getWindowHandle();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(d -> d.getWindowHandles().size() > 1);

	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);

	                Reporter.log("🔄 Switched to new window: " + driver.getTitle(), true);
	                BasesetupUmaxx5G.passLog("🔄 Switched to new window: " + driver.getTitle());

	                driver.close();

	                Reporter.log("❎ Closed the new window", true);
	                BasesetupUmaxx5G.passLog("❎ Closed the new window");

	                break;
	            }
	        }

	        driver.switchTo().window(originalWindow);

	        Reporter.log("🔙 Switched back to original window", true);
	        BasesetupUmaxx5G.passLog("🔙 Switched back to original window");

	    } catch (Exception e) {
	        Reporter.log("❌ Window handling failed: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Window handling failed: " + e.getMessage());
	        Assert.fail("Window handling failed: " + e.getMessage());
	    }
	}
	public void clickSecondLatestNewsLink() {
	    String locator = "//div[@class='container latest-news-background']//li[2]//a";

	    try {
	        safeExplicitWait(locator, LONGWAIT);             // Wait for element
	        scrollToElement(locator);                         // Scroll into view

	        WebElement link = driver.findElement(By.xpath(locator));

	        // Click using JavaScript to avoid overlay/intercept issues
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

	        Reporter.log("✅ Clicked on 2nd Latest News link using JS click", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 2nd Latest News link using JS click");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click 2nd Latest News link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click 2nd Latest News link: " + e.getMessage());
	        Assert.fail("Click on 2nd Latest News link failed due to: " + e.getMessage());
	    }
	}

	public void clickFirstLatestNewsLink() {
	    String locator = "//div[@class='container latest-news-background']//li[1]//a";

	    try {
	        safeExplicitWait(locator, LONGWAIT);             // Wait until visible
	        scrollToElement(locator);                         // Scroll into view

	        WebElement link = driver.findElement(By.xpath(locator));

	        // Click using JavaScript (bypasses click issues like overlays)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

	        Reporter.log("✅ Clicked on 1st Latest News link using JS click", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 1st Latest News link using JS click");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click 1st Latest News link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click 1st Latest News link: " + e.getMessage());
	        Assert.fail("Click on 1st Latest News link failed due to: " + e.getMessage());
	    }
	}




	
}
