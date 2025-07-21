package pages;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class CoverageAvailityPage extends SafeActionUmaxx5G{
	
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
	public void click5GCoverageAvailability() {
	    String locator = "(//a[normalize-space()='5G Coverage Availability'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);           // Wait until the link is present
	        scrollToElement(locator);                      // Optional: scroll into view
	        safeClick(locator);                            // Click the 5G Coverage Availability link

	        Reporter.log("✅ Clicked on '5G Coverage Availability'", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on '5G Coverage Availability'");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on '5G Coverage Availability' link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on '5G Coverage Availability' link: " + e.getMessage());
	        Assert.fail("Click on '5G Coverage Availability' link failed due to: " + e.getMessage());
	    }
	}
	
	public void verifyCoverageHeaderText() {
	    String locator = "(//b[normalize-space()=\"UMAXX: America's Best 5G Coverage\"])[1]";
	    String expectedText = "UMAXX: America's Best 5G Coverage";

	    try {
	        safeExplicitWait(locator, LONGWAIT);                  // Wait for the element to appear
	        String actualText = getText(locator).trim();          // Get the actual text

	        Assert.assertEquals(actualText, expectedText, "❌ Header text does not match!");
	        Reporter.log("✅ Header text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Header text verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify header text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify header text: " + e.getMessage());
	        Assert.fail("Header text verification failed due to: " + e.getMessage());
	    }
	}

	public void verifyCoverageSubtitleText() {
	    String locator = "//p[@class='coverage_zipcode_sub_title mt-1r']";
	    String expectedText = "Enter ZipCode to confirm coverage in your area";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Coverage subtitle text does not match!");
	        Reporter.log("✅ Coverage subtitle text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Coverage subtitle text verified: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify coverage subtitle text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify coverage subtitle text: " + e.getMessage());
	        Assert.fail("Coverage subtitle text verification failed due to: " + e.getMessage());
	    }
	}
	public void enterZipCode(String zipCode) {
	    String locator = "(//input[@id='coverage-code'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);           // Wait for the ZIP input field to appear
	        scrollToElement(locator);                      // Scroll into view (optional)
	        scrollUp(150);  
	       // safeClear(locator);                            // First, clear any existing text
	       // Thread.sleep(500);                             // Short pause to ensure field is cleared (optional but helpful)
	        safeType(locator, zipCode);                    // Then, enter the new ZIP code

	        Reporter.log("✅ Entered ZIP code: " + zipCode, true);
	        BasesetupUmaxx5G.passLog("✅ Entered ZIP code: " + zipCode);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to enter ZIP code: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to enter ZIP code: " + e.getMessage());
	        Assert.fail("ZIP code entry failed due to: " + e.getMessage());
	    }
	}

	
	public void clickSearchButton() {
	    String locator = "//button[@class='btn btn-primary']";

	    try {
	        safeExplicitWait(locator, LONGWAIT + 50);   // Wait until the button is visible
	        scrollToElement(locator);                   // Scroll to the button
	        scrollUp(150);                              // Adjust view slightly above the button
	        safeClick(locator);                         // Click the button

	        Reporter.log("✅ Clicked on Search button", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on Search button");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on Search button: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on Search button: " + e.getMessage());
	        Assert.fail("Search button click failed due to: " + e.getMessage());
	    }
	}




	public void verifyCoverageSuccessMessage() {
	    String locator = "//p[text() = 'Awesome news, we offer coverage in your area, now let’s get you the right plan.']";
	    String expectedText = "Awesome news, we offer coverage in your area, now let’s get you the right plan.";

	    try {
	        safeExplicitWait(locator, LONGWAIT);         // Wait for element
	        scrollToElement(locator);                    // Scroll to the element
	        String actualText = getText(locator).trim(); // Fetch actual text

	        Assert.assertEquals(actualText, expectedText, "❌ Coverage success message does not match!");
	        Reporter.log("✅ Coverage success message verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Coverage success message verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify coverage success message: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify coverage success message: " + e.getMessage());
	        Assert.fail("Coverage success message verification failed due to: " + e.getMessage());
	    }
	}

	public void verifyNoCoverageMessage() {
	    String locator = "(//p[@class='message-box-five-p'])[1]";
	    String expectedText = "Sorry we’re not there yet, but we’re constantly expanding coverage, so please provide your info and we’ll contact you as soon as we’re in your neighborhood.";

	    try {
	        safeExplicitWait(locator, LONGWAIT + 50);         // Wait for element
	        scrollToElement(locator);                         // Scroll to the message
	        String actualText = getText(locator).trim();      // Get actual message text

	        Assert.assertEquals(actualText, expectedText, "❌ No-coverage message does not match!");
	        Reporter.log("✅ No-coverage message verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ No-coverage message verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify no-coverage message: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify no-coverage message: " + e.getMessage());
	        Assert.fail("No-coverage message verification failed due to: " + e.getMessage());
	    }
	}
	
	public void clickOrderNowLink() {
	    String locator = "//a[normalize-space()='Order Now']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);         // Wait for the link to be visible/clickable
	        scrollToElement(locator);                    // Scroll to the link
	        safeClick(locator);                          // Click the link

	        Reporter.log("✅ Clicked on 'Order Now' link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Order Now' link");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click 'Order Now' link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click 'Order Now' link: " + e.getMessage());
	        Assert.fail("Click on 'Order Now' link failed due to: " + e.getMessage());
	    }
	}

	public void verify5GInternetHeading() {
	    String locator = "//h1[normalize-space()='Which 5G Internet package is right for you?']";
	    String expectedText = "Which 5G Internet package is right for you?";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ 5G Internet heading does not match!");
	        Reporter.log("✅ Verified 5G Internet heading: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified 5G Internet heading: " + actualText);

	        // ✅ Go back to previous page
	        driver.navigate().back();
	        Reporter.log("↩️ Navigated back to previous page", true);
	        BasesetupUmaxx5G.passLog("↩️ Navigated back to previous page");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify 5G Internet heading: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify 5G Internet heading: " + e.getMessage());
	        Assert.fail("Verification of 5G Internet heading failed due to: " + e.getMessage());
	    }
	}
	public void clearCoverageCodeField() {
	    String locator = "//input[@id='coverage-code']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);   // Wait until the field is visible
	        scrollToElement(locator);                // Scroll to the input field
	        scrollUp(150);                           // Scroll slightly up for better visibility
	        safeClear(locator);                      // Clear the field safely

	        Reporter.log("✅ Cleared text from Coverage Code field", true);
	        BasesetupUmaxx5G.passLog("✅ Cleared text from Coverage Code field");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to clear Coverage Code field: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to clear Coverage Code field: " + e.getMessage());
	        Assert.fail("Clearing Coverage Code field failed due to: " + e.getMessage());
	    }
	}

	public void enterVisitorEmail(String email) {
	    String locator = "//input[@id='visitor_email_address']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);
	        scrollUp(150); // Adjust view if needed
	        safeClear(locator);
	        safeType(locator, email);

	        Reporter.log("✅ Entered email into Visitor Email Address field", true);
	        BasesetupUmaxx5G.passLog("✅ Entered email into Visitor Email Address field");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to enter email: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to enter email: " + e.getMessage());
	        Assert.fail("Entering email failed due to: " + e.getMessage());
	    }
	}

	public void clickNotifyButton() {
	    String locator = "(//button[normalize-space()='Notify'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);   // Wait until Notify button is visible
	        scrollToElement(locator);
	        scrollUp(150);                           // Adjust for visibility above
	        safeClick(locator);                      // Perform the click

	        Reporter.log("✅ Clicked on Notify button", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on Notify button");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click Notify button: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click Notify button: " + e.getMessage());
	        Assert.fail("Click on Notify button failed: " + e.getMessage());
	    }
	}
	
	public void validateThankYouMessage() {
	    String locator = "//div[text() = 'Thank you for sharing your information.']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);    // Wait for the message to be visible
	        scrollToElement(locator);                 // Scroll to the message element
	        scrollUp(150);                            // Adjust scroll position

	        boolean isVisible = safeIsDisplayed(locator);
	        Assert.assertTrue(isVisible, "Thank You message is not displayed.");

	        Reporter.log("✅ Thank You message is displayed", true);
	        BasesetupUmaxx5G.passLog("✅ Thank You message is displayed");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to validate Thank You message: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to validate Thank You message: " + e.getMessage());
	        Assert.fail("Validation of Thank You message failed due to: " + e.getMessage());
	    }
	}



}
