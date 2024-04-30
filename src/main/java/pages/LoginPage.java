package pages;

import data.Account;

public class LoginPage extends HeaderPage{

	private final String btnLogin = "//button[@onclick='logIn()']";
	
	public void fillInUserNameAndPassword(final String userName, final String password) {
		page.fill("id=loginusername", userName);
		page.fill("id=loginpassword", password);
	}
	
	public void clickOnLogin() {
		page.click(btnLogin);
	}
	
	public HomePage logIn(final String userName, final String password) {
		fillInUserNameAndPassword(userName, password);
		clickOnLogin();
		return new HomePage();
	}
	
	public HomePage logIn(Account account) {
		HomePage homePage = logIn(account.getUserName(), account.getPassword());
		return homePage;
	}
}
