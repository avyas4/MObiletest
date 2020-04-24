package managers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class FileReaderManager {
	
	private static Properties desiredCapabilities;
	
	public Properties loadCapabilties() throws Exception {
		 if(desiredCapabilities == null) {
			 try {
				 FileReader reader = new FileReader("configs//DesiredCapabilities.properties");
				 desiredCapabilities = new Properties();
				 desiredCapabilities.load(reader);
				 reader.close();
			  } catch (FileNotFoundException e) {
				 throw new RuntimeException("DesiredCapabilities.properties could NOT be loaded successfully");
			}
		 }
		 return desiredCapabilities;
	}
}
