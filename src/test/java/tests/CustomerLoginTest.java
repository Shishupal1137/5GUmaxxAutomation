package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.CustomerLoginPage;

public class CustomerLoginTest extends BasesetupUmaxx5G{
  @Test(priority =1)
  public void verifyLoginPage() {
	  CustomerLoginPage Login = new CustomerLoginPage();
	  Login.clickNavbarHamburger();
	  Login.clickCustomerLogin();
	  Login.enterCustomerUsername();
	  Login.enterCustomerPassword();
	  Login.clickLoginButtonAndVerifyCaptcha();
	//  Login.verifyUsernameDisplayed();
	  
	  Login.verifySpecificUsernameDisplayed();

	  Login.verifyPaymentStatus();
	  Login.verifyCreatedDate();
	  Login.verify5GPlanPurchase();
	  Login.verifyHotspotDeviceName();
	 // Login.clickOnViewDetails();
	  Login.clickViewDetailsForSharma();
	  Login.verifyTotalAmountDisplayed();
	  Login.verifyDepositAmount();
  }
  
  
  @Test(priority = 2, enabled = true)

	  public void InvoiceFunctionality() {
		  CustomerLoginPage Login = new CustomerLoginPage();
	  
	  Login.clickOnViewInvoices();
	  Login.clickOn5GSubscriptionInvoice();
	
	  Login.clickInvoiceOptionsIcon();
	  Login.verifyInvoiceNumberDisplayed();
      Login.verifyPurchaseDateDisplayed();
	
	  Login.verifyRemainingAmountZero();
	  Login.clickDownloadReceiptButton();
	  Login.clickDownloadReceiptButton();
	  Login.closeCurrentWindowAndSwitchToParent();
	  
	  Login.clickOnViewInvoices();
	  
	  Login.clickOnDepositInvoice();
	  Login.clickInvoiceOptionsIcon();
	  Login.verifyDepositAmountIs199();
	  
	  Login.clickDownloadReceiptButton();
	  Login.clickDownloadReceiptButton();
	  Login.closeCurrentWindowAndSwitchToParent();
	 
	
  }
  
  @Test(priority = 3, enabled = true)
  public void verifyEditPersonalFunctionality() {
	  CustomerLoginPage Login = new CustomerLoginPage();
	  Login.clickOnSettingsButton();
	  Login.clickOnEditAccountButton();
	  Login.enterOrderPhoneNumber("7894561235");
	  Login.clickOnUpdateButton();
	  Login.verifySuccessMessageAfterUpdate();
  }
  
  @Test(priority = 4, enabled = true)
  public void verifyEditCardRelatedFunctionality() {
	  CustomerLoginPage Login = new CustomerLoginPage();
	  Login.clickOnSettingsButton();
	  Login.clickEditCardDetails();
	  //preiously
	// Login.enterStripeCardNumber("42424242424242");
	//Login.enterStripeCardNumber("42424242424242");
	  
	  
	  
	Login.enterStripeCardNumber("4242 4242 4242 4242");
	
	Login.enterStripeExpDate("07 / 28");
	
	Login.enterStripeCvv("231");
	
	Login.enterStripeCardholderName("TPtest");
	
	Login.enterStripeZipCode("12345");
	
	Login.clickStripeSaveCardButton();
	
	Login.toastSuccessVisibility();
	   //Login.enterStripeExpDate("07 / 27");
	/*Login.enterStripeCvc("234");
	Login.enterCardholderName("TestDemo");*/
	  
  }
  }

