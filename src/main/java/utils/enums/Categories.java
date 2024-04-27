package utils.enums;

public enum Categories {
	PHONES("Phones"), 
	LAPTOPS("Laptops"),
	MONITORS("Monitors");

	private final String name;

	Categories(final String name) {
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
