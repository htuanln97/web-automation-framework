package pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;

public class HomePage extends HeaderPage{
	private final String linkItem = "//h4[@class='card-title']/a[text()='%s']";
	private final String lblWelcomeUserMessage = "//a[@class='nav-link'][text()='Welcome %s']";
	
	public ProductPage selectItem(final String item) {
		page.click(String.format(linkItem, item));
		return new ProductPage();
	}
	
	public void isDisplayedWelcomeUserMessage(final String accountName) {
		Locator locator = page.locator(String.format(lblWelcomeUserMessage, accountName));
		assertThat(locator).isVisible();
	}
}
