
package com.sap.timp.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseEliel extends TestBaseSteven {
 
	TestBaseSteven testeBaseSteven = new TestBaseSteven();

	public WebDriver initializationE() {

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

	public void sleep(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitExpectXpath(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		
	}
	
	public void waitExpectElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void actionsMoveToElementXpath(String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(xpath))).perform();
	}
	
	public void actionsMoveToElementElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void invisibilityOfElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		
	}

	public void attributeToBeXpath(String locator, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.attributeToBe(By.xpath(locator), attribute, value));
	}
	
	public void attributeToBeElement(WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}
	
	
	public void dobleClickXpath(String locator) {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(By.xpath(locator))).perform();
		
	}
	
	
	public void dobleClickElement(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		
	}
	
	public void moveToElement(WebElement element, WebElement hacia) {
		Actions actions = new Actions(driver);
		
		actions.dragAndDrop(element,hacia).perform();
		
	}
	
	public String fechaActual() {

		Date fecha = new Date();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

		return df.format(fecha);

	}
	
	public String fechaAyer() {

		Date fecha = new Date();
		
		Date ayer = new Date(fecha.getTime() + TimeUnit.DAYS.toMillis( -1 ));

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

		return df.format(ayer);

	}


public String dataanterior() {
	
	DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	cal.add (Calendar.DAY_OF_MONTH, -1);
	
	return df.format(cal.getTime());
	
}
	
	public Double convertToDouble(String numero) {
				
		Double result = new Double(numero);
		
		return result;
		
	}
	
	
	
	public Integer contarWebElementsList(List<WebElement> colunas){
		
		int contar = -1;

		if (colunas.size() > 0) {
			
			for (int i = 0; i < colunas.size(); i++) {
				contar = contar + 1;
			}	
		}else {
			contar = 0;
		}
		

		
		return contar;
		
	}
	
	public void closeSelectTypeCheckbox(WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
	}
	
	public void idInserir(String nome,String idRegistro) {
		Preferences id = Preferences.userRoot();

		id.put(nome, idRegistro);
		
	}
	
	public String idObter(String nome) {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong(nome, 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}

	public void idInserir1(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR1", idRegistro);

	}

	public String idObter1() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR1", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}

	public void idInserir2(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR2", idRegistro);

	}

	public String idObter2() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR2", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}

	public void idInserir3(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR3", idRegistro);

	}

	public String idObter3() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR3", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}

	public void idInserir4(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR4", idRegistro);

	}

	public String idObter4() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR4", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}
	
	public void idInserir5(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR5", idRegistro);

	}

	public String idObter5() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR5", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}
	
	
	public void idInserir6(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR6", idRegistro);

	}

	public String idObter6() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR6", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}
	

}

