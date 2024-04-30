package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;

import core.PlaywrightFactory;
import pages.AbstractPage;
import pages.CartPage;
import pages.HomePage;
import pages.HeaderPage;

public class TestBase {
	protected Page page;
	protected Properties prop;
	private PlaywrightFactory playwrightFactory;

	@Parameters({ "broswerType" })
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String broswerType) {
		playwrightFactory = new PlaywrightFactory();
		prop = initProperties();
		page = playwrightFactory.getPage(broswerType, prop.getProperty("url"));
		page.setDefaultTimeout(Integer.valueOf(prop.getProperty("default_timeout")) * 1000);
	}

	@AfterMethod
	public void afterMethod() {
		PlaywrightFactory.closeBrowserContext();
		PlaywrightFactory.closePlaywright();
	}

	/**
	 * This method is used to initialize the properties from config file
	 */
	public Properties initProperties() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
