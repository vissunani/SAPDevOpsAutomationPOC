
package com.sap.timp.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBaseKathy extends TestBaseSteven {

	TestBaseSteven testeBaseSteven = new TestBaseSteven();

	public WebDriver initializationK() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		//Evita que el mensaje de "Chorme siendo controlado por un software de automatizacion" aprezca
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		
		//Evita que la ventana de guardar contraseña aparezca
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
        
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.get(tc2);
		
	    driver.get(cloud);
		return driver;
		
		
	}

}

