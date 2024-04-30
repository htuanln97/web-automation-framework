package tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import data.PlaceOrder;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.HeaderPage;
import utils.common.Utilities;
import utils.enums.Categories;
import utils.enums.NavigationBar;



public class CartTest extends TestBase{
	private HomePage homePage;
	private CartPage cartPage;
	private ProductPage productPage;
	
	@Test
	public void addItemToCart() {
//		HomePage homePage = new HomePage(); ? Question
//		CartPage cartPage;
		
		String phoneName = "Samsung galaxy s7";
		homePage = new HomePage();
		homePage.selectCategories(Categories.PHONES);
		productPage = homePage.selectItem(phoneName);
		// Verify phone name
		assertEquals(productPage.getName(), phoneName);
		String phonePrice = productPage.getPrice();
		productPage.clickOnAddToCartButton();
		cartPage = productPage.clickOnNavigationBar(NavigationBar.CART.toString());
		// Verify item name and price in cart
		cartPage.verifyItemInCart(phoneName, phonePrice);
	}
	
	@Test
	public void deleteItemFromCart() {		
		String laptopName = "MacBook Pro";
		homePage = new HomePage();
		homePage.selectCategories(Categories.LAPTOPS);
		productPage = homePage.selectItem(laptopName);
		String laptopPrice = productPage.getPrice();
		productPage.clickOnAddToCartButton();
		cartPage = productPage.clickOnNavigationBar(NavigationBar.CART.toString());
		cartPage.deleteItem(laptopName, laptopPrice);
		// Verify item is deleted
		cartPage.isNotDisplayedItem(laptopName, laptopPrice);
	}
	
	@Test
	public void fillInPlaceOrderForm() {
		homePage = new HomePage();
		cartPage = homePage.clickOnNavigationBar(NavigationBar.CART.toString());
		cartPage.clickOnPlaceOrder();
		PlaceOrder placeOrderData = new PlaceOrder("Automation Test", "Vietname", "HCM city", "123456789", "01", "2025");
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("name", placeOrderData.getName());
		map.put("country", placeOrderData.getCountry());
		map.put("city", placeOrderData.getCity());
		map.put("card", placeOrderData.getCreditCard());
		map.put("month", placeOrderData.getMonth());
		map.put("year", placeOrderData.getYear());
		cartPage.fillInPlaceOrderForm(map);
		cartPage.clickOnPurchaseAtPlaceOderForm();
		// Verify fill in success
		String today = 	Utilities.getDateNow("dd/M/yyyy");
		
		cartPage.verifyFormFillInSuccess(map.get("name"), map.get("card"), today);
		
	}
}
