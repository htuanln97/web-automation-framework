package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends HeaderPage {
	private final String btnAddToCart = "//a[text()='Add to cart']";
	private final String lblName = "//h2[@class='name']";
	private final String lblPrice = "//h3[@class='price-container']";

	public void clickOnAddToCartButton() {
		page.click(btnAddToCart);
	}

	public String getPrice() {
		String price = page.textContent(lblPrice).trim();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(price);
		if (matcher.find()) {
			String number = matcher.group();
			return number;
		}
		throw new NullPointerException("Can not get item price");
	}
	
	public String getName() {
		return page.textContent(lblName).trim();
	}
}
