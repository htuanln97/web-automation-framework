package utils.enums;

public enum NavigationBar {
	HOME("Home"), 
	CONTACT("Contact"), 
	ABOUT_US("About us"), 
	CART("Cart"), 
	LOG_IN("Log in"), 
	LOG_OUT("Log out"),
	SIGN_UP("Sign up");

	private final String name;

	NavigationBar(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
