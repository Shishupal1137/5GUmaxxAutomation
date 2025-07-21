package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.UmaxxPhonePage;

public class UmaxxPhoneTest extends BasesetupUmaxx5G {
  @Test(priority =1, enabled = true)
  public void verifyUmaxxPhonePage() {
	  UmaxxPhonePage PhonePage = new UmaxxPhonePage();
	  PhonePage.clickNavbarHamburger();
	  PhonePage.clickUmaxxPhonesLink();
	  PhonePage.verifyUmaxxMobileText();
	  PhonePage.verifyUmaxxPhoneHeader();
	 // PhonePage.verifyUmaxxLibertyPlusIsDisplayed();
      PhonePage.verifyPhoneNumberText();
      PhonePage.verifyModelSuggestionText();
      PhonePage.verifyLibertyPlusParagraphText();
      PhonePage.verifyOriginalPriceSectionText();
      PhonePage.verifyMemorySpecification();
      PhonePage.verifyStorageText();
      PhonePage.verifyUmaxxLibertyText();
      PhonePage.verifyLibertyPriceBlock2();
      PhonePage.verifyMemory3GBText();
      PhonePage.verifyStorage32GBText();
      //PhonePage.clickPayFullLibertyPlus();
  }
  @Test(priority = 2)
  public void UmaxxMobilePurchase() {
	  UmaxxPhonePage PhonePage = new UmaxxPhonePage();
	  //PhonePage.clickNavbarHamburger();
	  //PhonePage.clickUmaxxPhonesLink();
	  PhonePage.clickPayFullLibertyPlus();
	  PhonePage.enterOrderEmail();
	  PhonePage.enterOrderPassword("Abceed123");
	  PhonePage.enterOrderPhoneNumber();
	  PhonePage.enterOrderFirstName();
	  PhonePage.enterOrderLastName();
	  PhonePage.enterOrderAddress("San Antonio");
	  PhonePage.clickAddressSuggestionSanAntonio();
	  PhonePage.enterOrderZipCode("12345");
	  PhonePage.enterOrderCity("Schenectady");
	  PhonePage.enterOrderState("New York");
	  PhonePage.clickAcceptTermsAndConditions();
	  PhonePage.clickProceedToFinalStep();
	  
  }
  @Test(priority = 3)
  public void FillPaymentFields() {
	  UmaxxPhonePage PhonePage = new UmaxxPhonePage();
	  PhonePage.enterStripeCardNumber("4242 4242 4242 4242");
	  PhonePage.enterStripeExpDate("07 / 28");
	  PhonePage.enterStripeCvv("567");
	  PhonePage.enterStripeCardholderName("txttest");
	  PhonePage.enterStripeZipCode("12345");
	  PhonePage.clickStripeSaveCardButton();
	  PhonePage.toastSuccessVisibility();
  }
}
