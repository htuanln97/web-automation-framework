package pages;

import java.util.Map;

import com.microsoft.playwright.Locator;

import utils.enums.Categories;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage extends HeaderPage{
	
	public CartPage() {}
	
	private final String btnPlaceOrder = "//button[text()='Place Order']";
	private final String btnClose = "//div[@id='orderModal']//button[text()='Close']";
	private final String btnPurchase = "//div[@id='orderModal']//button[text()='Purchase']";
	private final String btnDelete = "//tr[@class='success'][.//td[text()='%s']][.//td[text()='%s']]//a[text()='Delete']";
	
	private final String lblItemName = "(//tr[@class='success']/td)[2]";
	private final String lblItemPrice = "(//tr[@class='success']/td)[3]";
	
	private final String iconSuccess = "//div[@class='sa-placeholder']";
	private final String lblSuccessPurchaseMessage = "//h2[text()='Thank you for your purchase!']";
	private final String successFormInfo = "//p[normalize-space(@class)='lead text-muted']";
	
	@Override
	@Deprecated
	public void selectCategories(final Categories category) {
		throw new UnsupportedOperationException("Unable to use this method in this page");
	};
	
	@Override
	@Deprecated
	public void selectCategories(final String category) {
		throw new UnsupportedOperationException("Unable to use this method in this page");
	};
	
	public void clickOnPlaceOrder() {
		page.click(btnPlaceOrder);
	}
	
	public void clickOnCloseAtPlaceOderForm() {
		page.click(btnClose);
	}
	
	public void clickOnPurchaseAtPlaceOderForm() {
		page.click(btnPurchase);
	}
	
	public void deleteItem(final String itemName, final String price) {
		page.click(String.format(btnDelete, itemName, price));
	}
	
	public void isNotDisplayedItem (final String itemName, final String price) {
		Locator locator = page.locator(String.format(btnDelete, itemName, price));
		assertThat(locator).hasCount(0);
	}
	
	public void fillInPlaceOrderForm(Map<String, String> form) {
		page.fill("id=name", form.get("name"));
		page.fill("id=country", form.get("country"));
		page.fill("id=city", form.get("city"));
		page.fill("id=card", form.get("card"));
		page.fill("id=month", form.get("month"));
		page.fill("id=year", form.get("year"));
	}
	
	public void verifyItemInCart(final String itemName, final String price) {
		Locator itemNameLocator = page.locator(lblItemName);
		Locator itemPriceLocator = page.locator(lblItemPrice);
		assertThat(itemNameLocator).hasText(itemName);
		assertThat(itemPriceLocator).hasText(price);
	}
	
	public void verifyFormFillInSuccess(final String name, final String cartNumber, final String date) {
		assertThat(page.locator(iconSuccess)).isVisible();
		assertThat(page.locator(lblSuccessPurchaseMessage)).isVisible();
		Locator locator = page.locator(successFormInfo);
		assertThat(locator).containsText(name);
		assertThat(locator).containsText(cartNumber);
		assertThat(locator).containsText(date);
	}
}
