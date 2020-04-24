package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private TestContext context;
	public AppiumDriver<MobileElement> driver;
	
	public Hooks(TestContext testContext) {
		context=testContext;
	}
	
	 @Before
	 public void BeforeSteps(Scenario scenario) throws Exception {
		driver=context.getAndroidDriverManager().getDriver(context.getFileObjectManager().loadCapabilties());
	}
	
	 @After
	 public void AfterSteps(Scenario scenario) throws Exception {
		/*
		 if (scenario.isFailed()) {
			 String screenshotName = scenario.getName().replaceAll(" ", "_");
			 //This takes a screenshot from the driver at save it to the specified location
			 File sourcePath = ((TakesScreenshot) context.getAndroidDriverManager().getDriver(context.getFileObjectManager().loadCapabilties())).getScreenshotAs(OutputType.FILE);
			 File destinationPath = new File(System.getProperty("user.dir") + "/target/surefire-reports/screenshots/" + screenshotName + ".png");
			 Files.copy(sourcePath, destinationPath);
		}	
		*/ 
		driver.quit();
	 }
}
