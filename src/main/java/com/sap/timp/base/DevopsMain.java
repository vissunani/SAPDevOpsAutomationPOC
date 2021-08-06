package com.sap.timp.base;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DevopsMain {

	String result = "";
	InputStream inputStream;
	
	public static WebDriver driver;
	
	public WebDriver initialization() throws MalformedURLException {

//		WebDriver driver = null;
//		String osname= System.getProperty("os.name").toLowerCase();
//		System.out.println("OSNAME " +osname);
//		
//		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-infobars");
//		options.setExperimentalOption("useAutomationExtension", false);
//		
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		options.setExperimentalOption("prefs", prefs);
//		
//		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--disable-extensions");
//        
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		

			  DesiredCapabilities dr = DesiredCapabilities.chrome();
			        dr.setBrowserName("chrome");               
			        dr.setPlatform(Platform.LINUX);
			        RemoteWebDriver	driver = new RemoteWebDriver(new URL("http://65.0.75.77:4444/wd/hub"), dr);

			        return driver;
	}
 
	public String getPropValues() throws IOException {
 
		//	Properties prop = new Properties();
			String propFileName = "parameter.properties";
			String parent = System.getProperty("user.dir");
			String filePath = parent+ "/" +propFileName;
			System.out.println("filepath "+filePath);
			 FileInputStream fis = null;
		      Properties prop = null;
		      try {
		         fis = new FileInputStream(filePath);
		         prop = new Properties();
		         prop.load(fis);
		      } catch(FileNotFoundException fnfe) {
		         fnfe.printStackTrace();
		      } catch(IOException ioe) {
		         ioe.printStackTrace();
		      } finally {
		         fis.close();
		      }
		      
		     result = prop.getProperty("url");
	//	result = "https://coronadev-forgiving-badger-ft.cfapps.us10.hana.ondemand.com/";
		return result;
	}
}
