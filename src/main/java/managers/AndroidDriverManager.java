package managers;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidDriverManager {
	private AppiumDriver<MobileElement> driver;
	private static AppiumDriverLocalService service;
	public String serverUrl;
	
	/*
	###################################################################################
    Description  :  Returns Appium driver session based on the desired capabilities 
	###################################################################################
    */
    public AppiumDriver<MobileElement> getDriver(Properties desiredCapabilities) throws Exception{
        //Check if driver is not instantiated
    	if (driver == null) {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
        	Set<Object> keys = desiredCapabilities.keySet();
            for(Object key:keys){
            	if(((String)key).equals("app")) 
            		capabilities.setCapability((String)key, new File(desiredCapabilities.getProperty((String)key)).getAbsolutePath());
            	else 
            		capabilities.setCapability((String)key, desiredCapabilities.getProperty((String)key));
            }
            driver = new AndroidDriver<MobileElement>(new URL(service.getUrl().toString()), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
    /*
	###############################################################################
    Description  :  Function to start Appium service based on the Operating system
	###############################################################################
	*/
	public static void startAppiumService() throws Exception {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("mac")) {
		  service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		                                                      .usingDriverExecutable(new File("/Users/asthayvas/.nvm/versions/node/v12.16.0/bin/node"))
		                                                      .usingAnyFreePort().withArgument(() -> "--allow-insecure","chromedriver_autodownload")
		                                                      .withAppiumJS(new File("/Users/asthayvas/.nvm/versions/node/v12.16.0/bin/appium")));
	      service.start();
		} else if (osName.contains("win")) 
			service=new AppiumServiceBuilder().usingAnyFreePort().withArgument(() -> "--allow-insecure","chromedriver_autodownload").build();
		//Check if the Appium server is running or not
		if(!service.isRunning()) 
			throw new Exception("Appium Service was NOT strated successfully for operating system: "+osName);
	}

	/*
	###############################################################################
    Description  :  Function to stop Appium service
	###############################################################################
	*/
	public static void stopAppiumService(){
		service.stop();
	}
}