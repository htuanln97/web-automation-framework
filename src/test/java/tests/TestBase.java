package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;

import core.PlaywrightFactory;
import utils.constant.Constant;

public class TestBase {
	protected Page page;
	PlaywrightFactory playwrightFactory;
	
	@Parameters({"broswerType"})
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String broswerType) {
		playwrightFactory = new PlaywrightFactory();
		page = playwrightFactory.getPage(broswerType, Constant.BASE_URL);
		page.setDefaultTimeout(60000);
	}

	@AfterMethod
	public void afterMethod() {
		page.context().browser().close();
		playwrightFactory.closePlaywright();
	}
}
