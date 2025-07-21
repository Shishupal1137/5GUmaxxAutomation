package pages;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class UmaxxFAQPage extends SafeActionUmaxx5G{
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
	public void clickOnFAQSection() {
	    String locator = "(//a[normalize-space()='FAQS'])[1]";
	    
	    try {
	        scrollToElement(locator); // Scroll to ensure visibility
	        safeExplicitWait(locator, NORAMALWAIT); // Wait until visible
	        safeClick(locator); // Perform the click

	        Reporter.log("✅ Successfully clicked on 'FAQS' section.", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'FAQS' section: " + locator);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'FAQS' section: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'FAQS' section: " + e.getMessage());
	        Assert.fail("Click action failed for: 'FAQS' section");
	    }
	}
	
	
	String faqQuestionLoc = "(//h4[contains(text(),'Is there a data cap on the UMAXX™ 5G Internet Hots')])[1]";

	public void verifyDataCapFAQQuestion() {
	    safeExplicitWait(faqQuestionLoc, LONGWAIT);
	  
	    String actualText = getText(faqQuestionLoc).trim();
	    String expectedText = "Is there a data cap on the UMAXX™ 5G Internet Hotspot service?";

	    Reporter.log("📌 FAQ Text Displayed: " + actualText, true);
	    BasesetupUmaxx5G.infoLog("📌 FAQ Text Displayed: " + actualText);

	    if (!actualText.equals(expectedText)) {
	        BasesetupUmaxx5G.failLog("❌ FAQ text mismatch! Expected: '" + expectedText + "', but found: '" + actualText + "'");
	    }

	    Assert.assertEquals(actualText, expectedText, "❌ FAQ text mismatch!");
	    Reporter.log("✅ FAQ text verification passed", true);
	    BasesetupUmaxx5G.infoLog("✅ FAQ text verification passed");
	}
	
	String signingUpFaqLoc = "//a[normalize-space()='Signing Up']";

	public void clickSigningUpFAQ() {
	    try {
	        safeExplicitWait(signingUpFaqLoc, LONGWAIT);
	        safeClick(signingUpFaqLoc);

	        Reporter.log("✅ Clicked on 'Signing Up' FAQ link", true);
	        BasesetupUmaxx5G.infoLog("✅ Clicked on 'Signing Up' FAQ link");
	    } catch (Exception e) {
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Signing Up' FAQ link: " + e.getMessage());
	        Assert.fail("❌ Failed to click on 'Signing Up' FAQ link: " + e.getMessage());
	    }
	}

	String signingUpFaqTextLoc = "//h4[contains(text(),'How do I get signed up for UMAXX™ 5G Internet Hots')]";

	String faqTextLocator = "//h4[contains(text(),'How do I get signed up for UMAXX™ 5G Internet Hots')]";

	public void verifySignUpFAQText() {
	    try {
	        // Wait for the FAQ element to be visible
	        safeExplicitWait(faqTextLocator, LONGWAIT);

	        // Get the actual text displayed on the page
	        String actualText = getText(faqTextLocator).trim();
	        String expectedText = "How do I get signed up for UMAXX™ 5G Internet Hotspot Service?";

	        // Log the actual text
	        Reporter.log("📘 FAQ Text Displayed: " + actualText, true);
	        BasesetupUmaxx5G.infoLog("📘 FAQ Text Displayed: " + actualText);

	        // Assert the actual text matches the expected
	        Assert.assertEquals(actualText, expectedText, "❌ FAQ text mismatch!");

	        // Log success
	        Reporter.log("✅ FAQ text verified", true);
	        BasesetupUmaxx5G.infoLog("✅ FAQ text verified");
	        
	    } catch (Exception e) {
	        // Log and fail in case of any exception
	        BasesetupUmaxx5G.failLog("❌ Failed to verify FAQ text: " + e.getMessage());
	        Assert.fail("❌ Failed to verify FAQ text: " + e.getMessage());
	    }
	}

	String settingUpFAQLinkLoc = "(//a[normalize-space()='Setting Up'])[1]";

	public void clickSettingUpFAQLink() {
	    try {
	        // Wait until the "Setting Up" link is visible
	        safeExplicitWait(settingUpFAQLinkLoc, LONGWAIT);

	        // Click the link
	        safeClick(settingUpFAQLinkLoc);

	        // Log success
	        Reporter.log("✅ Clicked on 'Setting Up' FAQ link", true);
	        BasesetupUmaxx5G.infoLog("✅ Clicked on 'Setting Up' FAQ link");
	        
	    } catch (Exception e) {
	        // Log and fail in case of exception
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Setting Up' FAQ link: " + e.getMessage());
	        Assert.fail("❌ Failed to click on 'Setting Up' FAQ link: " + e.getMessage());
	    }
	}
	
	String setupFAQQuestionLoc = "//h4[contains(text(),'How do I set up UMAXX™ 5G Internet Hotspot?')]";

	public void verifySetupFAQQuestionText() {
	    try {
	        // Wait for the FAQ question to be visible
	        safeExplicitWait(setupFAQQuestionLoc, LONGWAIT);
	        
	        // Get the actual text from the element
	        String actualText = getText(setupFAQQuestionLoc).trim();
	        String expectedText = "How do I set up UMAXX™ 5G Internet Hotspot?";

	        // Log the fetched text
	        Reporter.log("📄 FAQ Text Displayed: " + actualText, true);
	        BasesetupUmaxx5G.infoLog("📄 FAQ Text Displayed: " + actualText);

	        // Assertion
	        Assert.assertEquals(actualText, expectedText, "❌ FAQ text mismatch!");

	        // Log success
	        Reporter.log("✅ FAQ text verification passed", true);
	        BasesetupUmaxx5G.infoLog("✅ FAQ text verification passed");
	        
	    } catch (Exception e) {
	        // Log and fail
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying setup FAQ question: " + e.getMessage());
	        Assert.fail("❌ Exception while verifying setup FAQ question: " + e.getMessage());
	    }
	}

	String deviceDetailsFAQLoc = "(//a[normalize-space()='Device Details'])[1]";

	public void clickDeviceDetailsFAQButton() {
	    try {
	        // Wait for the element to be clickable
	        safeExplicitWait(deviceDetailsFAQLoc, LONGWAIT);
	        
	        // Click the "Device Details" link
	        safeClick(deviceDetailsFAQLoc);

	        // Log success
	        Reporter.log("✅ Clicked on 'Device Details' FAQ section", true);
	        BasesetupUmaxx5G.infoLog("✅ Clicked on 'Device Details' FAQ section");
	        
	    } catch (Exception e) {
	        // Log and fail
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Device Details': " + e.getMessage());
	        Assert.fail("❌ Failed to click on 'Device Details': " + e.getMessage());
	    }
	}
	String signalRangeFAQTextLoc = "//h4[normalize-space()='How far does the signal go from my house?']";

	public void verifySignalRangeFAQText() {
	    try {
	        safeExplicitWait(signalRangeFAQTextLoc, LONGWAIT);
	        String actualText = getText(signalRangeFAQTextLoc).trim();
	        String expectedText = "How far does the signal go from my house?";

	        Reporter.log("📄 FAQ Text Displayed: " + actualText, true);
	        BasesetupUmaxx5G.infoLog("📄 FAQ Text Displayed: " + actualText);

	        Assert.assertEquals(actualText, expectedText, "❌ FAQ text mismatch!");
	        Reporter.log("✅ FAQ text verified successfully", true);
	        BasesetupUmaxx5G.infoLog("✅ FAQ text verified successfully");

	    } catch (Exception e) {
	        BasesetupUmaxx5G.failLog("❌ Failed to verify FAQ text: " + e.getMessage());
	        Assert.fail("❌ Failed to verify FAQ text: " + e.getMessage());
	    }
	}



}

