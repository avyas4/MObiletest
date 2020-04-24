package pageObjects;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.collect.ImmutableMap;
import dataProviders.JsonDataReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import testDataTypes.SearchProduct;

public class SearchResultsScreen extends BaseScreen{
	public SearchResultsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }
	 //Screen Elements
	 @AndroidFindBy(id = "rs_search_src_text") 
	 private MobileElement txt_SearchBar;
	 /*
	 @AndroidFindBy(xpath = "//div[contains(@class,'s-result-item')]") 
	 private List<MobileElement> list_searchResults;
	 */
	 
	 //Screen Functions
    //Search the Item
    public void searchItem () {
    	SearchProduct searchProduct=JsonDataReader.<SearchProduct>getTestDataFromJson(SearchProduct.class);
    	mobileActions.tapByElement(txt_SearchBar);
    	mobileActions.setText(txt_SearchBar,searchProduct.searchItem);
    	driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }
    
    public void selectRandomProduct () {
    	mobileActions.switchContext("WEBVIEW");
    	int count=driver.findElements(By.xpath("//div[contains(@class,'s-result-item')]")).size();
    	assertNotSame(0,count,"ERROR: Search result count is 0");
    	//int random=(new Random()).nextInt(list_searchResults.size());
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElements(By.xpath("//div[contains(@class,'s-result-item')]")).get(2));
    }
}