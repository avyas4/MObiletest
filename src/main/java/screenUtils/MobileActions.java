package screenUtils;
 
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
 

//**********************************************************************************************************
//Description: This is the main class of MobileActions such as swipe, tap, multitouch, etc.
//**********************************************************************************************************
public class MobileActions {
 
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
 
    public MobileActions (AppiumDriver<MobileElement> appiumDriver,WebDriverWait explicitWait) {
        driver = appiumDriver;
        wait=explicitWait;
    }
 
    //Tap to an element for 250 milliseconds
    public void tapByElement (MobileElement mobileElement) {
        new TouchAction<>(driver)
                .tap(tapOptions().withElement(element(mobileElement)))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }
 
    //Tap by coordinates
    public void tapByCoordinates (int x,  int y) {
        new TouchAction<>(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }
 
    //Send keys
    public void setText(MobileElement element,String inputText) {
    	element.clear();
        element.setValue(inputText);
    }
    
    //Press by element
    public void pressByElement (MobileElement element, long seconds) {
        new TouchAction<>(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction<>(driver)
                .press(point(x,y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
 
        new TouchAction<>(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }
 
    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchAction<>(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
 
    //Swipe by elements
    public void swipeByElements (MobileElement startElement, MobileElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
 
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
 
        new TouchAction<>(driver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }
 
    //Multitouch action by using an android element
    public void multiTouchByElement (MobileElement mobileElement) {
        TouchAction<?> press = new TouchAction<>(driver)
                .press(element(mobileElement))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();
 
        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }
    
    public void switchContext(String contextToSwitch) {
    	 Set<String> availableContexts = driver.getContextHandles();
    	 for(String context : availableContexts) {
    	 if(context.contains(contextToSwitch)){
	    	 driver.context(context);
	    	 driver.getPageSource();
	    	 break;
    	 	}
    	 }
    }
    
    public void waitUntilElementPresent(MobileElement mobileElement) {
    	wait.until(ExpectedConditions.visibilityOf(mobileElement));
	 }
}
