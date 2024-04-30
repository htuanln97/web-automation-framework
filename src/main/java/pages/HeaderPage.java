package pages;

import utils.enums.Categories;

public class HeaderPage extends AbstractPage {
	private final String linkNavigationBar = "//a[@class='nav-link'][normalize-space(text()) = '%s']";
	private final String linkCategories = "//a[text()='%s']";

	public HeaderPage() {
		// super();
	}

	@SuppressWarnings("unchecked")
	public <T extends HeaderPage> T clickOnNavigationBar(final String name) {
		page.click(String.format(linkNavigationBar, name));
		switch (name) {
		case "Home":
			return (T) new HomePage();
		case "Cart":
			return (T) new CartPage();
		case "Log in":
			return (T) new LoginPage();
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

	public void selectCategories(final Categories category) {
		page.click(String.format(linkCategories, category.toString()));
	};

	public void selectCategories(final String category) {
		page.click(String.format(linkCategories, category));
	};
}
