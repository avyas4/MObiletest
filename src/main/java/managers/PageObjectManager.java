package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LoginScreen;
import pageObjects.SearchResultsScreen;

public class PageObjectManager {
	
	private LoginScreen loginScreen;
	private SearchResultsScreen searchResultsScreen;
	private AppiumDriver<MobileElement> driver;
	
	public PageObjectManager(AppiumDriver<MobileElement> driver) {
		 this.driver = driver;
	 }
	
	 public LoginScreen getLoginScreen() {
		 return (loginScreen == null) ? loginScreen = new LoginScreen(driver) : loginScreen;
	 }
	 
	 public SearchResultsScreen getSearchResultsScreen() {
		 return (searchResultsScreen == null) ? searchResultsScreen = new SearchResultsScreen(driver) : searchResultsScreen;
	 }
}
