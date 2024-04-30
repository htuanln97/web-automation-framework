package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	private static ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> threadLocalBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserType> threadLocalBrowserType = new ThreadLocal<>();
	private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
	
	public PlaywrightFactory() {}

	public static Playwright getPlaywright() {
		return threadLocalPlaywright.get();
	}

	public static BrowserContext getBrowserContext() {
		return threadLocalBrowserContext.get();
	}

	public static Browser getBrowser() {
		return threadLocalBrowser.get();
	}
	
	public static BrowserType getBrowserType() {
		return threadLocalBrowserType.get();
	}

	public static Page getPage() {
		return threadLocalPage.get();
	}

	public Page getPage(String browserName) {
		threadLocalPlaywright.set(Playwright.create());
		LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000);
		switch (browserName) {
		case "chromium":
			threadLocalBrowserType.set(getPlaywright().chromium());
			break;
		case "chrome":
			threadLocalBrowserType.set(getPlaywright().chromium());
			launchOptions.setChannel("chrome");
			break;
		case "edge":
			threadLocalBrowserType.set(getPlaywright().chromium());
			launchOptions.setChannel("msedge");
			break;
		case "firefox":
			threadLocalBrowserType.set(getPlaywright().firefox());
			break;
		case "webkit":
			threadLocalBrowserType.set(getPlaywright().webkit());
			break;
		default:
			throw new IllegalArgumentException(String.format("Unsupported browser name as: '%s'", browserName));
		}
		
		threadLocalBrowser.set(getBrowserType().launch(launchOptions));
		threadLocalBrowserContext.set(getBrowser().newContext());
		threadLocalPage.set(getBrowserContext().newPage());
		
		return getPage();
	}

	public Page getPage(String sBrowserType, String sURL) {
		getPage(sBrowserType).navigate(sURL);
		return getPage();
	}

	public static void closeBrowserContext() {
		if(getPage() != null) {
			getPage().context().browser().close();
		}
	}
	
	public static void closePlaywright() {
		if(getPlaywright() != null){
			getPlaywright().close();
		}
	}
}
