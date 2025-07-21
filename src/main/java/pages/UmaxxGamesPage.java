package pages;

import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class UmaxxGamesPage extends SafeActionUmaxx5G{
	
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
	
	public void clickOnGamesSectionAndSwitchWindow() {
	    String locator = "(//a[normalize-space()='Games'])[1]";

	    try {
	        // Store original window handle
	        String originalWindow = driver.getWindowHandle();

	        scrollToElement(locator); // Scroll to make the element visible
	        safeExplicitWait(locator, NORAMALWAIT); // Wait for element
	        safeClick(locator); // Click on "Games"

	        Reporter.log("✅ Clicked on 'Games' section: " + locator, true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Games' section");

	        // Wait for new window and switch
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(originalWindow)) {
	                driver.switchTo().window(window);
	                Reporter.log("✅ Switched to new window after clicking 'Games'", true);
	                BasesetupUmaxx5G.passLog("✅ Switched to new window: " + window);
	                break;
	            }
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click or switch window for 'Games' section: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed on 'Games' click/switch: " + e.getMessage());
	        Assert.fail("❌ Error while handling 'Games' section navigation");
	    }
	}

	String gamesSectionLinkLoc = "(//a[normalize-space()='Games'])[1]";

	public void clickGamesSectionAndWorkInNewWindow() {
	    try {
	        String originalWindow = driver.getWindowHandle();

	        // Click on the Games link (opens a new window/tab)
	        safeExplicitWait(gamesSectionLinkLoc, LONGWAIT);
	        safeClick(gamesSectionLinkLoc);

	        // Wait for new window to open and switch to it
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(originalWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }

	        Reporter.log("✅ Switched to Games window/tab", true);
	        BasesetupUmaxx5G.infoLog("✅ Switched to Games window/tab");

	        String newTitle = driver.getTitle();
	        Reporter.log("🎯 Games Window Title: " + newTitle, true);
	        BasesetupUmaxx5G.infoLog("🎯 Games Window Title: " + newTitle);

	        // 👉 Continue working here without closing the Games window

	    } catch (Exception e) {
	        BasesetupUmaxx5G.failLog("❌ Failed to switch to Games window: " + e.getMessage());
	        Assert.fail("❌ Failed to switch to Games window: " + e.getMessage());
	    }
	}


	
	String playCompeteRedeemTextLoc = "(//p[@class='text-base font-medium text-center font-body mb-2 px-2 darklight_fontcol'])[1]";
	String expectedText = "Play | Compete | Redeem";

	public void verifyPlayCompeteRedeemText() {
	    try {
	        safeExplicitWait(playCompeteRedeemTextLoc, LONGWAIT);
	        scrollToElement(playCompeteRedeemTextLoc);

	        String actualText = getText(playCompeteRedeemTextLoc).trim();

	        Reporter.log("📝 Text Found: " + actualText, true);
	        BasesetupUmaxx5G.infoLog("📝 Text Found: " + actualText);

	        Assert.assertEquals(actualText, expectedText, "❌ Text mismatch on Games section!");

	        Reporter.log("✅ Verified: 'Play | Compete | Redeem' text is correct", true);
	        BasesetupUmaxx5G.infoLog("✅ Verified: 'Play | Compete | Redeem' text is correct");

	    } catch (Exception e) {
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying 'Play | Compete | Redeem' text: " + e.getMessage());
	        Assert.fail("❌ Exception while verifying 'Play | Compete | Redeem' text: " + e.getMessage());
	    }
	}

	


}
