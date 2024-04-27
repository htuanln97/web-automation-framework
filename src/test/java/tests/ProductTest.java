package tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import utils.enums.Categories;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ProductTest extends TestBase{
	
	
	@Test
	public void productTitle() {
		// test123456q
		page.click(String.format("//a[text()='%s']", Categories.PHONES.toString()));
		page.click("//a[text()='Samsung galaxy s7']");
		Locator phoneName = page.locator("//h2[@class='name']");
		assertThat(phoneName).hasText("Samsung galaxy s7");
	}
}
