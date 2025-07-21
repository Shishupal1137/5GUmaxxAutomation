package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class UmaxxPhonePage extends SafeActionUmaxx5G {
	
	
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
	
	public void clickUmaxxPhonesLink() {
	    String locator = "//li[4]//a[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);             // Wait for visibility
	        scrollToElement(locator);                         // Optional scroll
	        safeClick(locator);                               // Click on the link

	        Reporter.log("✅ Clicked on 'UMAXX Phones' link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'UMAXX Phones' link");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'UMAXX Phones' link: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'UMAXX Phones' link: " + e.getMessage());
	        Assert.fail("'UMAXX Phones' link click failed due to: " + e.getMessage());
	    }
	}

	public void verifyUmaxxMobileText() {
	    String xpath = "//span[normalize-space()='UMAXX Total Privacy Phones']";
	    String expectedText = "UMAXX Total Privacy Phones";

	    try {
	        if (!safeIsDisplayed(xpath)) {
	            Reporter.log("❌ UMAXX mobile label not displayed.", true);
	            BasesetupUmaxx5G.failLog("❌ UMAXX mobile label not displayed.");
	            Assert.fail("UMAXX mobile label not displayed.");
	        }

	        String actualText = getText(xpath).trim();

	        Assert.assertEquals(actualText, expectedText);
	        Reporter.log("✅ Verified UMAXX mobile label text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified UMAXX mobile label text: " + actualText);

	    } catch (AssertionError e) {
	        Reporter.log("❌ Text mismatch for UMAXX mobile. Expected: '" + expectedText + "', Found: '" + getText(xpath).trim() + "'", true);
	        BasesetupUmaxx5G.failLog("❌ Text mismatch for UMAXX mobile. Expected: '" + expectedText + "', Found: '" + getText(xpath).trim() + "'");
	        Assert.fail("UMAXX mobile text mismatch.");
	    } catch (Exception e) {
	        Reporter.log("❌ Exception during UMAXX mobile text verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during UMAXX mobile text verification: " + e.getMessage());
	        Assert.fail("UMAXX mobile text verification failed.");
	    }
	}
	
	public void verifyUmaxxPhoneHeader() {
	    String xpath = "//h5[normalize-space()='Secure, Private, Anonymous, Phone Calls']";
	    String expectedText = "Secure, Private, Anonymous, Phone Calls";

	    try {
	        if (!safeIsDisplayed(xpath)) {
	            Reporter.log("❌ Phone header not displayed on UMAXX Phone page.", true);
	            BasesetupUmaxx5G.failLog("❌ Phone header not displayed on UMAXX Phone page.");
	            Assert.fail("Phone header not displayed.");
	        }

	        String actualText = getText(xpath).trim();

	        Assert.assertEquals(actualText, expectedText);
	        Reporter.log("✅ Verified phone header text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified phone header text: " + actualText);

	    } catch (AssertionError e) {
	        Reporter.log("❌ Header text mismatch. Expected: '" + expectedText + "', Found: '" + getText(xpath).trim() + "'", true);
	        BasesetupUmaxx5G.failLog("❌ Header text mismatch. Expected: '" + expectedText + "', Found: '" + getText(xpath).trim() + "'");
	        Assert.fail("UMAXX phone header text mismatch.");
	    } catch (Exception e) {
	        Reporter.log("❌ Exception during phone header text verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during phone header text verification: " + e.getMessage());
	        Assert.fail("Phone header text verification failed.");
	    }
	}
	
	
	public void verifyUmaxxLibertyPlusIsDisplayed() {
	    String xpath = "//h3[@class='text-center sm-show mt-3 mb-2']//b[contains(text(),'UMAXX Liberty Plus')]";

	    try {
	        scrollDown(400); // 🔁 directly use inherited method — no object creation

	        if (safeIsDisplayed(xpath)) {
	            Reporter.log("✅ Element 'UMAXX Liberty Plus' is displayed.", true);
	            BasesetupUmaxx5G.passLog("✅ Element 'UMAXX Liberty Plus' is displayed.");
	        } else {
	            Reporter.log("❌ Element 'UMAXX Liberty Plus' is NOT displayed.", true);
	            BasesetupUmaxx5G.failLog("❌ Element 'UMAXX Liberty Plus' is NOT displayed.");
	            Assert.fail("Element 'UMAXX Liberty Plus' is not visible on the page.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying 'UMAXX Liberty Plus': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying 'UMAXX Liberty Plus': " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }
	}


	public void verifyPhoneNumberText() {
	    String locator = "(//a[@class='text-black'])[1]";
	    String expectedPhoneNumber = "1-866-873-1399";

	    try {
	    	scrollToElement(locator);// Ensures visibility if not already in view

	        if (safeIsDisplayed(locator)) {
	            String actualText = getText(locator).trim();

	            Reporter.log("📞 Found phone number: " + actualText, true);
	            BasesetupUmaxx5G.infoLog("📞 Found phone number: " + actualText);

	            Assert.assertEquals(actualText, expectedPhoneNumber, "❌ Phone number does not match!");
	            Reporter.log("✅ Phone number verified successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Phone number verified successfully.");
	        } else {
	            Reporter.log("❌ Phone number element is not displayed.", true);
	            BasesetupUmaxx5G.failLog("❌ Phone number element is not displayed.");
	            Assert.fail("Phone number element is not visible on the page.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying phone number: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying phone number: " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }
	}

	public void verifyModelSuggestionText() {
	    String locator = "(//div[@class='suggestion-container fs-4 text-secondary text-center mb-3 mt-5'])[1]";
	    String expectedText = "Which Model is for you?";

	    try {
	        safeExplicitWait(locator, LONGWAIT); // Wait until element is visible
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Suggestion text does not match!");
	        Reporter.log("✅ Suggestion text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Suggestion text verified: " + actualText);
	        
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify suggestion text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify suggestion text: " + e.getMessage());
	        Assert.fail("Suggestion text verification failed due to: " + e.getMessage());
	    }
	}

	public void verifyLibertyPlusParagraphText() {
	    String locator = "(//p[normalize-space()='UMAXX Liberty Plus'])[1]";
	    String expectedText = "UMAXX Liberty Plus";

	    try {
	        safeExplicitWait(locator, LONGWAIT); // Wait until the element is visible
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Liberty Plus text does not match!");
	        Reporter.log("✅ Liberty Plus paragraph text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Liberty Plus paragraph text verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify Liberty Plus text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify Liberty Plus text: " + e.getMessage());
	        Assert.fail("Verification failed due to: " + e.getMessage());
	    }
	}

	public void verifyOriginalPriceSectionText() {
	    String locator = "(//div[@class='detail-text m-0 pb-3'][contains(text(),'Original Price:')])[1]";
	    String expectedText = "Original Price: $1,999\nPurchase Today: $1,899 ($100 off)";

	    try {
	        safeExplicitWait(locator, LONGWAIT); // Wait for visibility
	        String actualText = getText(locator).trim().replaceAll("\\r", "");

	        // Normalize line breaks for consistent comparison
	        actualText = actualText.replaceAll("\\n+", "\n");
	        expectedText = expectedText.replaceAll("\\n+", "\n");

	        Assert.assertEquals(actualText, expectedText, "❌ Price section text mismatch!");
	        Reporter.log("✅ Verified price section text:\n" + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified price section text:\n" + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify price section: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify price section: " + e.getMessage());
	        Assert.fail("Verification failed due to: " + e.getMessage());
	    }
	}

	public void verifyMemorySpecification() {
	    String locator = "//div[@class='card-left']//li[contains(text(),'Memory 4GB RAM')]";
	    String expectedText = "Memory 4GB RAM";

	    try {
	        safeExplicitWait(locator, LONGWAIT); // Wait for the element to appear
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Memory specification text mismatch!");
	        Reporter.log("✅ Memory specification text verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Memory specification text verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify memory specification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify memory specification: " + e.getMessage());
	        Assert.fail("Memory specification verification failed due to: " + e.getMessage());
	    }
	}
	public void verifyStorageText() {
	    String locator = "//div[@class='card-left']//li[contains(text(),'Storage 128GB')]";
	    String expectedText = "Storage 128GB";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Storage text mismatch!");
	        Reporter.log("✅ Verified: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Error verifying Storage text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Error verifying Storage text: " + e.getMessage());
	        Assert.fail("Storage verification failed: " + e.getMessage());
	    }
	}

	public void verifyUmaxxLibertyText() {
	    String locator = "(//p[normalize-space()='UMAXX Liberty'])[1]";
	    String expectedText = "UMAXX Liberty";

	    try {
	        safeExplicitWait(locator, LONGWAIT);  // Wait for visibility
	        String actualText = getText(locator).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Text mismatch for UMAXX Liberty!");
	        Reporter.log("✅ Verified UMAXX Liberty text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified UMAXX Liberty text: " + actualText);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to verify UMAXX Liberty text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to verify UMAXX Liberty text: " + e.getMessage());
	        Assert.fail("Text verification failed: " + e.getMessage());
	    }
	}
	public void verifyLibertyPriceBlock2() {
	    String locator = "(//div[@class='detail-text m-0 pb-3'][contains(text(),'Original Price:')])[2]";
	    String expectedText = "Original Price: $1,599\nPurchase Today: $1,499 ($100 off)";

	    try {
	        safeExplicitWait(locator, LONGWAIT); // Wait for visibility

	        String actualText = getText(locator).trim().replace("\r", "").replace("\t", "");
	        Reporter.log("📦 Actual text:\n" + actualText, true);
	        BasesetupUmaxx5G.infoLog("📦 Actual text:\n" + actualText);

	        Assert.assertEquals(actualText, expectedText, "❌ Price block text mismatch!");
	        Reporter.log("✅ Price block verified successfully.", true);
	        BasesetupUmaxx5G.passLog("✅ Price block verified successfully.");

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during price block verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during price block verification: " + e.getMessage());
	        Assert.fail("Text verification failed: " + e.getMessage());
	    }
	}
	
	public void verifyMemory3GBText() {
	    String xpath = "//div[@class='card-left']//li[contains(text(),'Memory 3GB RAM')]";
	    String expectedText = "Memory 3GB RAM";

	    try {
	        safeExplicitWait(xpath, LONGWAIT); // Wait until the element is visible
	        String actualText = getText(xpath).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Memory text does not match!");
	        Reporter.log("✅ Verified memory text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified memory text: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Error verifying memory text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Error verifying memory text: " + e.getMessage());
	        Assert.fail("Memory text verification failed due to: " + e.getMessage());
	    }
	}
	
	
	public void verifyStorage32GBText() {
	    String xpath = "(//li[contains(text(),'Storage 32GB')])[2]";
	    String expectedText = "Storage 32GB";

	    try {
	        safeExplicitWait(xpath, LONGWAIT); // Wait until the element is visible
	        String actualText = getText(xpath).trim();

	        Assert.assertEquals(actualText, expectedText, "❌ Storage text does not match!");
	        Reporter.log("✅ Verified storage text: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Verified storage text: " + actualText);
	    } catch (Exception e) {
	        Reporter.log("❌ Error verifying storage text: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Error verifying storage text: " + e.getMessage());
	        Assert.fail("Storage text verification failed due to: " + e.getMessage());
	    }
	}
	
	
	public void clickPayFullLibertyPlus() {
	    String xpath = "(//a[text() = 'Pay In Full'])[1]";

	    try {
	        safeExplicitWait(xpath, LONGWAIT);                     // Wait for element
	        scrollToElementWithOffset(xpath, -150);                // ✅ Use reusable scroll with offset
	        safeClick(xpath);                                      // Click safely

	        Reporter.log("✅ Clicked on 'Pay Full - UMAXX Liberty Plus' button.", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Pay Full - UMAXX Liberty Plus' button.");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'Pay Full - UMAXX Liberty Plus': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Pay Full - UMAXX Liberty Plus': " + e.getMessage());
	        Assert.fail("Could not click 'Pay Full - UMAXX Liberty Plus' due to: " + e.getMessage());
	    }
	}



	public void enterOrderEmail() {
	    String locator = "(//input[@id='order_email'])[1]";

	    // ✅ Generate dynamic email using timestamp and a valid domain
	    String email = "testuser" + System.currentTimeMillis() + "@gmail.com";

	    safeExplicitWait(locator, LONGWAIT);
	    safeType(locator, email);

	    Reporter.log("✅ Entered dynamic Order Email: " + email, true);
	    BasesetupUmaxx5G.passLog("✅ Entered dynamic Order Email: " + email);
	}


	  
	  public void enterOrderPassword(String password) {
	        String locator = "(//input[@id='order_password'])[1]";

	        safeExplicitWait(locator, LONGWAIT);
	        safeType(locator, password);

	        Reporter.log("✅ Entered Order Password: " + password, true);
	        BasesetupUmaxx5G.passLog("✅ Entered Order Password: " + password);
	    }

	  public void enterOrderPhoneNumber() {
		    String locator = "(//input[@id='order_phone'])[1]";

		    // ✅ Generate a dynamic 10-digit phone number starting with 9, 8, or 7
		    String dynamicPhone = "9" + String.valueOf(System.currentTimeMillis()).substring(4, 13);

		    safeExplicitWait(locator, LONGWAIT);
		    safeType(locator, dynamicPhone);

		    Reporter.log("✅ Entered dynamic Order Phone Number: " + dynamicPhone, true);
		    BasesetupUmaxx5G.passLog("✅ Entered dynamic Order Phone Number: " + dynamicPhone);
		}

	  
	  public String generateRandomAlphabeticString(int length) {
		    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();

		    for (int i = 0; i < length; i++) {
		        sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		    }
		    return sb.toString();
		}


	  public void enterOrderFirstName() {
		    String locator = "//input[@id='order_first_name']";
		    String firstName = "TestFirst" + generateRandomAlphabeticString(4);

		    safeExplicitWait(locator, LONGWAIT);
		    safeType(locator, firstName);

		    Reporter.log("✅ Entered dynamic Order First Name: " + firstName, true);
		    BasesetupUmaxx5G.passLog("✅ Entered dynamic Order First Name: " + firstName);
		}



	  
	  public void enterOrderLastName() {
		    String locator = "(//input[@id='order_last_name'])[1]";

		    // Generate a dynamic last name with only alphabets
		    String lastName = "TestLast" + generateRandomAlphabeticString(4);

		    safeExplicitWait(locator, LONGWAIT);
		    safeType(locator, lastName);

		    Reporter.log("✅ Entered dynamic Order Last Name: " + lastName, true);
		    BasesetupUmaxx5G.passLog("✅ Entered dynamic Order Last Name: " + lastName);
		}


	  
	  public void enterOrderAddress(String address) {
	        String locator = "(//input[@id='order_address'])[1]";
	        int extendedWait = LONGWAIT + 10; // Extend wait time if needed (e.g., +10 seconds)

	        try {
	            safeExplicitWait(locator, extendedWait); // Wait longer before interacting
	            safeType(locator, address);

	            Reporter.log("✅ Entered Order Address: " + address, true);
	            BasesetupUmaxx5G.passLog("✅ Entered Order Address: " + address);
	        } catch (Exception e) {
	            Reporter.log("❌ Failed to enter Order Address: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to enter Order Address: " + e.getMessage());
	            Assert.fail("Failed to enter Order Address due to: " + e.getMessage());
	        }
	    }

	  public void clickAddressSuggestionSanAntonio() {
	        String locator = "(//span[@class='pac-item-query'])[1]";
	        int extendedWait = LONGWAIT + 10; // Give extra time for address suggestions to load

	        try {
	            safeExplicitWait(locator, extendedWait);                // Wait longer for suggestion to appear
	            scrollDown(200);                                        // Extra scroll
	            scrollToElementWithOffset(locator, -100);               // Scroll with offset
	            safeClick(locator);                                     // Click the suggestion

	            Reporter.log("✅ Clicked on address suggestion: San Antonio", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on address suggestion: San Antonio");
	        } catch (Exception e) {
	            Reporter.log("❌ Failed to click on address suggestion: " + e.getMessage(), true);
	            BasesetupUmaxx5G.failLog("❌ Failed to click on address suggestion: " + e.getMessage());
	            Assert.fail("Address suggestion click failed due to: " + e.getMessage());
	        }
	    }
	  
	  public void enterOrderZipCode(String zipCode) {
		    String locator = "(//input[@id='order_zip'])[1]";
		    int extendedWait = LONGWAIT + 10; // Allow slightly more time

		    try {
		        scrollToElement(locator);                        // Ensure it's in view
		        safeExplicitWait(locator, extendedWait);         // Wait until visible
		        safeType(locator, zipCode);                      // Type zip code

		        Reporter.log("✅ Entered ZIP Code: " + zipCode, true);
		        BasesetupUmaxx5G.passLog("✅ Entered ZIP Code: " + zipCode);
		    } catch (Exception e) {
		        Reporter.log("❌ Failed to enter ZIP Code: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Failed to enter ZIP Code: " + e.getMessage());
		        Assert.fail("Failed to enter ZIP Code due to: " + e.getMessage());
		    }
		}
	  
	  public void enterOrderCity(String city) {
		    String locator = "(//input[@id='order_city'])[1]";
		    int extendedWait = LONGWAIT + 10; // Additional wait time if needed

		    try {
		        scrollToElement(locator);                        // Bring field into view
		        safeExplicitWait(locator, extendedWait);         // Wait until it's ready
		        safeType(locator, city);                         // Type into the city field

		        Reporter.log("✅ Entered Order City: " + city, true);
		        BasesetupUmaxx5G.passLog("✅ Entered Order City: " + city);
		    } catch (Exception e) {
		        Reporter.log("❌ Failed to enter Order City: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Failed to enter Order City: " + e.getMessage());
		        Assert.fail("Failed to enter Order City due to: " + e.getMessage());
		    }
		}
	  
	  public void enterOrderState(String state) {
		    String locator = "(//input[@id='order_state'])[1]";
		    int extendedWait = LONGWAIT + 10; // Optional extended wait if needed

		    try {
		        scrollToElement(locator);                        // Scroll to the element
		        safeExplicitWait(locator, extendedWait);         // Wait for it to be visible and interactable
		        safeType(locator, state);                        // Enter the state value

		        Reporter.log("✅ Entered Order State: " + state, true);
		        BasesetupUmaxx5G.passLog("✅ Entered Order State: " + state);
		    } catch (Exception e) {
		        Reporter.log("❌ Failed to enter Order State: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Failed to enter Order State: " + e.getMessage());
		        Assert.fail("Failed to enter Order State due to: " + e.getMessage());
		    }
		}

	  public void clickAcceptTermsAndConditions() {
		    String locator = "(//input[@id='accept-checkbox'])[1]";
		    int extendedWait = LONGWAIT + 5;

		    try {
		        scrollToElement(locator);                        // Scroll to checkbox
		        safeExplicitWait(locator, extendedWait);         // Wait for checkbox visibility
		        safeClick(locator);                              // Click on the checkbox

		        Reporter.log("✅ Clicked on 'Accept Terms and Conditions' checkbox.", true);
		        BasesetupUmaxx5G.passLog("✅ Clicked on 'Accept Terms and Conditions' checkbox.");
		    } catch (Exception e) {
		        Reporter.log("❌ Failed to click on 'Accept Terms and Conditions' checkbox: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Accept Terms and Conditions' checkbox: " + e.getMessage());
		        Assert.fail("Could not click on 'Accept Terms and Conditions' checkbox due to: " + e.getMessage());
		    }
		}
	  public void clickProceedToFinalStep() {
		    String locator = "(//button[normalize-space()='PROCEED TO FINAL STEP'])[1]";
		    int extendedWait = LONGWAIT + 5;

		    try {
		        scrollToElement(locator);                         // Scroll to the button
		        safeExplicitWait(locator, extendedWait);          // Wait until it's visible
		        safeClick(locator);                               // Click the button

		        Reporter.log("✅ Clicked on 'PROCEED TO FINAL STEP' button.", true);
		        BasesetupUmaxx5G.passLog("✅ Clicked on 'PROCEED TO FINAL STEP' button.");
		    } catch (Exception e) {
		        Reporter.log("❌ Failed to click on 'PROCEED TO FINAL STEP' button: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Failed to click on 'PROCEED TO FINAL STEP' button: " + e.getMessage());
		        Assert.fail("Could not click on 'PROCEED TO FINAL STEP' button due to: " + e.getMessage());
		    }
		}
	  public void enterStripeCardNumber(String cardNumber) {
		    boolean entered = false;
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            WebElement iframe = iframes.get(i);
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframe);
		            System.out.println("🔁 Switched to iframe index: " + i);

		            // Try finding the input using multiple possible selectors
		            WebElement cardInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("input[name='cardnumber'], input[autocomplete='cc-number'], input[aria-label='Card number']")));

		            cardInput.clear();
		            cardInput.sendKeys(cardNumber);
		            System.out.println("✅ Card number entered in iframe index: " + i);
		            entered = true;
		            break;

		        } catch (TimeoutException e) {
		            System.out.println("⏰ Timeout in iframe index " + i + ": " + e.getMessage());
		        } catch (NoSuchElementException e) {
		            System.out.println("❌ NoSuchElement in iframe index " + i + ": " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("⚠️ General Exception in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!entered) {
		        Assert.fail("❌ Could not find Stripe card number field in any iframe.");
		    }
		}
	  
	  
	  public void enterStripeExpDate(String expDate) {
		    boolean entered = false;
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframes.get(i));
		            System.out.println("🔁 Switched to iframe index: " + i);

		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            WebElement expInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("input[name='exp-date'], input[autocomplete='cc-exp'], input[aria-label='Expiration']")));

		            expInput.sendKeys(expDate);
		            System.out.println("✅ Expiration date entered in iframe index: " + i);

		            entered = true;
		            break;

		        } catch (TimeoutException e) {
		            System.out.println("⏰ Timeout in iframe index " + i + ": " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("⚠️ Exception in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!entered) {
		        Assert.fail("❌ Could not find Stripe expiration date field in any iframe.");
		    }
		}
	  
	  
	  public void enterStripeCvv(String cvv) {
		    boolean entered = false;
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframes.get(i));
		            System.out.println("🔁 Switched to iframe index: " + i);

		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            WebElement cvcInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("input[name='cvc'], input[autocomplete='cc-csc'], input[aria-label='Security code']")));

		            cvcInput.sendKeys(cvv);
		            System.out.println("✅ CVV entered in iframe index: " + i);

		            entered = true;
		            break;

		        } catch (TimeoutException e) {
		            System.out.println("⏰ Timeout in iframe index " + i + ": " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("⚠️ Exception in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!entered) {
		        Assert.fail("❌ Could not find Stripe CVV field in any iframe.");
		    }
		}

	  
	  public void enterStripeCardholderName(String name) {
		    boolean entered = false;
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframes.get(i));
		            System.out.println("🔁 Switched to iframe index: " + i);

		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("input[name='cardholder-name'], input[aria-label='Name on card'], input[autocomplete='cc-name']")));

		            nameInput.clear();
		            nameInput.sendKeys(name);
		            System.out.println("✅ Cardholder name entered in iframe index: " + i);

		            entered = true;
		            break;

		        } catch (TimeoutException e) {
		            System.out.println("⏰ Timeout in iframe index " + i + ": " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("⚠️ Exception in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!entered) {
		        Assert.fail("❌ Could not find Cardholder Name field in any iframe.");
		    }
		}

		public void enterStripeZipCode(String zipCode) {
		    boolean entered = false;
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframes.get(i));
		            System.out.println("🔁 Switched to iframe index: " + i);

		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            WebElement zipInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("input[name='postal'], input[autocomplete='postal-code'], input[aria-label*='ZIP'], input[aria-label*='Postal']")));

		            zipInput.clear();
		            zipInput.sendKeys(zipCode);
		            System.out.println("✅ ZIP code entered in iframe index: " + i);

		            entered = true;
		            break;

		        } catch (TimeoutException e) {
		            System.out.println("⏰ Timeout in iframe index " + i + ": " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("⚠️ Exception in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!entered) {
		        Assert.fail("❌ Could not find ZIP/Postal Code field in any iframe.");
		    }
		}
		
		public void clickStripeSaveCardButton() {
		    boolean clicked = false;
		    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		    System.out.println("Total iframes found: " + iframes.size());

		    for (int i = 0; i < iframes.size(); i++) {
		        try {
		            driver.switchTo().defaultContent();
		            driver.switchTo().frame(iframes.get(i));
		            System.out.println("🔁 Switched to iframe index: " + i);

		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		            // Try locating Save button using valid selectors
		            List<By> saveSelectors = Arrays.asList(
		                By.cssSelector("button[type='submit']"),
		                By.cssSelector("input[type='submit']"),
		                By.xpath("//button[contains(text(), 'Save')]"),
		                By.xpath("//button[contains(text(), 'Save Card')]")
		            );

		            for (By selector : saveSelectors) {
		                try {
		                    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(selector));
		                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
		                    saveButton.click();
		                    System.out.println("✅ Clicked Save Card button in iframe index: " + i);
		                    clicked = true;
		                    break;
		                } catch (TimeoutException | NoSuchElementException ignored) {
		                    // Try next selector
		                }
		            }

		            if (clicked) break;

		        } catch (Exception e) {
		            System.out.println("⚠️ Exception while switching/clicking in iframe index " + i + ": " + e.getMessage());
		        }
		    }

		    driver.switchTo().defaultContent();

		    if (!clicked) {
		        Assert.fail("❌ Could not find and click the Save Card button in any iframe.");
		    }
		}
		
		public void toastSuccessVisibility() {
		    String toastXpath = "//div[contains(@class,'toast-body') and contains(text(),'Order created successfully')]";

		    try {
		     //   scrollToElement(toastXpath);                       // Scroll to toast element
		        safeExplicitWait(toastXpath, LONGWAIT);            // Wait until visible (long wait for toast)

		        if (safeIsDisplayed(toastXpath)) {
		            Reporter.log("✅ Toast message 'Order created successfully' is visible", true);
		            BasesetupUmaxx5G.passLog("✅ Toast message 'Order created successfully' is visible");
		        } else {
		            Reporter.log("❌ Toast message not visible", true);
		            BasesetupUmaxx5G.failLog("❌ Toast message 'Order created successfully' not displayed");
		            Assert.fail("Toast message not visible.");
		        }
		    } catch (Exception e) {
		        Reporter.log("❌ Exception while verifying toast: " + e.getMessage(), true);
		        BasesetupUmaxx5G.failLog("❌ Exception during toast visibility check: " + e.getMessage());
		        Assert.fail("Exception while verifying toast visibility.");
		    }
		}

		

}
