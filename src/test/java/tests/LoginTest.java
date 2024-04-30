package tests;

import org.testng.annotations.Test;

import data.Account;
import pages.HomePage;
import pages.LoginPage;
import utils.enums.NavigationBar;

public class LoginTest extends TestBase {
	private HomePage homePage;
	private LoginPage loginPage;

	@Test
	public void loginWithValidAccount() {
		Account account = new Account("test123456q", "test123456q");
		homePage = new HomePage();
		loginPage = homePage.clickOnNavigationBar(NavigationBar.LOG_IN.toString());
		homePage = loginPage.logIn(account);
		// Verify login success
		homePage.isDisplayedWelcomeUserMessage(account.getUserName());
	}
}
