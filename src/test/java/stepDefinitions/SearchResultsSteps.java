package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;
import pageObjects.SearchResultsScreen;

public class SearchResultsSteps {
	
	 TestContext testContext;
	 SearchResultsScreen searchResultsScreen;
	 
	 public SearchResultsSteps(TestContext context) {
		 testContext = context;
		 searchResultsScreen = testContext.getPageObjectManager().getSearchResultsScreen();
	 }
	 
	 @When("I search for an item speciifed in the data sheet")
	 public void i_search_for_an_item_speciifed_in_the_data_sheet() {
		 searchResultsScreen.searchItem();
		 searchResultsScreen.selectRandomProduct();
	 }
}
