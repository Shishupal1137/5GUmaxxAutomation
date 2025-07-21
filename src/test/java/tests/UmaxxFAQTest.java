package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.UmaxxFAQPage;

public class UmaxxFAQTest extends BasesetupUmaxx5G{
  @Test(priority = 1)
  public void verifyFAQPage() {
UmaxxFAQPage FAQpage = new UmaxxFAQPage();
FAQpage.clickNavbarHamburger();
FAQpage.clickOnFAQSection();
FAQpage.verifyDataCapFAQQuestion();
FAQpage.clickSigningUpFAQ();
FAQpage.verifySignUpFAQText();
FAQpage.clickSettingUpFAQLink();
FAQpage.verifySetupFAQQuestionText();
FAQpage.clickDeviceDetailsFAQButton();
FAQpage.verifySignalRangeFAQText();

  }
}
