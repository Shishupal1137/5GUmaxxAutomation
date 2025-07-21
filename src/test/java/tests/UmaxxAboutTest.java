package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.UmaxxAboutPage;

public class UmaxxAboutTest extends BasesetupUmaxx5G {
  @Test
  public void verifyUmaxxAboutPage() {
	  UmaxxAboutPage AboutPage = new UmaxxAboutPage();
	  AboutPage.clickNavbarToggle();
	  AboutPage.clickAboutPageLink();
	  AboutPage.verifyMilitaryGradeBackboneText();
	  AboutPage.verifyMilitaryGradeCTAButtonText();
	  AboutPage.clickFirstClickNowButton();
	//  AboutPage.verify5GInternetPlansHeading();
	  AboutPage.verify5GInternetPlansHeadingAndGoBack();
  }
}
