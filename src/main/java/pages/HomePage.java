package pages;

import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class HomePage extends SafeActionUmaxx5G {
	
     String LogoLoc = "//a[@class='navbar-brand mx-3']//img[@alt='UMAXX']";
	 String mobileNumberLoc = "//a[text()='1-866-873-1399']";
	 String startingPriceTextLoc = "//p[text()='Starting at $39.99/month']";
	 String supportEmailLoc = "//a[normalize-space()='EMAIL: Support@umaxx.tv']";
	 String emailSubscribeProgramLoc = "//input[@class='required email']";
	  String subscribeButtonLoc = "//input[@name='subscribe']";
	  String viewPackagesLoc = "//a[@class='btn yes-btn mb-3'][normalize-space()='Click Now']";
	  String zipCodeInputLoc = "//input[@placeholder='Enter ZIP Code']";
	  String searchButtonLoc = "//button[@class='btn btn-primary']";
	  
	  String newPageHeader = "//h1[text() = 'Which 5G Internet package is right for you?']";
	  
	  String unserviceableMsgLoc = "//p[contains(text(),'Sorry we’re not there yet, but we’re constantly ex')]";
	  String notifyEmailLoc = "//input[@placeholder='Email']";
	  String notifyButtonLoc = "//button[text()='Notify']";
	public void LogoVisibilty() {
		safeExplicitWait(LogoLoc, NORAMALWAIT);
		safeIsDisplayed(LogoLoc);
		 Reporter.log("✅ UMAXX logo is displayed successfully", true);
		BasesetupUmaxx5G.infoLog("✅ UMAXX logo is displayed successfully");
	}
	
	
	public void verifyPageTitle() {
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "UMAXX - BIGGER FASTER STRONGER UMAXX 5G TV, IPTV";

	    Reporter.log("📄 Page Title: " + actualTitle, true);
	    BasesetupUmaxx5G.infoLog("📄 Page Title: " + actualTitle);

	    Assert.assertEquals(actualTitle.trim(), expectedTitle.trim(), "❌ Page title does not match!");
	    
	    Reporter.log("✅ Page title verification passed", true);
	    BasesetupUmaxx5G.infoLog("✅ Page title verification passed");
	}

	public void verifyCustomerSupportNumber() {
	    safeExplicitWait(mobileNumberLoc, NORAMALWAIT);

	    String actualNumber = getText(mobileNumberLoc).trim();
	    String expectedNumber = "1-866-873-1399";

	    Assert.assertEquals(actualNumber, expectedNumber, "❌ Customer support number does not match!");

	    Reporter.log("✅ Customer support number verified: " + actualNumber, true);
	    BasesetupUmaxx5G.passLog("✅ Customer support number verified: " + actualNumber);
	}

	public void verifyStartingPriceText() {
	    safeExplicitWait(startingPriceTextLoc, NORAMALWAIT);

	    String expectedText = "Starting at $39.99/month";
	    String actualText = getText(startingPriceTextLoc).trim();

	    Assert.assertEquals(actualText, expectedText, "❌ Starting price text does not match!");
	    Reporter.log("✅ Starting price text verified: " + actualText, true);
	    BasesetupUmaxx5G.passLog("✅ Starting price text verified: " + actualText);
	}
	public void verifySupportEmail() {
	    safeExplicitWait(supportEmailLoc, NORAMALWAIT);

	    String actualEmail = getText(supportEmailLoc).trim();
	    String expectedEmail = "EMAIL: Support@umaxx.tv";

	    Assert.assertEquals(actualEmail, expectedEmail, "❌ Support email does not match!");
	    Reporter.log("✅ Support email verified: " + actualEmail, true);
	    BasesetupUmaxx5G.passLog("✅ Support email verified: " + actualEmail);
	}

	public void verifyEmailSubscribeProgram() {
	    safeExplicitWait(emailSubscribeProgramLoc, NORAMALWAIT);
	    safeType(emailSubscribeProgramLoc, "abc@gmail.com");

	    Reporter.log("✅ Successfully entered the email address in the subscription field", true);
	    BasesetupUmaxx5G.infoLog("✅ Successfully entered the email address in the subscription field");
	}
	
	public void clickSubscribeButton() {
	    safeExplicitWait(subscribeButtonLoc, NORAMALWAIT);
	    scrollToElement(subscribeButtonLoc);
	    safeClick(subscribeButtonLoc);

	    Reporter.log("✅ Clicked on the 'Subscribe' button successfully", true);
	    BasesetupUmaxx5G.infoLog("✅ Clicked on the 'Subscribe' button successfully");
	}
	
	public void clickViewPackagesLinkWithScroll() {
	    safeExplicitWait(viewPackagesLoc, LONGWAIT);
	    scrollToElement(viewPackagesLoc); // ✅ Scroll before clicking
	    safeClick(viewPackagesLoc);

	    Reporter.log("✅ Clicked on 'View Packages' link successfully after scrolling", true);
	    BasesetupUmaxx5G.infoLog("✅ Clicked on 'View Packages' link successfully after scrolling");
	}
	
	public void verify5GPlansPageTitle() {
	    String actualTitle = driver.getTitle().trim();
	    String expectedTitle = "UMAXX - BIGGER FASTER STRONGER UMAXX 5G TV, IPTV";

	    Reporter.log("📄 New Page Title: " + actualTitle, true);
	    BasesetupUmaxx5G.infoLog("📄 New Page Title: " + actualTitle);

	    Assert.assertEquals(actualTitle, expectedTitle, "❌ 5G Plans Page title mismatch!");
	    Reporter.log("✅ 5G Plans page title verified successfully", true);
	    BasesetupUmaxx5G.passLog("✅ 5G Plans page title verified successfully");
	}
	
	
	public void navigateBackToHomePage() {
	    driver.navigate().back();
	    Reporter.log("🔙 Navigated back to the Home Page", true);
	    BasesetupUmaxx5G.infoLog("🔙 Navigated back to the Home Page");
	}

	public void verifyZipCodeInstructionText() {
	    String zipInstructionLoc = "//p[text()='Enter ZIP Code to confirm coverage in your area']";

	    safeExplicitWait(zipInstructionLoc, NORAMALWAIT);
	    String actualText = getText(zipInstructionLoc).trim();
	    String expectedText = "Enter ZIP Code to confirm coverage in your area";

	    Assert.assertEquals(actualText, expectedText, "❌ ZIP code instruction text mismatch!");
	    Reporter.log("✅ Verified ZIP code instruction text: " + actualText, true);
	    BasesetupUmaxx5G.passLog("✅ Verified ZIP code instruction text: " + actualText);

	    // 🔼 Scroll to top of the page
	    scrollToTop();
	    Reporter.log("🔼 Scrolled to top of the page", true);
	    BasesetupUmaxx5G.infoLog("🔼 Scrolled to top of the page");
	}

	public void enterZipCode(String zipCode) {
	    safeExplicitWait(zipCodeInputLoc, NORAMALWAIT);
	    scrollToElementWithOffset(zipCodeInputLoc, -150); // scroll up a bit
	    safeType(zipCodeInputLoc, zipCode);

	    Reporter.log("✅ Entered ZIP code: " + zipCode, true);
	    BasesetupUmaxx5G.passLog("✅ Entered ZIP code: " + zipCode);
	}

	public void clickSearchButton() {
	    safeExplicitWait(searchButtonLoc, LONGWAIT);
	    scrollToElementWithOffset(searchButtonLoc, -150); // ✅ scroll up slightly
	    safeClick(searchButtonLoc);

	    Reporter.log("✅ Clicked the Search button", true);
	    BasesetupUmaxx5G.infoLog("✅ Clicked the Search button");
	}
	
	public void verifyCoverageSuccessMessage() {
	    String successMessageLoc = "//p[contains(text(), 'Awesome news, we offer coverage')]";
	    safeExplicitWait(successMessageLoc, VERYLONGWAIT);

	    if (safeIsDisplayed(successMessageLoc)) {
	        String msg = getText(successMessageLoc).trim();
	        Reporter.log("✅ Coverage message displayed: " + msg, true);
	        BasesetupUmaxx5G.passLog("✅ Coverage message displayed: " + msg);
	    } else {
	        Reporter.log("❌ Coverage message not displayed", true);
	        BasesetupUmaxx5G.failLog("❌ Coverage message not displayed");
	    }
	}

	public void waitForNewPlansPageToLoad() {
	    safeExplicitWait(newPageHeader, VERYLONGWAIT);  // Uses your dynamic wait setup

	    Reporter.log("✅ Navigated to the 5G Plans page successfully", true);
	    BasesetupUmaxx5G.passLog("✅ 5G Internet Plans page loaded");
	}


	public void refreshPage() {
	    driver.navigate().refresh();
	    Reporter.log("🔄 Page refreshed successfully", true);
	    BasesetupUmaxx5G.infoLog("🔄 Page refreshed successfully");
	}
	
	public void verifyUnserviceableZipMessage() {

	    safeExplicitWait(unserviceableMsgLoc, VERYLONGWAIT);

	    if (safeIsDisplayed(unserviceableMsgLoc)) {
	        String msg = getText(unserviceableMsgLoc).trim();
	        Reporter.log("❗ Unserviceable ZIP message displayed: " + msg, true);
	        BasesetupUmaxx5G.passLog("❗ Unserviceable ZIP message displayed: " + msg);
	    } else {
	        Reporter.log("❌ Unserviceable ZIP message not displayed", true);
	        BasesetupUmaxx5G.failLog("❌ Unserviceable ZIP message not displayed");
	    }
	}

	public void enterNotifyEmail(String email) {

	    safeExplicitWait(notifyEmailLoc, NORAMALWAIT);

	    if (safeIsDisplayed(notifyEmailLoc)) {
	        safeClear(notifyEmailLoc);
	        safeType(notifyEmailLoc, email);
	        Reporter.log("📧 Entered Notify Email: " + email, true);
	        BasesetupUmaxx5G.passLog("📧 Entered Notify Email: " + email);
	    } else {
	        Reporter.log("❌ Notify Email input field not found", true);
	        BasesetupUmaxx5G.failLog("❌ Notify Email input field not found");
	    }
	}


	public void clickNotifyButton() {

	    safeExplicitWait(notifyButtonLoc, LONGWAIT);
	    safeClick(notifyButtonLoc);

	    Reporter.log("📩 Clicked 'Notify' button", true);
	    BasesetupUmaxx5G.passLog("📩 Clicked 'Notify' button");
	}




}
