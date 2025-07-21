package pages;

import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class UmaxxStorePage extends SafeActionUmaxx5G{
	
	  String navbarToggleLoc = "//span[@class='navbar-toggler-icon']";

	    public void clickNavbarToggle() {
	        safeExplicitWait(navbarToggleLoc, LONGWAIT);
	        scrollToElementWithOffset(navbarToggleLoc, -100); // scroll slightly up if needed
	        safeClick(navbarToggleLoc);

	        Reporter.log("✅ Clicked the Navbar Toggle button", true);
	        BasesetupUmaxx5G.infoLog("✅ Clicked the Navbar Toggle button");
	    }
	    public void clickUmaxxStoreLink() {
	        String locator = "(//a[normalize-space()='UMAXX Store'])[1]";

	        try {
	            safeExplicitWait(locator, NORAMALWAIT);         // Wait until element is visible
	            scrollToElement(locator);                        // Scroll into view
	            safeClick(locator);                              // Click the link

	            Reporter.log("✅ Clicked on 'UMAXX Store'", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'UMAXX Store'" + locator);

	        } catch (Exception e) {
	            Reporter.log("❌ Failed to click on 'UMAXX Store': " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Click on 'UMAXX Store' failed: " + e.getMessage());
	            Assert.fail("Click action failed for 'UMAXX Store': " + e.getMessage());
	        }
	    }
	    
	    public void switchToNewWindow() {
	        String originalWindow = driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();

	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	    }

	    
	    public void verifyAnnouncementBarText() {
	        String locator = "//p[contains(@class, 'announcement-bar__message') and contains(text(), 'Join the UMAXX Revolution')]";
	        String expectedText = "Join the UMAXX Revolution get 20% off all merch";

	        try {
	            Thread.sleep(2000); // TEMP debug wait
	            scrollToElement(locator); // Ensure it's in view
	            safeExplicitWait(locator, LONGWAIT);

	            String actualText = getText(locator).trim();

	            Assert.assertEquals(actualText, expectedText, "❌ Announcement bar text does not match!");

	            Reporter.log("✅ Announcement bar text verified: " + actualText, true);
	            BasesetupUmaxx5G.passLog("✅ Announcement bar text verified: " + actualText);

	        } catch (Exception e) {
	            Reporter.log("❌ Failed to verify announcement bar text: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to verify announcement bar text: " + e.getMessage());
	            Assert.fail("❌ Text verification failed for Announcement Bar: " + e.getMessage());
	        }
	    }

	    public void verifyWelcomeMerchandiseHeading() {
	        String locator = "//h2[normalize-space()='Welcome 2 UMAXX Merchandise']";
	        String expectedText = "Welcome 2 UMAXX Merchandise";

	        try {
	            scrollToElement(locator); // Ensure it's in view
	            safeExplicitWait(locator, LONGWAIT); // Wait for visibility

	            String actualText = getText(locator).trim(); // Fetch text

	            Assert.assertEquals(actualText, expectedText, "❌ Heading text does not match!");

	            Reporter.log("✅ Verified heading text: " + actualText, true);
	            BasesetupUmaxx5G.passLog("✅ Verified heading text: " + actualText);

	        } catch (Exception e) {
	            Reporter.log("❌ Failed to verify heading text: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to verify heading text: " + e.getMessage());
	            Assert.fail("❌ Text verification failed: " + e.getMessage());
	        }
	    }


}
