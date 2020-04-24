package context;

import managers.AndroidDriverManager;
import managers.FileReaderManager;
import managers.PageObjectManager;

public class TestContext {
	
	private AndroidDriverManager androidDriverManager;
	private PageObjectManager pageObjectManager;
	private FileReaderManager fileObjectManager;
	 
	public TestContext() throws Exception{
		 androidDriverManager = new AndroidDriverManager();
		 fileObjectManager =new FileReaderManager();
		 pageObjectManager = new PageObjectManager(androidDriverManager.getDriver(fileObjectManager.loadCapabilties()));
	}
	 
	public AndroidDriverManager getAndroidDriverManager() {
		 return androidDriverManager;
	}
	 
	public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
	}
	
	public FileReaderManager getFileObjectManager() {
		 return fileObjectManager;
	}
}