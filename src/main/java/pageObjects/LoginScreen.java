package pageObjects;

import org.openqa.selenium.support.PageFactory;
import dataProviders.JsonDataReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import testDataTypes.LoginDetails;

public class LoginScreen extends BaseScreen{
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }
	 //Screen Elements
	 @AndroidFindBy(id = "sign_in_button") 
	 private MobileElement btn_SignIn;
	 @AndroidFindBy(xpath = "//*[@resource-id='ap_email_login']") 
	 private MobileElement txtbox_Email;
	 @AndroidFindBy(xpath = "//*[@resource-id='continue']") 
	 private MobileElement btn_Continue;
	 @AndroidFindBy(xpath = "//*[@resource-id='ap_password']") 
	 private MobileElement txtbox_Password;
	 @AndroidFindBy(xpath = "//*[@resource-id='signInSubmit']") 
	 private MobileElement btn_Submit;
	 @AndroidFindBy(id = "wish_list_bottom_sheet_layout") 
	 private MobileElement frame_HomePage;
	 
	//Screen Functions
    //Login to the application
    public void loginToApplication () {
    	LoginDetails loginDetails=JsonDataReader.<LoginDetails>getTestDataFromJson(LoginDetails.class);
    	mobileActions.tapByElement(btn_SignIn);
    	mobileActions.setText(txtbox_Email,loginDetails.username);
    	mobileActions.tapByElement(btn_Continue);
    	mobileActions.setText(txtbox_Password,loginDetails.password);
    	mobileActions.tapByElement(btn_Submit);
    	mobileActions.waitUntilElementPresent(frame_HomePage);
    }
}