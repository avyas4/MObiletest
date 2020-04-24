package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screenUtils.MobileActions;

public class BaseScreen {
	 
	protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;
    protected MobileActions mobileActions;
 
    //Constructor
    public BaseScreen (AppiumDriver<MobileElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
        mobileActions = new MobileActions(driver,wait); 
    }
}