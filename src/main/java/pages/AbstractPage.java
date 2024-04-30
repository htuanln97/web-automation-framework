package pages;

import java.util.function.Supplier;

import com.microsoft.playwright.Page;

import core.PlaywrightFactory;

public abstract class AbstractPage {

	protected Page page;

	public AbstractPage() {
		init();
	}

	private void init() {
		this.page = PlaywrightFactory.getPage();
	};
	
	public void setAndConfigurePage(final Page page) {
		this.page = page;
	}

	public static <T extends AbstractPage> T getPageObject(Class<T> clazz) {
		Supplier<T> page = () -> {
			try {
				return clazz.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		};
		return page.get();
	}

	public static <T extends AbstractPage> T createInstance(final Page page, final Class<T> clazz) {
		try {
			AbstractPage instance = clazz.getDeclaredConstructor().newInstance();

			instance.setAndConfigurePage(page);
			instance.init();

			return clazz.cast(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new NullPointerException("Page class instantiation failed.");
	}
}
