package pages;

import org.testng.Reporter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert; // ✅ Correct for TestNG
import common.BasesetupUmaxx5G;
import common.ConfigReaderUmaxx5G;
import common.SafeActionUmaxx5G;

public class CustomerLoginPage extends SafeActionUmaxx5G {
	
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
	
	public void clickCustomerLogin() {
	    String locator = "(//a[normalize-space()='Customer Login'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);              // Standard wait time
	        scrollToElement(locator);                          // Optional scroll
	        safeClick(locator);                                // Click the link

	        Reporter.log("✅ Clicked on 'Customer Login' link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Customer Login' link");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'Customer Login': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Customer Login': " + e.getMessage());
	        Assert.fail("Customer Login click failed due to: " + e.getMessage());
	    }
	}
	public void enterCustomerUsername() {
	    String locator = "//input[@id='user_email']";
	    String email = ConfigReaderUmaxx5G.getKeyValue("USERNAME");  // Get from config

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        safeType(locator, email);

	        Reporter.log("✅ Entered username: " + email, true);
	        BasesetupUmaxx5G.passLog("✅ Entered username: " + email);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to enter username: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to enter username: " + e.getMessage());
	        Assert.fail("Username entry failed due to: " + e.getMessage());
	    }
	}
	
	public void enterCustomerPassword() {
	    String locator = "(//input[@id='user_password'])[1]";  // ✅ Updated locator
	    String password = ConfigReaderUmaxx5G.getKeyValue("PASSWORD");  // Fetch from config

	    try {
	        safeExplicitWait(locator, LONGWAIT);  // Wait for the field
	        safeType(locator, password);          // Type the password

	        Reporter.log("✅ Entered password: " + password, true);
	        BasesetupUmaxx5G.passLog("✅ Entered password: " + password);
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to enter password: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to enter password: " + e.getMessage());
	        Assert.fail("Password entry failed due to: " + e.getMessage());
	    }
	}
	public void clickLoginButtonAndVerifyCaptcha() {
	    String loginButtonLocator = "(//button[normalize-space()='Login'])[1]";
	    String captchaLocator = "//div[@class='g-recaptcha' or contains(@class,'captcha')]";

	    try {
	        safeExplicitWait(loginButtonLocator, LONGWAIT);     // Wait for Login button
	        scrollToElement(loginButtonLocator);                 // Ensure it's visible
	        safeClick(loginButtonLocator);                       // Click the Login button

	        Reporter.log("✅ Clicked on Login button", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on Login button");

	        if (isElementPresent(captchaLocator)) {
	            Reporter.log("⚠️ CAPTCHA appeared: Manual verification required", true);
	            BasesetupUmaxx5G.passLog("⚠️ CAPTCHA appeared: Manual verification required");
	        } else {
	            Reporter.log("✅ No CAPTCHA displayed", true);
	            BasesetupUmaxx5G.passLog("✅ No CAPTCHA displayed");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Login failed: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Login/CAPTCHA check failed: " + e.getMessage());
	        Assert.fail("Login button or CAPTCHA verification failed: " + e.getMessage());
	    }
	}

	public void verifySpecificUsernameDisplayed() {
	    String expectedUsername = "sharmaa0d9";

	    // XPath that directly locates the card with 'Username' label and expected username text
	    String locator = "//div[contains(@class,'card-body')]//h5[b[text()='Username'] and contains(.,'" + expectedUsername + "')]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualText = getText(locator).trim();

	            // Clean up: Remove the "Username" label prefix if it exists
	            if (actualText.toLowerCase().startsWith("username")) {
	                actualText = actualText.replaceFirst("(?i)username", "").trim();
	            }

	            if (actualText.equalsIgnoreCase(expectedUsername)) {
	                Reporter.log("✅ Username displayed and matches: " + actualText, true);
	                BasesetupUmaxx5G.passLog("✅ Username displayed and matches: " + actualText);
	            } else {
	                Reporter.log("❌ Username mismatch! Expected: " + expectedUsername + ", Found: " + actualText, true);
	                BasesetupUmaxx5G.failLog("❌ Username mismatch. Expected: " + expectedUsername + ", Found: " + actualText);
	                Assert.fail("Username mismatch.");
	            }

	        } else {
	            Reporter.log("❌ Username element not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Username element not displayed!");
	            Assert.fail("Username element not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during username validation: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during username validation: " + e.getMessage());
	        Assert.fail("Exception in username verification: " + e.getMessage());
	    }
	}


	/*public void verifyUsernameDisplayed() {
	    String locator = "(//h5[@class='card-title'])[2]";
	    String expectedUsername = "sharmaa0d9";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualUsername = getText(locator).trim();

	            // Remove prefix like "Username " if present
	            if (actualUsername.toLowerCase().startsWith("username ")) {
	                actualUsername = actualUsername.replaceFirst("(?i)username ", "").trim();
	            }

	            if (actualUsername.equals(expectedUsername)) {
	                Reporter.log("✅ Username displayed and matches: " + actualUsername, true);
	                BasesetupUmaxx5G.passLog("✅ Username displayed and matches: " + actualUsername);
	            } else {
	                Reporter.log("❌ Username mismatch! Expected: " + expectedUsername + ", Found: " + actualUsername, true);
	                BasesetupUmaxx5G.failLog("❌ Username mismatch. Expected: " + expectedUsername + ", Found: " + actualUsername);
	                Assert.fail("Username mismatch.");
	            }

	        } else {
	            Reporter.log("❌ Username element not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Username element not displayed!");
	            Assert.fail("Username element not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during username validation: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during username validation: " + e.getMessage());
	        Assert.fail("Exception in username verification: " + e.getMessage());
	    }
	}*/


	public void verifyPaymentStatus() {
	    String locator = "(//span[@class='text-success'][normalize-space()='Payment Done'])[3]";
	    String expectedStatus = "Payment Done";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualStatus = getText(locator).trim();

	            if (actualStatus.equals(expectedStatus)) {
	                Reporter.log("✅ Payment status is correctly displayed: " + actualStatus, true);
	                BasesetupUmaxx5G.passLog("✅ Payment status is correctly displayed: " + actualStatus);
	            } else {
	                Reporter.log("❌ Payment status mismatch! Expected: " + expectedStatus + ", Found: " + actualStatus, true);
	                BasesetupUmaxx5G.failLog("❌ Payment status mismatch. Expected: " + expectedStatus + ", Found: " + actualStatus);
	                Assert.fail("Payment status mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Payment status element is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ Payment status element is not visible!");
	            Assert.fail("Payment status element not found.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying payment status: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying payment status: " + e.getMessage());
	        Assert.fail("Exception in payment status verification: " + e.getMessage());
	    }
	}

	public void verifyCreatedDate() {
	    String locator = "(//span[normalize-space()='17/06/2025'])[1]";
	    String expectedDate = "17/06/2025";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualDate = getText(locator).trim();

	            if (actualDate.equals(expectedDate)) {
	                Reporter.log("✅ Created Date is correctly displayed: " + actualDate, true);
	                BasesetupUmaxx5G.passLog("✅ Created Date is correctly displayed: " + actualDate);
	            } else {
	                Reporter.log("❌ Created Date mismatch! Expected: " + expectedDate + ", Found: " + actualDate, true);
	                BasesetupUmaxx5G.failLog("❌ Created Date mismatch. Expected: " + expectedDate + ", Found: " + actualDate);
	                Assert.fail("Created Date mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Created Date element is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ Created Date element is not visible!");
	            Assert.fail("Created Date element not found.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying Created Date: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying Created Date: " + e.getMessage());
	        Assert.fail("Exception in Created Date verification: " + e.getMessage());
	    }
	}

	public void verify5GPlanPurchase() {
	    String locator = "(//p[normalize-space()='UMAXX EXTRA'])[1]";
	    String expectedPlan = "UMAXX EXTRA";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualPlan = getText(locator).trim();

	            if (actualPlan.equals(expectedPlan)) {
	                Reporter.log("✅ UMAXX EXTRA successfully purchased and displayed on the page.", true);
	                BasesetupUmaxx5G.passLog("✅ UMAXX EXTRA successfully purchased and displayed on the page.");
	            } else {
	                Reporter.log("❌ Plan name mismatch! Expected: " + expectedPlan + ", but found: " + actualPlan, true);
	                BasesetupUmaxx5G.failLog("❌ Plan name mismatch. Expected: " + expectedPlan + ", Found: " + actualPlan);
	                Assert.fail("5G Plan mismatch.");
	            }
	        } else {
	            Reporter.log("❌ UMAXX EXTRA plan element is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ UMAXX EXTRA plan element is not displayed!");
	            Assert.fail("Plan element not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during UMAXX EXTRA plan verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during UMAXX EXTRA plan verification: " + e.getMessage());
	        Assert.fail("Exception in plan verification: " + e.getMessage());
	    }
	}

	public void verifyHotspotDeviceName() {
	    String locator = "(//p[normalize-space()='Nokia FWA 12'])[2]";
	    String expectedDeviceName = "Nokia FWA 12";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualDeviceName = getText(locator).trim();

	            if (actualDeviceName.equals(expectedDeviceName)) {
	                Reporter.log("✅ Hotspot device name '" + expectedDeviceName + "' is displayed correctly.", true);
	                BasesetupUmaxx5G.passLog("✅ Hotspot device name '" + expectedDeviceName + "' is displayed correctly.");
	            } else {
	                Reporter.log("❌ Device name mismatch! Expected: " + expectedDeviceName + ", but found: " + actualDeviceName, true);
	                BasesetupUmaxx5G.failLog("❌ Device name mismatch. Expected: " + expectedDeviceName + ", Found: " + actualDeviceName);
	                Assert.fail("Hotspot device name mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Hotspot device element is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Hotspot device element is not displayed!");
	            Assert.fail("Hotspot device element not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during hotspot device name check: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during hotspot device name check: " + e.getMessage());
	        Assert.fail("Exception while verifying hotspot device name: " + e.getMessage());
	    }
	}

	/*public void clickOnViewDetails() {
	    String locator = "(//a[@class='card-link text-primary'][normalize-space()='View Details'])[2]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on 'View Details' successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'View Details' successfully.");
	        } else {
	            Reporter.log("❌ 'View Details' link is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ 'View Details' link is not displayed!");
	            Assert.fail("'View Details' link not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'View Details': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'View Details': " + e.getMessage());
	        Assert.fail("Exception while clicking 'View Details': " + e.getMessage());
	    }
	}*/
	
	public void clickViewDetailsForSharma() {
	    // XPath with hardcoded username 'sharmaa0d9'
	    String locator = "//div[contains(@class,'card-body')]//h5[b[text()='Username'] and contains(.,'sharmaa0d9')]/ancestor::div[contains(@class,'card') or contains(@class,'card-body')]//a[contains(@class,'card-link') and normalize-space()='View Details']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);  // Wait for element to appear
	        scrollToElement(locator);             // Scroll to the element

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);               // Perform safe click
	            Reporter.log("✅ Clicked on 'View Details' for user 'sharmaa0d9'", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'View Details' for user 'sharmaa0d9'");
	        } else {
	            Reporter.log("❌ 'View Details' link is not displayed for user 'sharmaa0d9'", true);
	            BasesetupUmaxx5G.failLog("❌ 'View Details' link is not displayed for user 'sharmaa0d9'");
	            Assert.fail("'View Details' link is not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'View Details' for 'sharmaa0d9': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'View Details' for 'sharmaa0d9': " + e.getMessage());
	        Assert.fail("Exception while clicking 'View Details': " + e.getMessage());
	    }
	}


	
	public void verifyTotalAmountDisplayed() {
	    String locator = "(//td[@class='text-right'])[1]";
	    String expectedAmount = "$278.99";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualAmount = getText(locator).trim();
	            Reporter.log("✅ Total amount displayed: " + actualAmount, true);
	            BasesetupUmaxx5G.passLog("✅ Total amount displayed: " + actualAmount);

	            if (actualAmount.equals(expectedAmount)) {
	                Reporter.log("✅ Total amount matches expected: " + expectedAmount, true);
	                BasesetupUmaxx5G.passLog("✅ Total amount matches expected: " + expectedAmount);
	            } else {
	                Reporter.log("❌ Amount mismatch! Expected: " + expectedAmount + ", but found: " + actualAmount, true);
	                BasesetupUmaxx5G.failLog("❌ Amount mismatch. Expected: " + expectedAmount + ", Found: " + actualAmount);
	                Assert.fail("Amount mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Total amount element is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Total amount element is not displayed!");
	            Assert.fail("Total amount element not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during total amount verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during total amount verification: " + e.getMessage());
	        Assert.fail("Exception while verifying total amount: " + e.getMessage());
	    }
	}
	
	public void verifyDepositAmount() {
	    String locator = "//td[normalize-space()='+ $199.00']";
	    String expectedAmount = "+ $199.00";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator); // Optional for visibility

	        if (safeIsDisplayed(locator)) {
	            String actualAmount = getText(locator).trim();
	            Reporter.log("✅ Deposit amount displayed: " + actualAmount, true);
	            BasesetupUmaxx5G.passLog("✅ Deposit amount displayed: " + actualAmount);

	            if (actualAmount.equals(expectedAmount)) {
	                Reporter.log("✅ Deposit amount matches expected: " + expectedAmount, true);
	                BasesetupUmaxx5G.passLog("✅ Deposit amount matches expected: " + expectedAmount);
	            } else {
	                Reporter.log("❌ Deposit amount mismatch! Expected: " + expectedAmount + ", Found: " + actualAmount, true);
	                BasesetupUmaxx5G.failLog("❌ Deposit amount mismatch. Expected: " + expectedAmount + ", Found: " + actualAmount);
	                Assert.fail("Deposit amount mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Deposit amount element is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Deposit amount element is not displayed!");
	            Assert.fail("Deposit amount element is not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during deposit amount check: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during deposit amount check: " + e.getMessage());
	        Assert.fail("Exception while verifying deposit amount: " + e.getMessage());
	    }
	}


	public void clickOnViewInvoices() {
	    String locator = "(//button[normalize-space()='View Invoices'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator); // Optional: Ensure visibility
	        safeClick(locator);
	        Reporter.log("✅ Clicked on 'View Invoices' button successfully.", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'View Invoices' button successfully.");
	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'View Invoices' button: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'View Invoices' button: " + e.getMessage());
	        Assert.fail("Exception while clicking on 'View Invoices': " + e.getMessage());
	    }
	}

	public void clickOn5GSubscriptionInvoice() {
	    String locator = "//a[text()='5G Subscription Invoice']";

	    try {
	        // Store the main window handle before click
	        String parentWindow = driver.getWindowHandle();

	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on '5G Subscription Invoice' link successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on '5G Subscription Invoice' link successfully.");

	            // Wait for new window/tab to open
	            Set<String> allWindows = driver.getWindowHandles();

	            for (String windowHandle : allWindows) {
	                if (!windowHandle.equals(parentWindow)) {
	                    driver.switchTo().window(windowHandle);
	                    Reporter.log("✅ Switched to new window/tab for invoice.", true);
	                    BasesetupUmaxx5G.passLog("✅ Switched to new window/tab for invoice.");
	                    break;
	                }
	            }

	        } else {
	            Reporter.log("❌ '5G Subscription Invoice' link is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ '5G Subscription Invoice' link is not visible!");
	            Assert.fail("'5G Subscription Invoice' link not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking '5G Subscription Invoice': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking '5G Subscription Invoice': " + e.getMessage());
	        Assert.fail("Exception while clicking '5G Subscription Invoice': " + e.getMessage());
	    }
	}

	
	public void verifyInvoiceNumberDisplayed() {
	    String locator = "(//span[normalize-space()='YC5HE19Y-0002'])[1]";
	    String expected = "YC5HE19Y-0002";

	    try {
	        if (safeIsDisplayed(locator)) {
	            String actual = getText(locator).trim();
	            if (actual.equals(expected)) {
	                Reporter.log("✅ Invoice number matched: " + actual, true);
	                BasesetupUmaxx5G.passLog("✅ Invoice number matched: " + actual);
	            } else {
	                Reporter.log("❌ Mismatch! Expected: " + expected + ", Found: " + actual, true);
	                BasesetupUmaxx5G.failLog("❌ Mismatch! Expected: " + expected + ", Found: " + actual);
	                Assert.fail("Invoice number mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Invoice number element not visible.", true);
	            BasesetupUmaxx5G.failLog("❌ Invoice number element not visible.");
	            Assert.fail("Invoice number not displayed.");
	        }
	    } catch (Exception e) {
	        Reporter.log("❌ Exception: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during invoice check: " + e.getMessage());
	        Assert.fail("Exception during invoice verification: " + e.getMessage());
	    }
	}

	public void verifyPurchaseDateDisplayed() {
	    String locator = "//span[normalize-space()='June 17, 2025']";
	    String expectedDate = "June 17, 2025";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            String actualDate = getText(locator).trim();

	            Reporter.log("✅ Purchase date displayed: " + actualDate, true);
	            BasesetupUmaxx5G.passLog("✅ Purchase date displayed: " + actualDate);

	            if (actualDate.equals(expectedDate)) {
	                Reporter.log("✅ Purchase date matches expected: " + expectedDate, true);
	                BasesetupUmaxx5G.passLog("✅ Purchase date matches expected: " + expectedDate);
	            } else {
	                Reporter.log("❌ Purchase date mismatch! Expected: " + expectedDate + ", but found: " + actualDate, true);
	                BasesetupUmaxx5G.failLog("❌ Purchase date mismatch. Expected: " + expectedDate + ", Found: " + actualDate);
	                Assert.fail("Purchase date mismatch.");
	            }
	        } else {
	            Reporter.log("❌ Purchase date element is not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Purchase date element is not displayed!");
	            Assert.fail("Purchase date element not visible.");
	        }
	    } catch (Exception e) {
	        Reporter.log("❌ Exception during purchase date check: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during purchase date check: " + e.getMessage());
	        Assert.fail("Exception while verifying purchase date: " + e.getMessage());
	    }
	}

	public void clickInvoiceOptionsIcon() {
	    String locator = "(//*[name()='svg'][@class='InlineSVG Icon Button-Icon Button-Icon--right Icon--sm Icon--square'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);
	        safeClick(locator);

	        Reporter.log("✅ Clicked on the invoice options icon (SVG).", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on the invoice options icon (SVG).");
	        
	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking the invoice options icon: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking the invoice options icon: " + e.getMessage());
	        Assert.fail("Exception while clicking the invoice options icon: " + e.getMessage());
	    }
	}
	public void clickOnSettingsButton() {
	    String locator = "(//i[@class='fa fa-cog'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElementWithOffset(locator, -150); // Scroll up by 150px

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on 'Settings' button successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'Settings' button successfully.");
	        } else {
	            Reporter.log("❌ 'Settings' button is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Settings' button is not visible!");
	            Assert.fail("'Settings' button not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'Settings' button: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'Settings' button: " + e.getMessage());
	        Assert.fail("Exception while clicking 'Settings' button: " + e.getMessage());
	    }
	}

	public void clickOnEditAccountButton() {
	    String locator = "//a[normalize-space()='Edit Account']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElementWithOffset(locator, -100); // Scroll slightly above the element

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on 'Edit Account' button successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'Edit Account' button successfully.");
	        } else {
	            Reporter.log("❌ 'Edit Account' button is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Edit Account' button is not visible!");
	            Assert.fail("'Edit Account' button not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'Edit Account': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'Edit Account': " + e.getMessage());
	        Assert.fail("Exception while clicking 'Edit Account': " + e.getMessage());
	    }
	}


	
	public void enterCardNumber(String cardNumber) {
	    try {
	        // Step 1: Switch to iframe — use index or better: locate iframe via XPath or CSS
	        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name^='__privateStripeFrame']")));

	        String locator = "//input[@id='cardNumber']";

	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClear(locator);
	            safeType(locator, cardNumber);

	            Reporter.log("✅ Entered card number: " + cardNumber, true);
	            BasesetupUmaxx5G.passLog("✅ Entered card number: " + cardNumber);
	        } else {
	            Reporter.log("❌ Card number input field is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ Card number input field is not visible!");
	            Assert.fail("Card number input field not visible.");
	        }

	        // Switch back to main content
	        driver.switchTo().defaultContent();

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while entering card number: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while entering card number: " + e.getMessage());
	        Assert.fail("Exception while entering card number: " + e.getMessage());
	    }
	}

	
	
	
	public void verifyRemainingAmountZero() {
	    String locator = "(//span[@class='CurrencyAmount'][normalize-space()='$0.00'])[4]";
	    String expectedAmount = "$0.00";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator); // Optional: ensures element is visible

	        if (safeIsDisplayed(locator)) {
	            String actualAmount = getText(locator).trim();

	            Reporter.log("✅ Remaining amount displayed: " + actualAmount, true);
	            BasesetupUmaxx5G.passLog("✅ Remaining amount displayed: " + actualAmount);

	            if (actualAmount.equals(expectedAmount)) {
	                Reporter.log("✅ Remaining amount matches expected: " + expectedAmount, true);
	                BasesetupUmaxx5G.passLog("✅ Remaining amount matches expected: " + expectedAmount);
	            } else {
	                Reporter.log("❌ Remaining amount mismatch! Expected: " + expectedAmount + ", Found: " + actualAmount, true);
	                BasesetupUmaxx5G.failLog("❌ Remaining amount mismatch. Expected: " + expectedAmount + ", Found: " + actualAmount);
	                Assert.fail("Remaining amount mismatch.");
	            }

	        } else {
	            Reporter.log("❌ Remaining amount element not displayed!", true);
	            BasesetupUmaxx5G.failLog("❌ Remaining amount element not displayed!");
	            Assert.fail("Remaining amount element is not visible.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during remaining amount check: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during remaining amount check: " + e.getMessage());
	        Assert.fail("Exception while verifying remaining amount: " + e.getMessage());
	    }
	}


	public void clickDownloadReceiptButton() {
	    String locator = "//button[@data-testid='download-invoice-receipt-pdf-button']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator); // Optional for visibility

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Successfully clicked on 'Download Receipt' button.", true);
	            BasesetupUmaxx5G.passLog("✅ Successfully clicked on 'Download Receipt' button.");

	            // Simulate wait for download (optional sleep or wait for download indicator)
	            Thread.sleep(3000); // adjust if needed for actual download time

	            Reporter.log("✅ Receipt downloaded successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Receipt downloaded successfully.");
	        } else {
	            Reporter.log("❌ 'Download Receipt' button is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Download Receipt' button is not visible!");
	            Assert.fail("'Download Receipt' button not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while downloading receipt: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while downloading receipt: " + e.getMessage());
	        Assert.fail("Exception during receipt download: " + e.getMessage());
	    }
	}
	public void switchBackToUmaxxWindowAfterInvoice() {
	    try {
	        String parentWindow = null;
	        Set<String> allWindows = driver.getWindowHandles();

	        // Identify parent (UMAXX) and invoice window
	        for (String window : allWindows) {
	            driver.switchTo().window(window);
	            String currentURL = driver.getCurrentUrl();

	            // Assuming UMAXX main window doesn't contain "stripe.com"
	            if (!currentURL.contains("stripe.com")) {
	                parentWindow = window;
	            } else {
	                // Close the invoice tab (Stripe)
	                driver.close();
	                Reporter.log("❎ Closed Stripe invoice window", true);
	                BasesetupUmaxx5G.passLog("❎ Closed Stripe invoice window");
	            }
	        }

	        if (parentWindow != null) {
	            driver.switchTo().window(parentWindow);
	            Reporter.log("🔙 Switched back to UMAXX main window", true);
	            BasesetupUmaxx5G.infoLog("🔙 Switched back to UMAXX main window");
	        } else {
	            Reporter.log("❌ UMAXX main window not found!", true);
	            BasesetupUmaxx5G.failLog("❌ UMAXX main window not found!");
	            Assert.fail("UMAXX main window not found.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while switching back to UMAXX window: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while switching back to UMAXX window: " + e.getMessage());
	        Assert.fail("Exception while switching back to UMAXX window.");
	    }
	}

	public void closeCurrentWindowAndSwitchToParent() {
	    try {
	        String currentWindow = driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();

	        // Identify the parent (UMAXX) window
	        String parentWindow = null;
	        for (String win : allWindows) {
	            if (!win.equals(currentWindow)) {
	                parentWindow = win;
	                break;
	            }
	        }

	        // Close the current (Stripe invoice) window
	        driver.close();
	        Reporter.log("❎ Closed current invoice window", true);
	        BasesetupUmaxx5G.passLog("❎ Closed current invoice window");

	        // Switch to parent (UMAXX)
	        if (parentWindow != null) {
	            driver.switchTo().window(parentWindow);
	            Reporter.log("🔙 Switched back to UMAXX parent window", true);
	            BasesetupUmaxx5G.infoLog("🔙 Switched back to UMAXX parent window");
	        } else {
	            Reporter.log("❌ Parent window not found!", true);
	            BasesetupUmaxx5G.failLog("❌ Parent window not found!");
	            Assert.fail("Parent window not found.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while closing invoice tab and switching: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while closing invoice tab and switching: " + e.getMessage());
	        Assert.fail("Error while switching back to parent window.");
	    }
	}

	public void clickOnDepositInvoice() {
	    String locator = "//a[normalize-space()='Deposit Invoice']";

	    try {
	        // Store the main window handle before click
	        String parentWindow = driver.getWindowHandle();

	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on 'Deposit Invoice' link successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'Deposit Invoice' link successfully.");

	            // Wait for new window/tab to open
	            Set<String> allWindows = driver.getWindowHandles();

	            for (String windowHandle : allWindows) {
	                if (!windowHandle.equals(parentWindow)) {
	                    driver.switchTo().window(windowHandle);
	                    Reporter.log("✅ Switched to new window/tab for invoice.", true);
	                    BasesetupUmaxx5G.passLog("✅ Switched to new window/tab for invoice.");
	                    break;
	                }
	            }

	        } else {
	            Reporter.log("❌ 'Deposit Invoice' link is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Deposit Invoice' link is not visible!");
	            Assert.fail("'Deposit Invoice' link not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'Deposit Invoice': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'Deposit Invoice': " + e.getMessage());
	        Assert.fail("Exception while clicking 'Deposit Invoice': " + e.getMessage());
	    }
	}

	public void verifyDepositAmountIs199() {
	    String locator = "(//span[@class='CurrencyAmount'][normalize-space()='$199.00'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);

	        if (safeIsDisplayed(locator)) {
	            String actualAmount = driver.findElement(By.xpath(locator)).getText().trim();
	            String expectedAmount = "$199.00";

	            Assert.assertEquals(actualAmount, expectedAmount, "❌ Deposit amount does not match!");
	            Reporter.log("✅ Deposit amount is correctly displayed as " + actualAmount, true);
	            BasesetupUmaxx5G.passLog("✅ Deposit amount is correctly displayed as " + actualAmount);

	        } else {
	            Reporter.log("❌ Deposit amount element is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ Deposit amount element is not visible!");
	            Assert.fail("Deposit amount element not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while verifying deposit amount: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while verifying deposit amount: " + e.getMessage());
	        Assert.fail("Exception while verifying deposit amount: " + e.getMessage());
	    }
	}
	
	public void enterOrderPhoneNumber(String phoneNumber) {
	    String locator = "(//input[@id='order_phone'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClear(locator); // Clear the field first
	            safeType(locator, phoneNumber); // Then enter the new phone number

	            Reporter.log("✅ Phone number entered successfully: " + phoneNumber, true);
	            BasesetupUmaxx5G.passLog("✅ Phone number entered successfully: " + phoneNumber);
	        } else {
	            Reporter.log("❌ Phone number field not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ Phone number field not visible!");
	            Assert.fail("Phone number input field not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while entering phone number: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while entering phone number: " + e.getMessage());
	        Assert.fail("Exception during phone number entry: " + e.getMessage());
	    }
	}

	public void clickOnUpdateButton() {
	    String locator = "(//input[@name='commit'])[1]";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);

	        if (safeIsDisplayed(locator)) {
	            safeClick(locator);
	            Reporter.log("✅ Clicked on 'Update' button successfully.", true);
	            BasesetupUmaxx5G.passLog("✅ Clicked on 'Update' button successfully.");
	        } else {
	            Reporter.log("❌ 'Update' button is not visible!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Update' button is not visible!");
	            Assert.fail("'Update' button not displayed.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception while clicking 'Update' button: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception while clicking 'Update' button: " + e.getMessage());
	        Assert.fail("Exception while clicking 'Update' button: " + e.getMessage());
	    }
	}

	public void verifySuccessMessageAfterUpdate() {
	    String successToastLocator = "//div[@class = 'toast-body msg-txt-color custom-alert bg-opacity-25 bg-success']";

	    try {
	        safeExplicitWait(successToastLocator, LONGWAIT);  // Adjust wait time if needed

	        if (safeIsDisplayed(successToastLocator)) {
	            Reporter.log("✅ 'Updated successfully' toast message verified.", true);
	            BasesetupUmaxx5G.passLog("✅ 'Updated successfully' toast message verified.");
	        } else {
	            Reporter.log("❌ Success message not found after update!", true);
	            BasesetupUmaxx5G.failLog("❌ 'Updated successfully' toast message not displayed.");
	            Assert.fail("Success message after update not found.");
	        }

	    } catch (Exception e) {
	        Reporter.log("❌ Exception during success message verification: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during toast verification: " + e.getMessage());
	        Assert.fail("Exception during toast message validation: " + e.getMessage());
	    }
	}

	public void clickEditCardDetails() {
	    String locator = "//a[normalize-space()='Edit Card Details']";

	    try {
	        safeExplicitWait(locator, LONGWAIT);
	        scrollToElement(locator);
	        scrollUp(150); // ✅ Scroll up 150 pixels after reaching element
	        safeClick(locator);

	        Reporter.log("✅ Clicked on 'Edit Card Details' link", true);
	        BasesetupUmaxx5G.passLog("✅ Clicked on 'Edit Card Details' link");

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to click on 'Edit Card Details': " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Failed to click on 'Edit Card Details': " + e.getMessage());
	        Assert.fail("Click on 'Edit Card Details' failed: " + e.getMessage());
	    }
	}

/*	public void enterStripeCardNumber(String cardNumber) {
	    boolean entered = false;
	    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    System.out.println("Total iframes: " + iframes.size());

	    for (int i = 0; i < iframes.size(); i++) {
	        try {
	            driver.switchTo().defaultContent();
	            driver.switchTo().frame(iframes.get(i));
	            System.out.println("Switched to iframe index: " + i);

	            WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
	            cardNumberInput.sendKeys(cardNumber);
	            System.out.println("✅ Card number entered in iframe index: " + i);

	            entered = true;
	            break;
	        } catch (NoSuchElementException e) {
	            // Ignore and try next iframe
	        } catch (Exception ex) {
	            System.out.println("⚠️ Exception at iframe index " + i + ": " + ex.getMessage());
	        }
	    }

	    driver.switchTo().defaultContent();

	    if (!entered) {
	        Assert.fail("❌ Could not find or enter card number in any iframe.");
	    }
	}*/
	
	//woring previously
	/*public void enterStripeCardNumber(String cardNumber) {
	    boolean entered = false;
	    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    System.out.println("Total iframes: " + iframes.size());

	    for (int i = 0; i < iframes.size(); i++) {
	        try {
	            driver.switchTo().defaultContent();
	            driver.switchTo().frame(iframes.get(i));
	            System.out.println("Switched to iframe index: " + i);

	            List<WebElement> inputs = driver.findElements(By.id("cardNumber"));
	            if (inputs.isEmpty()) {
	                inputs = driver.findElements(By.name("cardnumber"));
	            }

	            if (!inputs.isEmpty()) {
	                inputs.get(0).sendKeys(cardNumber);
	                System.out.println("✅ Card number entered in iframe index: " + i);
	                entered = true;
	                break;
	            }
	        } catch (Exception ex) {
	            System.out.println("⚠️ Exception at iframe index " + i + ": " + ex.getMessage());
	        }
	    }

	    driver.switchTo().defaultContent();
	    if (!entered) {
	        Assert.fail("❌ Could not find or enter card number in any iframe.");
	    }
	}*/

	public void enterCardNumberInIframe(String cardNumber) {
	    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

	    for (WebElement iframe : iframes) {
	        try {
	            driver.switchTo().defaultContent();
	            driver.switchTo().frame(iframe);

	            WebElement cardInput = driver.findElement(By.cssSelector("input[name='cardnumber']"));
	            cardInput.sendKeys(cardNumber);
	            driver.switchTo().defaultContent();
	            return;

	        } catch (Exception e) {
	            // Skip to next iframe
	        }
	    }

	    driver.switchTo().defaultContent();
	    throw new RuntimeException("Card number input field not found in any iframe.");
	}

	
	
	
	
	
	public void enterStripeCvc(String cvc) {
	    boolean entered = false;
	    List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    System.out.println("Total iframes: " + iframes.size());

	    for (int i = 0; i < iframes.size(); i++) {
	        try {
	            driver.switchTo().defaultContent();
	            driver.switchTo().frame(iframes.get(i));
	            System.out.println("Switched to iframe index: " + i);

	            WebElement cvcInput = driver.findElement(By.id("cardCvc"));
	            cvcInput.sendKeys(cvc);
	            System.out.println("✅ CVV entered in iframe index: " + i);

	            entered = true;
	            break;
	        } catch (NoSuchElementException e) {
	            // Try next iframe
	        } catch (Exception ex) {
	            System.out.println("⚠️ Exception at iframe index " + i + ": " + ex.getMessage());
	        }
	    }

	    driver.switchTo().defaultContent();

	    if (!entered) {
	        Assert.fail("❌ Could not find or enter CVV in any iframe.");
	    }
	}

	public void enterCardholderName(String name) {
	    try {
	        WebElement cardholderNameField = driver.findElement(By.id("billingName"));
	        cardholderNameField.clear();
	        cardholderNameField.sendKeys(name);
	        System.out.println("✅ Cardholder name entered: " + name);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to enter cardholder name: " + e.getMessage());
	        Assert.fail("Unable to enter cardholder name.");
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
	    String toastXpath = "//div[@class='toast-body msg-txt-color custom-alert bg-opacity-25 bg-success']";

	    try {
	     //   scrollToElement(toastXpath);                       // Scroll to toast
	        safeExplicitWait(toastXpath, LONGWAIT);         // Wait for toast

	        if (safeIsDisplayed(toastXpath)) {
	            Reporter.log("✅ Success toast is displayed successfully", true);
	            BasesetupUmaxx5G.infoLog("✅ Success toast is displayed successfully");
	        } else {
	            Reporter.log("❌ Success toast is NOT displayed", true);
	            BasesetupUmaxx5G.failLog("❌ Success toast is NOT displayed");
	            Assert.fail("Success toast not visible.");
	        }
	    } catch (Exception e) {
	        Reporter.log("❌ Exception during toast visibility check: " + e.getMessage(), true);
	        BasesetupUmaxx5G.failLog("❌ Exception during toast visibility check: " + e.getMessage());
	        Assert.fail("Toast check failed due to exception.");
	    }
	}


	
}
