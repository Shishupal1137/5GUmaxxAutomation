package pages;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class UmaxxAboutPage extends SafeActionUmaxx5G{
	
	  String navbarToggleLoc = "//span[@class='navbar-toggler-icon']";

	    public void clickNavbarToggle() {
	        safeExplicitWait(navbarToggleLoc, LONGWAIT);
	        scrollToElementWithOffset(navbarToggleLoc, -100); // scroll slightly up if needed
	        safeClick(navbarToggleLoc);

	        Reporter.log("✅ Clicked the Navbar Toggle button", true);
	        BasesetupUmaxx5G.infoLog("✅ Clicked the Navbar Toggle button");
	    }

	    public void clickAboutPageLink() {
	        String locator = "(//a[normalize-space()='About'])[1]";

	        try {
	            safeExplicitWait(locator, LONGWAIT);       // Wait for visibility
	            scrollToElement(locator);                  // Scroll to the element
	            safeClick(locator);                        // Use your reusable method

	            Reporter.log("✅ Clicked on 'About' page ", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'About' page ");

	        } catch (Exception e) {
	            Reporter.log("❌ Failed to click 'About' page : " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to click 'About' page : " + e.getMessage());
	            Assert.fail("Click on 'About' page link failed due to: " + e.getMessage());
	        }
	    }

	    public void verifyMilitaryGradeBackboneText() {
	        String locator = "//p[contains(text(),'UMAXX’s proprietary Military-Grade backbone provid')]";
	        String expectedText = "UMAXX’s proprietary Military-Grade backbone provides its customers with a faster, stronger, and more";

	        safeExplicitWait(locator, LONGWAIT);  // Wait until element appears

	        String actualText = getText(locator).trim();  // Directly using getText, like your other method

	        Assert.assertTrue(actualText.contains(expectedText), "❌ Text not matching!");
	        Reporter.log("✅ Military-grade backbone text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Military-grade backbone text verified: " + actualText);
	    }

	    public void verifyMilitaryGradeCTAButtonText() {
	        String locator = "//b[normalize-space()='Yes, I Want Military Grade Internet']";
	        String expectedText = "Yes, I Want Military Grade Internet";

	        safeExplicitWait(locator, LONGWAIT);  // Wait until visible

	        String actualText = getText(locator).trim();  // Use your safe getText()

	        Assert.assertEquals(actualText, expectedText, "❌ CTA Button text does not match!");
	        Reporter.log("✅ CTA Button text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ CTA Button text verified: " + actualText);
	    }
	    public void clickFirstClickNowButton() {
	        String locator = "(//a[normalize-space()='Click Now'])[1]";

	        try {
	            safeExplicitWait(locator, NORAMALWAIT); // Wait for element visibility
	            scrollToElement(locator);               // Scroll to the element
	            safeClick(locator);                     // Click the CTA

	            Reporter.log("✅ Successfully clicked on 'Click Now' CTA button", true);
	            BasesetupUmaxx5G.passLog("✅ Successfully clicked on 'Click Now' button");
	        } catch (Exception e) {
	            Reporter.log("❌ Failed to click on 'Click Now' CTA: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to click on 'Click Now' CTA: " + e.getMessage());
	            Assert.fail("Click action failed for: 'Click Now' CTA");
	        }
	    }

	    
	    public void verify5GInternetPlansHeading() {
	        String locator = "//h1[normalize-space()='5G Internet Plans']";
	        String expectedText = "5G Internet Plans";

	        try {
	            safeExplicitWait(locator, NORAMALWAIT); // Wait for heading to appear
	            String actualText = getText(locator).trim(); // Use your reusable getText method

	            Assert.assertEquals(actualText, expectedText, "❌ Heading text mismatch!");
	            Reporter.log("✅ Heading text verified: " + actualText, true);
	            BasesetupUmaxx5G.passLog("✅ Verified heading text: " + actualText);
	        } catch (Exception e) {
	            Reporter.log("❌ Failed to verify heading: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Heading text verification failed: " + e.getMessage());
	            Assert.fail("Heading verification failed: " + e.getMessage());
	        }
	    }

	    public void verify5GInternetPlansHeadingAndGoBack() {
	        String locator = "//h1[normalize-space()='5G Internet Plans']";
	        String expectedText = "5G Internet Plans";

	        try {
	            safeExplicitWait(locator, NORAMALWAIT); // Wait for the heading to appear
	            String actualText = getText(locator).trim();

	            Assert.assertEquals(actualText, expectedText, "❌ Heading text mismatch!");
	            Reporter.log("✅ Heading text verified: " + actualText, true);
	            BasesetupUmaxx5G.passLog("✅ Verified heading text: " + actualText);

	            // Navigate back to previous page
	            driver.navigate().back();
	            Reporter.log("↩️ Navigated back to previous page", true);
	            BasesetupUmaxx5G.passLog("↩️ Navigated back to previous page");

	        } catch (Exception e) {
	            Reporter.log("❌ Heading verification or navigation failed: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Heading check or back navigation failed: " + e.getMessage());
	            Assert.fail("Heading check or back navigation failed: " + e.getMessage());
	        }
	    }


}
