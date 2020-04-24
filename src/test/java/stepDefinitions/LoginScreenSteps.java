package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.LoginScreen;

public class LoginScreenSteps {
	
	 TestContext testContext;
	 LoginScreen loginScreen;
	 
	 public LoginScreenSteps(TestContext context) {
		 testContext = context;
		 loginScreen = testContext.getPageObjectManager().getLoginScreen();
	 }
	 
	@Given("User is logged in the application")
	public void user_is_logged_in_the_application() {
		loginScreen.loginToApplication();
	}
}
