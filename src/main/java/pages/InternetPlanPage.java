package pages;

import org.testng.Reporter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.BasesetupUmaxx5G;
import common.SafeActionUmaxx5G;

public class InternetPlanPage extends SafeActionUmaxx5G {

    public void verifyPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "UMAXX - BIGGER FASTER STRONGER UMAXX 5G TV, IPTV";

        Reporter.log("📄 Page Title: " + actualTitle, true);
        BasesetupUmaxx5G.infoLog("📄 Page Title: " + actualTitle);

        Assert.assertEquals(actualTitle.trim(), expectedTitle.trim(), "❌ Page title does not match!");

        Reporter.log("✅ Page title verification passed", true);
        BasesetupUmaxx5G.infoLog("✅ Page title verification passed");
    }

    String navbarToggleLoc = "//span[@class='navbar-toggler-icon']";

    public void clickNavbarToggle() {
        safeExplicitWait(navbarToggleLoc, LONGWAIT);
        scrollToElementWithOffset(navbarToggleLoc, -100); // scroll slightly up if needed
        safeClick(navbarToggleLoc);

        Reporter.log("✅ Clicked the Navbar Toggle button", true);
        BasesetupUmaxx5G.infoLog("✅ Clicked the Navbar Toggle button");
    }

    String internetPlansLinkLoc = "(//a[normalize-space()='5G Internet Plans'])[1]";

    public void click5GInternetPlanLink() {
        safeExplicitWait(internetPlansLinkLoc, LONGWAIT);
        safeClick(internetPlansLinkLoc);

        Reporter.log("✅ Clicked on 5G Internet Plans link", true);
        BasesetupUmaxx5G.passLog("✅ Clicked on 5G Internet Plans link");
    }

    String internetPlansHeadingLoc = "(//h1[normalize-space()='5G Internet Plans'])[1]";

    public void verify5GInternetPlansHeadingIsDisplayed() {
        safeExplicitWait(internetPlansHeadingLoc, LONGWAIT);

        String actualText = getText(internetPlansHeadingLoc).trim();
        String expectedText = "5G Internet Plans";

        Reporter.log("📄 Found heading: " + actualText, true);
        BasesetupUmaxx5G.infoLog("📄 Found heading: " + actualText);

        Assert.assertEquals(actualText, expectedText, "❌ Heading text does not match!");

        Reporter.log("✅ 5G Internet Plans heading text is correct", true);
        BasesetupUmaxx5G.infoLog("✅ 5G Internet Plans heading text is correct");
    }

    public void verifyMilitaryGradeSpeedParagraph() {
        String locator = "//p[@class='sec-desc text-center mb-0 top-section-text']";
        String expectedText = "Experience Military Grade Speed and Security";

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();
            Reporter.log("📄 Paragraph text found: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Paragraph text found: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Paragraph text does not match!");
            Reporter.log("✅ Paragraph text is correct", true);
            BasesetupUmaxx5G.passLog("✅ Paragraph text is correct");
        } else {
            Reporter.log("❌ Paragraph not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Paragraph not displayed");
            Assert.fail("Paragraph element not displayed");
        }
    }

    public void verifyPrivacySecurityLinkText() {
        String locator = "(//a[contains(text(),\"See Why UMAXX Offers America's Best Privacy & Secu\")])[1]";
        String expectedText = "See Why UMAXX Offers America's Best Privacy & Security";

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();
            Reporter.log("📄 Link text found: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Link text found: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Link text does not match!");
            Reporter.log("✅ Privacy & Security link text is correct", true);
            BasesetupUmaxx5G.passLog("✅ Privacy & Security link text is correct");
        } else {
            Reporter.log("❌ Privacy & Security link not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Privacy & Security link not displayed");
            Assert.fail("Privacy & Security link element not displayed");
        }
    }
    public void verifyAndScrollToStarterPlan() {
        String starterPlanLocator = "(//b[normalize-space()='STARTER'])[1]";
        
        safeExplicitWait(starterPlanLocator, LONGWAIT);
        
        scrollToElement(starterPlanLocator);  // use your existing scroll method
        
        if (safeIsDisplayed(starterPlanLocator)) {
            String actualText = getText(starterPlanLocator).trim();
            Reporter.log("📄 Found plan text: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found plan text: " + actualText);
            
            Assert.assertEquals(actualText, "STARTER", "❌ Plan text does not match 'STARTER'!");
            Reporter.log("✅ 'STARTER' plan is displayed and scrolled into view", true);
            BasesetupUmaxx5G.passLog("✅ 'STARTER' plan is displayed and scrolled into view");
        } else {
            Reporter.log("❌ 'STARTER' plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ 'STARTER' plan element is not displayed");
            Assert.fail("'STARTER' plan element is not displayed");
        }
    }

    public void verifyAndScrollToExtraPlan() {
        String extraPlanLocator = "(//b[normalize-space()='EXTRA'])[1]";
        
        safeExplicitWait(extraPlanLocator, LONGWAIT);
        
        scrollToElement(extraPlanLocator);  // reuse your existing scroll method
        
        if (safeIsDisplayed(extraPlanLocator)) {
            String actualText = getText(extraPlanLocator).trim();
            Reporter.log("📄 Found plan text: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found plan text: " + actualText);
            
            Assert.assertEquals(actualText, "EXTRA", "❌ Plan text does not match 'EXTRA'!");
            Reporter.log("✅ 'EXTRA' plan is displayed and scrolled into view", true);
            BasesetupUmaxx5G.passLog("✅ 'EXTRA' plan is displayed and scrolled into view");
        } else {
            Reporter.log("❌ 'EXTRA' plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ 'EXTRA' plan element is not displayed");
            Assert.fail("'EXTRA' plan element is not displayed");
        }
    }
    public void verifyAndScrollToUltraPlan() {
        String ultraPlanLocator = "(//b[normalize-space()='ULTRA'])[1]";
        
        safeExplicitWait(ultraPlanLocator, LONGWAIT);
        
        scrollToElement(ultraPlanLocator);  // using your existing scroll method
        
        if (safeIsDisplayed(ultraPlanLocator)) {
            String actualText = getText(ultraPlanLocator).trim();
            Reporter.log("📄 Found plan text: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found plan text: " + actualText);
            
            Assert.assertEquals(actualText, "ULTRA", "❌ Plan text does not match 'ULTRA'!");
            Reporter.log("✅ 'ULTRA' plan is displayed and scrolled into view", true);
            BasesetupUmaxx5G.passLog("✅ 'ULTRA' plan is displayed and scrolled into view");
        } else {
            Reporter.log("❌ 'ULTRA' plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ 'ULTRA' plan element is not displayed");
            Assert.fail("'ULTRA' plan element is not displayed");
        }
        
    }
    public void verifyAndScrollToPremiumPlan() {
        String premiumPlanLocator = "(//b[normalize-space()='PREMIUM'])[1]";
        
        safeExplicitWait(premiumPlanLocator, LONGWAIT);
        
        scrollToElement(premiumPlanLocator);  // your existing scroll method
        
        if (safeIsDisplayed(premiumPlanLocator)) {
            String actualText = getText(premiumPlanLocator).trim();
            Reporter.log("📄 Found plan text: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found plan text: " + actualText);
            
            Assert.assertEquals(actualText, "PREMIUM", "❌ Plan text does not match 'PREMIUM'!");
            Reporter.log("✅ 'PREMIUM' plan is displayed and scrolled into view", true);
            BasesetupUmaxx5G.passLog("✅ 'PREMIUM' plan is displayed and scrolled into view");
        } else {
            Reporter.log("❌ 'PREMIUM' plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ 'PREMIUM' plan element is not displayed");
            Assert.fail("'PREMIUM' plan element is not displayed");
        }
    }

    public void verifyAndScrollStarterPrice() {
        String starterPriceLocator = "(//span[normalize-space()='39'])[1]";
        
        safeExplicitWait(starterPriceLocator, LONGWAIT);
        
        scrollToElement(starterPriceLocator);  // use your existing scroll method
        
        if (safeIsDisplayed(starterPriceLocator)) {
            String actualPrice = getText(starterPriceLocator).trim();
            Reporter.log("📄 Found Starter plan price: " + actualPrice, true);
            BasesetupUmaxx5G.infoLog("📄 Found Starter plan price: " + actualPrice);
            
            Assert.assertEquals(actualPrice, "39", "❌ Starter plan price does not match '39'!");
            Reporter.log("✅ Starter plan price is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ Starter plan price is correct and visible");
        } else {
            Reporter.log("❌ Starter plan price element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Starter plan price element is not displayed");
            Assert.fail("Starter plan price element is not displayed");
        }
    }
    
    public void verifyAndScrollExtraPrice() {
        String extraPriceLocator = "(//span[normalize-space()='79'])[1]";
        
        safeExplicitWait(extraPriceLocator, LONGWAIT);
        
        scrollToElement(extraPriceLocator);  // use your existing scroll method
        
        if (safeIsDisplayed(extraPriceLocator)) {
            String actualPrice = getText(extraPriceLocator).trim();
            Reporter.log("📄 Found Extra plan price: " + actualPrice, true);
            BasesetupUmaxx5G.infoLog("📄 Found Extra plan price: " + actualPrice);
            
            Assert.assertEquals(actualPrice, "79", "❌ Extra plan price does not match '79'!");
            Reporter.log("✅ Extra plan price is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ Extra plan price is correct and visible");
        } else {
            Reporter.log("❌ Extra plan price element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Extra plan price element is not displayed");
            Assert.fail("Extra plan price element is not displayed");
        }
    }
    public void verifyAndScrollUltraPrice() {
        String ultraPriceLocator = "(//span[normalize-space()='119'])[1]";
        
        safeExplicitWait(ultraPriceLocator, LONGWAIT);
        
        scrollToElement(ultraPriceLocator);  // your existing scroll method
        
        if (safeIsDisplayed(ultraPriceLocator)) {
            String actualPrice = getText(ultraPriceLocator).trim();
            Reporter.log("📄 Found Ultra plan price: " + actualPrice, true);
            BasesetupUmaxx5G.infoLog("📄 Found Ultra plan price: " + actualPrice);
            
            Assert.assertEquals(actualPrice, "119", "❌ Ultra plan price does not match '119'!");
            Reporter.log("✅ Ultra plan price is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ Ultra plan price is correct and visible");
        } else {
            Reporter.log("❌ Ultra plan price element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Ultra plan price element is not displayed");
            Assert.fail("Ultra plan price element is not displayed");
        }
    }
    public void verifyAndScrollPremiumPrice() {
        String premiumPriceLocator = "(//span[normalize-space()='139'])[1]";
        
        safeExplicitWait(premiumPriceLocator, LONGWAIT);
        
        scrollToElement(premiumPriceLocator);  // Scroll using your predefined method
        
        if (safeIsDisplayed(premiumPriceLocator)) {
            String actualPrice = getText(premiumPriceLocator).trim();
            Reporter.log("📄 Found Premium plan price: " + actualPrice, true);
            BasesetupUmaxx5G.infoLog("📄 Found Premium plan price: " + actualPrice);
            
            Assert.assertEquals(actualPrice, "139", "❌ Premium plan price does not match '139'!");
            Reporter.log("✅ Premium plan price is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ Premium plan price is correct and visible");
        } else {
            Reporter.log("❌ Premium plan price element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Premium plan price element is not displayed");
            Assert.fail("Premium plan price element is not displayed");
        }
    }
    public void verifyAndScrollStarterDataPlan() {
        String starterDataLocator = "//div[normalize-space()='10 GB']";

        safeExplicitWait(starterDataLocator, LONGWAIT);
        scrollToElement(starterDataLocator); // Scroll to "10 GB" plan

        if (safeIsDisplayed(starterDataLocator)) {
            String actualText = getText(starterDataLocator).trim();
            Reporter.log("📄 Found Starter data plan: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found Starter data plan: " + actualText);

            Assert.assertEquals(actualText, "10 GB", "❌ Starter data plan does not match '10 GB'!");
            Reporter.log("✅ Starter data plan is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ Starter data plan is correct and visible");
        } else {
            Reporter.log("❌ Starter data plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Starter data plan element is not displayed");
            Assert.fail("Starter data plan element is not displayed");
        }
    }

    public void verifyAndScrollExtraDataPlan() {
        String extraDataLocator = "(//div[normalize-space()='50 GB'])[1]";

        safeExplicitWait(extraDataLocator, LONGWAIT);
        scrollToElement(extraDataLocator); // Scroll to "50 GB" data plan

        if (safeIsDisplayed(extraDataLocator)) {
            String actualText = getText(extraDataLocator).trim();
            Reporter.log("📄 Found EXTRA data plan: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found EXTRA data plan: " + actualText);

            Assert.assertEquals(actualText, "50 GB", "❌ EXTRA data plan does not match '50 GB'!");
            Reporter.log("✅ EXTRA data plan is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ EXTRA data plan is correct and visible");
        } else {
            Reporter.log("❌ EXTRA data plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ EXTRA data plan element is not displayed");
            Assert.fail("EXTRA data plan element is not displayed");
        }
    }

    public void verifyAndScrollUltraUnlimitedDataPlan() {
        String ultraUnlimitedLocator = "(//div[@class='unlimited-tag'][normalize-space()='UNLIMITED'])[2]";

        safeExplicitWait(ultraUnlimitedLocator, LONGWAIT);
        scrollToElement(ultraUnlimitedLocator); // Scroll to ULTRA plan's UNLIMITED tag

        if (safeIsDisplayed(ultraUnlimitedLocator)) {
            String actualText = getText(ultraUnlimitedLocator).trim();
            Reporter.log("📄 Found ULTRA data plan tag: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found ULTRA data plan tag: " + actualText);

            Assert.assertEquals(actualText, "UNLIMITED", "❌ ULTRA data plan does not match 'UNLIMITED'!");
            Reporter.log("✅ ULTRA data plan is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ ULTRA data plan is correct and visible");
        } else {
            Reporter.log("❌ ULTRA data plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ ULTRA data plan element is not displayed");
            Assert.fail("ULTRA data plan element is not displayed");
        }
    }
    
    public void verifyAndScrollPremiumUnlimitedDataPlan() {
        String premiumUnlimitedLocator = "(//div[@class='unlimited-tag'][normalize-space()='UNLIMITED'])[1]";

        safeExplicitWait(premiumUnlimitedLocator, LONGWAIT);
        scrollToElement(premiumUnlimitedLocator); // Scroll to PREMIUM plan's UNLIMITED tag

        if (safeIsDisplayed(premiumUnlimitedLocator)) {
            String actualText = getText(premiumUnlimitedLocator).trim();
            Reporter.log("📄 Found PREMIUM data plan tag: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found PREMIUM data plan tag: " + actualText);

            Assert.assertEquals(actualText, "UNLIMITED", "❌ PREMIUM data plan does not match 'UNLIMITED'!");
            Reporter.log("✅ PREMIUM data plan is correct and visible", true);
            BasesetupUmaxx5G.passLog("✅ PREMIUM data plan is correct and visible");
        } else {
            Reporter.log("❌ PREMIUM data plan element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ PREMIUM data plan element is not displayed");
            Assert.fail("PREMIUM data plan element is not displayed");
        }
    }

    public void clickStarterPlan() {
        String starterPlanButtonLoc = "//div[@id='plan-section']//div[4]//div[2]//div[3]";

        safeExplicitWait(starterPlanButtonLoc, LONGWAIT);
        scrollToElement(starterPlanButtonLoc); // Scroll to the Starter plan button
        safeClick(starterPlanButtonLoc); // Click on it

        Reporter.log("✅ Clicked on the STARTER plan", true);
        BasesetupUmaxx5G.infoLog("✅ Clicked on the STARTER plan");
    }

    public void verify5GCoverageAvailabilityHeading() {
        String headingLocator = "//b[normalize-space()='5G Coverage Availability']";
        String expectedText = "5G Coverage Availability";

        safeExplicitWait(headingLocator, LONGWAIT);
        scrollToElement(headingLocator); // Optional: scroll to heading for visibility

        String actualText = getText(headingLocator).trim();

        Reporter.log("📄 Found heading text: " + actualText, true);
        BasesetupUmaxx5G.infoLog("📄 Found heading text: " + actualText);

        Assert.assertEquals(actualText, expectedText, "❌ Heading text does not match!");
        Reporter.log("✅ 5G Coverage Availability heading is correct", true);
        BasesetupUmaxx5G.passLog("✅ 5G Coverage Availability heading is correct");
    }
    public void enterZipCode(String zipCode) {
        String zipCodeInputLocator = "(//input[@id='coverage-code'])[1]";
        
        safeExplicitWait(zipCodeInputLocator, LONGWAIT);
        scrollToElement(zipCodeInputLocator); // Scroll to the input field if necessary
        safeClear(zipCodeInputLocator);       // Clear existing text if any
        safeType(zipCodeInputLocator, zipCode); // Enter the ZIP code

        Reporter.log("📥 Entered ZIP code: " + zipCode, true);
        BasesetupUmaxx5G.infoLog("📥 Entered ZIP code: " + zipCode);
    }
    
    public void clickGoButtonAfterZipCode() {
        String goButtonLocator = "(//button[normalize-space()='GO'])[1]";

        safeExplicitWait(goButtonLocator, LONGWAIT);
        scrollToElement(goButtonLocator);
        safeClick(goButtonLocator);

        Reporter.log("🟢 Clicked on the GO button after entering ZIP code", true);
        BasesetupUmaxx5G.passLog("🟢 Clicked on the GO button after entering ZIP code");
    }

    public void verifyChooseYour5GWirelessDeviceHeading() {
        String headingLocator = "//b[normalize-space()='Choose Your 5G Wireless Device']";
        String expectedText = "Choose Your 5G Wireless Device";

        safeExplicitWait(headingLocator, LONGWAIT);
        scrollToElement(headingLocator);

        String actualText = getText(headingLocator).trim();

        Reporter.log("📄 Found heading: " + actualText, true);
        BasesetupUmaxx5G.infoLog("📄 Found heading: " + actualText);

        Assert.assertEquals(actualText, expectedText, "❌ Heading text does not match!");

        Reporter.log("✅ 5G Wireless Device heading is correct", true);
        BasesetupUmaxx5G.passLog("✅ 5G Wireless Device heading is correct");
    }

    public void clickBestCoverageLink() {
        String locator = "(//a[normalize-space()=\"See Why UMAXX Offers America's Best Coverage\"])[1]";
        
        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -150); // scrolls element into view, but keeps it slightly lower
        safeClick(locator);
        
        Reporter.log("✅ Clicked on 'See Why UMAXX Offers America's Best Coverage' link", true);
        BasesetupUmaxx5G.passLog("✅ Clicked on 'See Why UMAXX Offers America's Best Coverage' link");
    }

    public void verify5GCoverageParagraphText() {
        String locator = "(//p[@class='fs-4'])[1]";
        String expectedText = "Map Shows 5G Coverage of UMAXX,Verizon and AT&T";

        safeExplicitWait(locator, LONGWAIT);

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();
            
            Reporter.log("📄 Found paragraph text: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found paragraph text: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ 5G Coverage paragraph text does not match!");
            
            Reporter.log("✅ 5G Coverage paragraph text is correct", true);
            BasesetupUmaxx5G.passLog("✅ 5G Coverage paragraph text is correct");
        } else {
            Reporter.log("❌ Paragraph element is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Paragraph element is not displayed");
            Assert.fail("5G Coverage paragraph element is not visible");
        }
    }
    public void clickCloseButton() {
        String locator = "//button[@class='btn-close mx-1']";
        safeExplicitWait(locator, LONGWAIT);

        if (safeIsDisplayed(locator)) {
            safeClick(locator);
            Reporter.log("✅ Clicked on the close (X) button", true);
            BasesetupUmaxx5G.passLog("✅ Clicked on the close (X) button");
        } else {
            Reporter.log("❌ Close button is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Close button is not displayed");
            Assert.fail("Close button not visible to click");
        }
    }

    public void verifyMobilePocketWiFiText() {
        String locator = "//p[normalize-space()='Mobile Pocket WI-FI']";
        String expectedText = "Mobile Pocket WI-FI";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -150);

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📄 Found paragraph: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found paragraph: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Text does not match!");
            Reporter.log("✅ Mobile Pocket WI-FI text is correct", true);
            BasesetupUmaxx5G.passLog("✅ Mobile Pocket WI-FI text is correct");
        } else {
            Reporter.log("❌ Mobile Pocket WI-FI paragraph not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Mobile Pocket WI-FI paragraph not displayed");
            Assert.fail("❌ Mobile Pocket WI-FI element not displayed");
        }
    }
    public void verifyInHomeDeviceText() {
        String locator = "//p[normalize-space()='In-Home Device']";
        String expectedText = "In-Home Device";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -150);  // Smooth upward scroll

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📄 Found paragraph: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found paragraph: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Text does not match!");
            Reporter.log("✅ In-Home Device text is correct", true);
            BasesetupUmaxx5G.passLog("✅ In-Home Device text is correct");
        } else {
            Reporter.log("❌ In-Home Device paragraph not displayed", true);
            BasesetupUmaxx5G.failLog("❌ In-Home Device paragraph not displayed");
            Assert.fail("❌ In-Home Device element not displayed");
        }
    }

    public void verifyNetgearMR6150Present() {
        String locator = "//h5[normalize-space()='Netgear MR6150']";
        String expectedText = "Netgear MR6150";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -120); // Slight scroll for visibility

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📄 Found device title: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found device title: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Device name text does not match!");
            Reporter.log("✅ Netgear MR6150 device name is correctly displayed", true);
            BasesetupUmaxx5G.passLog("✅ Netgear MR6150 device name is correctly displayed");
        } else {
            Reporter.log("❌ Netgear MR6150 device not found on the page", true);
            BasesetupUmaxx5G.failLog("❌ Netgear MR6150 device not found on the page");
            Assert.fail("❌ Netgear MR6150 element not displayed");
        }
    }
    public void verifyNokiaFWA12Present() {
        String locator = "(//h5[normalize-space()='Nokia FWA 12'])[1]";
        String expectedText = "Nokia FWA 12";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -120); // Scroll slightly for visibility

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📄 Found device title: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found device title: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Device name text does not match!");
            Reporter.log("✅ Nokia FWA 12 device name is correctly displayed", true);
            BasesetupUmaxx5G.passLog("✅ Nokia FWA 12 device name is correctly displayed");
        } else {
            Reporter.log("❌ Nokia FWA 12 device not found on the page", true);
            BasesetupUmaxx5G.failLog("❌ Nokia FWA 12 device not found on the page");
            Assert.fail("❌ Nokia FWA 12 element not displayed");
        }
    }

    public void verifyNetgearBestForHomeBoatRv() {
        String locator = "(//span[normalize-space()='HOME, BOAT,RV & ON-THE-GO'])[1]";
        String expectedText = "HOME, BOAT,RV & ON-THE-GO";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -120); // Slight scroll for visibility

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📌 Best Use Text Found: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📌 Best Use Text Found: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Best for text does not match!");
            Reporter.log("✅ Netgear is correctly labeled for HOME, BOAT, RV & ON-THE-GO", true);
            BasesetupUmaxx5G.passLog("✅ Netgear is correctly labeled for HOME, BOAT, RV & ON-THE-GO");
        } else {
            Reporter.log("❌ Best for label not found for Netgear", true);
            BasesetupUmaxx5G.failLog("❌ Best for label not found for Netgear");
            Assert.fail("❌ Netgear 'best for' label not displayed");
        }
    }
    
    
    public void verifyNokiaBestForHome() {
        String locator = "//span[normalize-space()='PERFECT FOR HOME']";
        String expectedText = "PERFECT FOR HOME";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -120); // Slight upward offset for better visibility

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📌 Best Use Text Found for Nokia FWA: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📌 Best Use Text Found for Nokia FWA: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ 'Best for' text does not match for Nokia FWA!");
            Reporter.log("✅ Nokia FWA 12 is correctly labeled as PERFECT FOR HOME", true);
            BasesetupUmaxx5G.passLog("✅ Nokia FWA 12 is correctly labeled as PERFECT FOR HOME");
        } else {
            Reporter.log("❌ 'Best for' label not found for Nokia FWA", true);
            BasesetupUmaxx5G.failLog("❌ 'Best for' label not found for Nokia FWA");
            Assert.fail("❌ 'Best for' label not displayed for Nokia FWA");
        }
    }
    public void clickNetgearMoreDetails() {
        String locator = "(//p)[15]";
        
        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -120); // Scroll slightly above for better visibility
        safeClick(locator);

        Reporter.log("✅ Clicked on 'More Details' for Netgear", true);
        BasesetupUmaxx5G.passLog("✅ Clicked on 'More Details' for Netgear");
    }

    public void clickCloseDocument() {
        String locator = "(//button[@aria-label='Close'])[5]";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -100); // Optional smooth scroll
        safeClick(locator);

        Reporter.log("✅ Clicked Close button on document/modal", true);
        BasesetupUmaxx5G.passLog("✅ Clicked Close button on document/modal");
    }
    
    public void clickMoreDetailsNokiaFWA() {
        String locator = "(//a[@target='_blank'][normalize-space()='More Details'])[1]";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -100);
        String originalWindow = driver.getWindowHandle();
        int beforeClickWindows = driver.getWindowHandles().size();

        safeClick(locator);
        Reporter.log("✅ Clicked 'More Details' link for Nokia FWA", true);
        BasesetupUmaxx5G.passLog("✅ Clicked 'More Details' link for Nokia FWA");

        // Wait for the new window to open
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> driver.getWindowHandles().size() > beforeClickWindows);

        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Reporter.log("🔁 Switched to document window", true);
        BasesetupUmaxx5G.infoLog("🔁 Switched to document window");

        // Close the document tab/window
        driver.close();
        Reporter.log("❎ Closed document tab", true);
        BasesetupUmaxx5G.passLog("❎ Closed document tab");

        // Switch back to original window
        driver.switchTo().window(originalWindow);
        Reporter.log("🔙 Switched back to main window", true);
        BasesetupUmaxx5G.infoLog("🔙 Switched back to main window");
    }
    public void clickSelectNetgearDevice() {
        String locator = "(//button[@id='product-ids-32-full'])[1]";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -100); // Adjust scroll as needed
        safeClick(locator);

        Reporter.log("✅ Clicked 'Select' button for Netgear device", true);
        BasesetupUmaxx5G.passLog("✅ Clicked 'Select' button for Netgear device");
    }

    public void verifySoftCreditPullMessage() {
        String locator = "(//strong[contains(text(),'This is a soft credit pull — it will not affect yo')])[1]";
        String expectedText = "This is a soft credit pull — it will not affect your credit score.";

        safeExplicitWait(locator, LONGWAIT);

        if (safeIsDisplayed(locator)) {
            String actualText = getText(locator).trim();

            Reporter.log("📄 Found message: " + actualText, true);
            BasesetupUmaxx5G.infoLog("📄 Found message: " + actualText);

            Assert.assertEquals(actualText, expectedText, "❌ Credit pull message does not match!");
            Reporter.log("✅ Credit pull message is correct", true);
            BasesetupUmaxx5G.passLog("✅ Credit pull message is correct");
        } else {
            Reporter.log("❌ Credit pull message not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Credit pull message not displayed");
            Assert.fail("Credit pull message not visible");
        }
    }
    
    public void clickContinueButtonForNetgear() {
        String locator = "(//button[@id='product-ids-32-full'])[2]";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -100);  // Smooth scroll above the button
        safeClick(locator);

        Reporter.log("✅ Clicked 'Continue' button for Netgear device", true);
        BasesetupUmaxx5G.passLog("✅ Clicked 'Continue' button for Netgear device");
    }

    public void verifyGetPrequalifiedNowHeading() {
        String locator = "(//h2[normalize-space()='Get Prequalified Now!'])[1]";
        String expectedText = "Get Prequalified Now!";

        safeExplicitWait(locator, LONGWAIT);
        String actualText = getText(locator).trim();

        Reporter.log("📄 Found heading: " + actualText, true);
        BasesetupUmaxx5G.infoLog("📄 Found heading: " + actualText);

        Assert.assertEquals(actualText, expectedText, "❌ Heading text does not match!");

        Reporter.log("✅ 'Get Prequalified Now!' heading text is correct", true);
        BasesetupUmaxx5G.passLog("✅ 'Get Prequalified Now!' heading text is correct");
    }
    public void verifyNoImpactToCreditScoreMessage() {
        String locator = "(//p[@class='text-dark text-center'])[1]";
        String expectedText = "No Impact To Your Credit Score!";

        safeExplicitWait(locator, LONGWAIT);
        String actualText = getText(locator).trim();

        Reporter.log("📄 Found message: " + actualText, true);
        BasesetupUmaxx5G.infoLog("📄 Found message: " + actualText);

        Assert.assertEquals(actualText, expectedText, "❌ Credit score message does not match!");

        Reporter.log("✅ 'No Impact To Your Credit Score!' message is verified", true);
        BasesetupUmaxx5G.passLog("✅ 'No Impact To Your Credit Score!' message is verified");
    }
    public void enterFirstName(String firstName) {
        String locator = "//input[@id='applicant_first_name']"; // Or your confirmed valid XPath

        scrollToElement(locator);
        safeExplicitWait(locator, 30); // wait up to 30 seconds
        safeType(locator, firstName);

        Reporter.log("✅ Entered First Name: " + firstName, true);
        BasesetupUmaxx5G.passLog("✅ Entered First Name: " + firstName);
    }

    public void enterLastName(String lastName) {
        String locator = "//input[@name = 'applicant[last_name]']";

        safeExplicitWait(locator, LONGWAIT);
        safeType(locator, lastName);

        Reporter.log("✅ Entered Last Name: " + lastName, true);
        BasesetupUmaxx5G.passLog("✅ Entered Last Name: " + lastName);
    }

    public void navigateToFinanceErrorPage() {
        String targetUrl = "https://test-umaxx-tv.herokuapp.com/finance/error";
        driver.get(targetUrl); // This will replace the current URL with the error page

        Reporter.log("✅ Navigated to Finance Error Page: " + targetUrl, true);
        BasesetupUmaxx5G.passLog("✅ Navigated to Finance Error Page: " + targetUrl);
    }

    public void verifyStillEligibleMessage() {
        String locator = "(//h2[contains(text(),'You’re Still Eligible to Get UMAXX')])[1]";

        safeExplicitWait(locator, LONGWAIT);
        boolean isVisible = safeIsDisplayed(locator);

        Assert.assertTrue(isVisible, "❌ Message 'You’re Still Eligible to Get UMAXX' is not visible");
        Reporter.log("✅ Verified message: You’re Still Eligible to Get UMAXX", true);
        BasesetupUmaxx5G.passLog("✅ Verified message: You’re Still Eligible to Get UMAXX");
    }
    
    
    public void clickContinueButton() {
        String locator = "//a[normalize-space()='Continue']";

        safeExplicitWait(locator, LONGWAIT);
        scrollToElementWithOffset(locator, -100); // Scroll slightly above
        safeClick(locator);

        Reporter.log("✅ Clicked on 'Continue' button", true);
        BasesetupUmaxx5G.passLog("✅ Clicked on 'Continue' button");
    }
    public void verifyOrderNowHeading() {
        String locator = "(//div[@class='h4 text-center'])[1]";
        String expectedText = "Order Now";

        safeExplicitWait(locator, LONGWAIT);
        String actualText = getText(locator).trim();

        Assert.assertEquals(actualText, expectedText, "❌ 'Order Now' heading text mismatch");
        
        Reporter.log("✅ Verified 'Order Now' heading is present", true);
        BasesetupUmaxx5G.passLog("✅ Verified 'Order Now' heading is present: " + actualText);
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

    public void enterOrderPhoneNumber(String phoneNumber) {
        String locator = "(//input[@id='order_phone'])[1]";

        safeExplicitWait(locator, LONGWAIT);
        safeType(locator, phoneNumber);

        Reporter.log("✅ Entered Order Phone Number: " + phoneNumber, true);
        BasesetupUmaxx5G.passLog("✅ Entered Order Phone Number: " + phoneNumber);
    }

    public void enterOrderFirstName(String firstName) {
        String locator = "//input[@id='order_first_name']";

        safeExplicitWait(locator, LONGWAIT);
        safeType(locator, firstName);

        Reporter.log("✅ Entered Order First Name: " + firstName, true);
        BasesetupUmaxx5G.passLog("✅ Entered Order First Name: " + firstName);
    }

    
    public void enterOrderLastName(String lastName) {
        String locator = "(//input[@id='order_last_name'])[1]";

        safeExplicitWait(locator, LONGWAIT);
        safeType(locator, lastName);

        Reporter.log("✅ Entered Order Last Name: " + lastName, true);
        BasesetupUmaxx5G.passLog("✅ Entered Order Last Name: " + lastName);
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



    
    public void verifyTotalAmountDisplayed() {
        String locator = "(//td[@class='text-left'])[1]";
        
        safeExplicitWait(locator, LONGWAIT); // Ensure element is loaded
        String amount = getText(locator);
        
        if (amount != null && !amount.trim().isEmpty()) {
            Reporter.log("✅ Total Amount Displayed: " + amount, true);
            BasesetupUmaxx5G.passLog("✅ Total Amount Displayed: " + amount);
        } else {
            Reporter.log("❌ Total Amount is not displayed", true);
            BasesetupUmaxx5G.failLog("❌ Total Amount is not displayed");
        }
    }

    public void verifyTotalAmountIs238_99() {
        String locator = "(//td[@class='text-right'])[1]";
        
        safeExplicitWait(locator, LONGWAIT); // Wait until element is visible
        String actualAmount = getText(locator).trim();
        String expectedAmount = "$238.99";
        
        if (actualAmount.equals(expectedAmount)) {
            Reporter.log("✅ Total Amount is correctly displayed: " + actualAmount, true);
            BasesetupUmaxx5G.passLog("✅ Total Amount is correctly displayed: " + actualAmount);
        } else {
            Reporter.log("❌ Total Amount mismatch. Expected: " + expectedAmount + ", Found: " + actualAmount, true);
            BasesetupUmaxx5G.failLog("❌ Total Amount mismatch. Expected: " + expectedAmount + ", Found: " + actualAmount);
        }
    }
    
    public void clickTermsAndConditionsCheckbox() {
        String locator = "(//input[@id='accept-checkbox'])[1]";

        safeExplicitWait(locator, LONGWAIT);     // Wait for checkbox visibility
     //   scrollToElementWithOffset(locator, -100);  // Optional scroll
        safeClick(locator);                        // Click the checkbox

        Reporter.log("✅ Clicked on Terms & Conditions checkbox", true);
        BasesetupUmaxx5G.passLog("✅ Clicked on Terms & Conditions checkbox");
    }

    public void clickProceedToFinalStep() {
        String locator = "(//button[normalize-space()='PROCEED TO FINAL STEP'])[1]";
        
        safeExplicitWait(locator, LONGWAIT);     // Wait until the button is visible
      //  scrollToElementWithOffset(locator, -100);  // Optional smooth scroll to bring it into view
        safeClick(locator);                        // Perform click
        
        Reporter.log("✅ Clicked 'PROCEED TO FINAL STEP' button", true);
        BasesetupUmaxx5G.passLog("✅ Clicked 'PROCEED TO FINAL STEP' button");
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
	

	public void waitForToastMessage(String expectedText) {
	    String toastLocator = "//div[contains(@class, 'toast-body') and contains(text(),'" + expectedText + "')]";

	    // Wait until the element is present using your framework wait
	    safeExplicitWait(toastLocator, LONGWAIT);

	    // Now check if it is displayed
	    boolean isDisplayed = safeIsDisplayed(toastLocator);

	    if (isDisplayed) {
	        scrollToElement(toastLocator);
	        Reporter.log("✅ Toast message '" + expectedText + "' is displayed", true);
	        BasesetupUmaxx5G.passLog("✅ Toast message '" + expectedText + "' is displayed");
	    } else {
	        Reporter.log("❌ Toast message '" + expectedText + "' was not displayed", true);
	        BasesetupUmaxx5G.failLog("❌ Toast message '" + expectedText + "' was not displayed");
	    }
	}
	
	public void verifyThankYouMessageDisplayed() {
	    String thankYouLocator = "//h3[normalize-space()='Thank You!']";

	    // Wait until the message is visible
	    safeExplicitWait(thankYouLocator, LONGWAIT);

	    // Check if it is displayed
	    if (safeIsDisplayed(thankYouLocator)) {
	        scrollToElement(thankYouLocator);
	        Reporter.log("✅ 'Thank You!' message is displayed", true);
	        BasesetupUmaxx5G.passLog("✅ 'Thank You!' message is displayed");
	    } else {
	        Reporter.log("❌ 'Thank You!' message is not displayed", true);
	        BasesetupUmaxx5G.failLog("❌ 'Thank You!' message is not displayed");
	    }
	}



	public void verifyUsernamePasswordEmailMessageDisplayed() {
	    String locator = "(//p[@class='thank-sub-text text-center'])[1]";
	    String expectedText = "Your username and password has been emailed to you.";

	    // Wait until element is present and visible
	    safeExplicitWait(locator, LONGWAIT);

	    // Get actual text
	    String actualText = getText(locator).trim();

	    // Verify the text
	    if (actualText.equals(expectedText)) {
	        scrollToElement(locator);
	        Reporter.log("✅ Message is displayed: " + actualText, true);
	        BasesetupUmaxx5G.passLog("✅ Message is displayed: " + actualText);
	    } else {
	        Reporter.log("❌ Expected: '" + expectedText + "' but found: '" + actualText + "'", true);
	        BasesetupUmaxx5G.failLog("❌ Expected: '" + expectedText + "' but found: '" + actualText + "'");
	    }
	}



}
