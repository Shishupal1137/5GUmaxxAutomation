package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.HomePage;

public class HomeTest extends BasesetupUmaxx5G{
  @Test
  public void verifyHomePage() {
	  HomePage homepage = new HomePage();
	   homepage.verifyPageTitle();
       homepage.LogoVisibilty();
       homepage.verifyStartingPriceText(); 
       homepage.verifyCustomerSupportNumber();
       homepage.verifySupportEmail();
       homepage.verifyEmailSubscribeProgram();
       homepage.clickSubscribeButton();
       homepage.clickViewPackagesLinkWithScroll();
       homepage.verify5GPlansPageTitle();

       homepage.navigateBackToHomePage();
       homepage.verifyZipCodeInstructionText();
       homepage.enterZipCode("12345");  // Replace with the actual ZIP code
       homepage.clickSearchButton();
       homepage.verifyCoverageSuccessMessage();

       homepage.verify5GPlansPageTitle();
       homepage.waitForNewPlansPageToLoad();
       homepage.navigateBackToHomePage();

       homepage.refreshPage();
       homepage.enterZipCode("77665");  // Replace with the actual ZIP code
       homepage.clickSearchButton();

       homepage.verifyUnserviceableZipMessage();

       homepage.enterNotifyEmail("TestDemo@gmail.com");
       homepage.clickNotifyButton();
     
  }
}
