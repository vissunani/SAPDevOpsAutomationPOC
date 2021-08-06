package com.sap.timp.base;
         
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
 
public class TestBaseCristhian extends TestBaseSteven{
  
	TestBaseSteven testeBaseSteven = new TestBaseSteven();

	public WebDriver initializationC() {
		
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
	
	
	public String capitalize(String 
			cadena) {
		String[] split = cadena.split("");
        for (int i = 0; i < split.length; i++) {
            if(i == 0 || split[i-1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            }
        }
        
        return String.join("", split);
	}
	
	public String mesActual() {
		// Obtienes el mes actual
		Month mes = LocalDate.now().getMonth();

		// Obtienes el nombre del mes
		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		nombreMes = capitalize(nombreMes);
		
		return nombreMes;
	}
	
	public String anioActual() {
		// Obtienes el mes actual
		int anio = LocalDate.now().getYear();
		
		String anioString = String.valueOf(anio);
		return anioString;
	}
	
	public void closeSelectTypeCheckbox(WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
	}

}
