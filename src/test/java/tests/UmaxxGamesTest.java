package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.UmaxxGamesPage;

public class UmaxxGamesTest extends BasesetupUmaxx5G {
  @Test
  public void verifyUmaxxGames() {
	  
	UmaxxGamesPage gamePage = new UmaxxGamesPage();
	gamePage.clickNavbarHamburger();
  //  gamePage.clickOnGamesSectionAndSwitchWindow();
    gamePage.clickGamesSectionAndWorkInNewWindow();
    gamePage.verifyPlayCompeteRedeemText();
	

  }
}
