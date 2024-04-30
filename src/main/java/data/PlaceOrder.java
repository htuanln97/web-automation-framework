package data;

public class PlaceOrder {
	private String name;
	private String country;
	private String city;
	private String creditCard;
	private String month;
	private String year;

	// Constructors
	public PlaceOrder() {
	}

	/**
	 * PlaceOrder constructor using fields
	 * 
	 * @param name
	 * @param country
	 * @param city
	 * @param creditCard
	 * @param month
	 * @param year
	 */
	public PlaceOrder(final String name, final String country, final String city, final String creditCard,
			final String month, final String year) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.creditCard = creditCard;
		this.month = month;
		this.year = year;
	}

	// Getter, Setter
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public void setCreditCard(final String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCreditCard() {
		return this.creditCard;
	}

	public void setMonth(final String month) {
		this.month = month;
	}

	public String getMonth() {
		return this.month;
	}

	public void setYear(final String year) {
		this.year = year;
	}

	public String getYear() {
		return this.year;
	}

}
