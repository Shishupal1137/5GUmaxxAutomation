package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.UmaxxStorePage;

public class UmaxxStoreTest extends BasesetupUmaxx5G {
  @Test
  public void verifyUmaxxStore() {
	  UmaxxStorePage storePage = new UmaxxStorePage();
	  storePage.clickNavbarToggle();
	  storePage.clickUmaxxStoreLink();
	  storePage.switchToNewWindow();
	  storePage.verifyWelcomeMerchandiseHeading();
	  storePage.verifyAnnouncementBarText();
  }
}
