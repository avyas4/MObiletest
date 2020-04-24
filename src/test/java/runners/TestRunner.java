package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.AndroidDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/functionalTests",
	glue= {"stepDefinitions"}
 )
public class TestRunner {
	
	@BeforeClass
	public static void startAppium() throws Exception {
		AndroidDriverManager.startAppiumService();
	}
	@AfterClass
	  public static void stopAppium() {
		AndroidDriverManager.stopAppiumService();
	  }
}