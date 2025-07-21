package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.InternetPlanPage;

public class InternetPlanTest extends BasesetupUmaxx5G {
    @Test(priority=1)
    public void verify5gInternetPlanpage() {
        InternetPlanPage internet = new InternetPlanPage();
        internet.verifyPageTitle();
        internet.clickNavbarToggle();
        internet.click5GInternetPlanLink(); // Removed because method no longer exists
        internet.verify5GInternetPlansHeadingIsDisplayed(); // You can uncomment this if needed
        internet.verifyMilitaryGradeSpeedParagraph();
        internet.verifyPrivacySecurityLinkText();
        internet.verifyAndScrollToStarterPlan();
        internet.verifyAndScrollToExtraPlan();
        internet.verifyAndScrollToUltraPlan();
        internet.verifyAndScrollToPremiumPlan();
        internet.verifyAndScrollStarterPrice();
        internet.verifyAndScrollExtraPrice();
        internet.verifyAndScrollUltraPrice();
        internet.verifyAndScrollPremiumPrice();
        internet.verifyAndScrollStarterDataPlan();
        internet.verifyAndScrollExtraDataPlan();
        internet.verifyAndScrollUltraUnlimitedDataPlan();
        internet.verifyAndScrollPremiumUnlimitedDataPlan();
    }
    
    @Test(priority =2)
    public void verifyselectplan() {
    	InternetPlanPage internet = new InternetPlanPage();
    	internet.clickStarterPlan();
    	internet.verify5GCoverageAvailabilityHeading();
    	internet.enterZipCode("12345");
    	internet.clickGoButtonAfterZipCode();
    	
    	
    
    }
    
    @Test(priority = 3)
    public void verifyRouterFunctionality() {
    	InternetPlanPage internet = new InternetPlanPage();
    	internet.verifyChooseYour5GWirelessDeviceHeading();
    	internet.clickBestCoverageLink();
    	internet.verify5GCoverageParagraphText();
    	internet.clickCloseButton();
    	internet.verifyMobilePocketWiFiText();
    	internet.verifyInHomeDeviceText();
    	internet.verifyNetgearMR6150Present();
    	internet.verifyNokiaFWA12Present();
    	internet.verifyNetgearBestForHomeBoatRv();
    	internet.verifyNokiaBestForHome();
    	internet.clickNetgearMoreDetails();
    	internet.clickCloseDocument();
    	internet.clickMoreDetailsNokiaFWA();
    	internet.clickSelectNetgearDevice();
    	internet.verifySoftCreditPullMessage();
    	internet.clickContinueButtonForNetgear();
    }
    @Test(priority = 4)
    public void Fillisoftdetails() {
    	InternetPlanPage internet = new InternetPlanPage();
    	//internet.verifyGetPrequalifiedNowHeading();
    	internet.enterFirstName("Test");
    	internet.enterLastName("test2");
    	
    	
}
    
    @Test(priority = 5)
    public void orderNowform() {
    	InternetPlanPage internet = new InternetPlanPage();
    	internet.navigateToFinanceErrorPage();
    	internet.verifyStillEligibleMessage();
    	internet.clickContinueButton();
    	internet.verifyOrderNowHeading();
    	internet.enterOrderEmail();
    	internet.enterOrderPassword("xyzz4365");
    	internet.enterOrderPhoneNumber("7865437698");
    	internet.enterOrderFirstName("tTestP");
    	internet.enterOrderLastName("DemmoTe");
    	internet.enterOrderAddress("San Antonio");
    	internet.clickAddressSuggestionSanAntonio();
    	internet.verifyTotalAmountDisplayed();
    	internet.verifyTotalAmountIs238_99();
    	internet.clickTermsAndConditionsCheckbox();
    	internet.clickProceedToFinalStep();
    	
    }
    
    @Test(priority = 6)
    public void FillcardDetails() {
    	InternetPlanPage internet = new InternetPlanPage();
    	internet.enterStripeCardNumber("4242 4242 4242 4242");
    	internet.enterStripeExpDate("07 / 28");
    	internet.enterStripeCvv("675");
    	internet.enterStripeCardholderName("ttmxtdemo");
    	internet.enterStripeZipCode("12345");
    	internet.clickStripeSaveCardButton();
    	internet.waitForToastMessage("Subscription Done");
    	internet.verifyThankYouMessageDisplayed();
    	internet.verifyUsernamePasswordEmailMessageDisplayed();
    	
    }
}
