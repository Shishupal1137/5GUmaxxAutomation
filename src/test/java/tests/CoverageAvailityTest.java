package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.CoverageAvailityPage;

public class CoverageAvailityTest extends BasesetupUmaxx5G{
  @Test
  public void verify5GInternetCoverageAvaility() {
	  CoverageAvailityPage Coverage = new CoverageAvailityPage();
	  Coverage.clickNavbarHamburger();
	  Coverage.click5GCoverageAvailability();
	  Coverage.verifyCoverageHeaderText();
	  Coverage.verifyCoverageSubtitleText();
	  
	  Coverage.enterZipCode("12345");
	  Coverage.clickSearchButton();
	  Coverage.verifyCoverageSuccessMessage();
	  Coverage.clickOrderNowLink();
	  Coverage.verify5GInternetHeading();
	  Coverage.clearCoverageCodeField();
	  Coverage.enterZipCode("77889");
	  Coverage.clickSearchButton();
	  Coverage.verifyNoCoverageMessage();
	  Coverage.enterVisitorEmail("Demo@gmail.com");
	  Coverage.clickNotifyButton();
	  Coverage.validateThankYouMessage();
	 
	  
  }
}
