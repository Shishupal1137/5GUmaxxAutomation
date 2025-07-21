package tests;

import org.testng.annotations.Test;

import common.BasesetupUmaxx5G;
import pages.LatestNewsPage;

public class LatestNewsTest extends BasesetupUmaxx5G{
  @Test
  public void verifyLatestNews() {
	  LatestNewsPage NewsPage = new LatestNewsPage();
	  NewsPage.clickNavbarHamburger();
	  NewsPage.clickLatestNews();
	  NewsPage.verifyLatestNewsHeading();
	  NewsPage.verifyUmaxxLaunchArticleText();
	  NewsPage.verifyLatestNewsArticleTitle();
	  NewsPage.verifyRural5GHeadingText();
	//  NewsPage.clickUmaxxLaunchesWorldFirstArticle();
	  NewsPage.clickThirdLatestNewsLink();
	  NewsPage.switchToNewWindowAndCloseIt();
	  NewsPage.clickSecondLatestNewsLink();
	  NewsPage.switchToNewWindowAndCloseIt();
	  NewsPage.clickFirstLatestNewsLink();
      NewsPage.switchToNewWindowAndCloseIt();

  }
}
