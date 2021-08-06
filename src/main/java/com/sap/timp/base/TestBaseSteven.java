
package com.sap.timp.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBaseSteven {

	// TC2
	protected String tc2 = "http://as1-100-01-tc2:8000/timp/login/#/login";
	// TD1
	protected String td1 = "http://as1-100-01-td1:8000/timp/login/#/login";

	protected String tq1 = "http://as1-100-01-tq1:8000/timp/login/#/login";
	
	protected String tq2 = "http://as1-100-01-tq2:8000/timp/login/#/login";

	protected String tp1 = "http://as1-100-01-tp1:8000/timp/login/#/login";
	
	protected String td2 = "http://as1-100-01-td2:8000/timp/login/#/login";
	
	protected String cloud = "https://alltax-alltax-dev-timpxsa-ui.cfapps.eu10.hana.ondemand.com/timp/tkb";

	public static WebDriver driver;
//	public String usuarioL = "TESTEAUTOMATIZADO";
//	public String senhaL = "Alltax20";
	public String usuarioL = "P000003";
	public String senhaL = "V@run2216";
	public int menuT = 12000;

	public WebDriver initialization() {

		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriverX86.exe");
	
		//ChromeOptions options = new ChromeOptions();
		//options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//driver = new ChromeDriver(options);
       // options.addArguments("--headless");
        //options.addArguments("start-maximized"); // open Browser in maximized mode
        //options.addArguments("disable-infobars"); // disabling infobars
        //options.addArguments("--disable-extensions"); // disabling extensions
        //options.addArguments("--disable-gpu"); // applicable to windows os only
        //options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        //driver = new ChromeDriver(options);

		/*
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver = new ChromeDriver(options);
        options.addArguments("--headless");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        driver = new ChromeDriver(options);
		*/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-extensions");
        
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//driver.get(tc2);
		driver.get(cloud);

		return driver;
	}

	public void fecharMensagens(String rows, String xpath) {
		int rowsR = driver.findElements(By.xpath(xpath)).size();
		
		
		if (rowsR > 0) {
			WebElement fechar = driver.findElement(By.xpath(xpath));
			fechar.click();
		}
		sleep(2000);
		
		rowsR = driver.findElements(By.xpath(xpath)).size();
		
		while (rowsR > 0) {
			
			WebElement fechar = driver.findElement(By.xpath(xpath));
			fechar.click();
			
			rowsR = driver.findElements(By.xpath(xpath)).size();
			sleep(2000);
		}
		
		
	}

	public void refresh() {
		driver.navigate().refresh();
	}
	
	public String url() {
		return driver.getCurrentUrl();
	}
	public int rows(String element) {
		
		int rows = driver.findElements(By.xpath(element)).size();
		
		return rows;
		
	}
	
	public void invisibilityOfElementOverlay() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		sleep(3000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"overlay loader dark\"]")));
		sleep(2000);

		
	}

	public void sleep(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean igualInt(int valor, int esperado) {
		
		boolean sucesso = false;
		if (valor == esperado) {
			sucesso = true;
		}else {
			sucesso = false;
		}
		
		return sucesso;
	}
	
	
	public Boolean igualDobule(double valor, double esperado) {
		
		boolean sucesso = false;
		if (valor == esperado) {
			sucesso = true;
		}else {
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public Boolean diferenteDe(double valor, double esperado) {
		
		boolean sucesso = false;
		if (valor != esperado) {
			sucesso = true;
		}else {
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
	
	
	
	public Boolean mayorQue(double mayor, double menor ) {
		
		boolean sucesso = false;
		if (mayor > menor) {
			sucesso = true;
		}else {
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public Boolean menorQue(double mayor, double menor ) {
		
		boolean sucesso = false;
		if (menor < mayor) {
			sucesso = true;
		}else {
			sucesso = false;
		}
		
		return sucesso;
	}

	public void waitExpectXpath(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 360);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

	}
	
	public String remplazarPuntos(String valor) {
		
		valor = valor.replace(".", "");

		return valor;

	}
	
	public String remplazarComas(String valor) {
		
		valor = valor.replace(",", ".");
		
		return valor;
		
		
	}
	
	public String formatear(String valor) {
		
		valor = valor.replace(".", "");
		valor = valor.replace(",", ".");
		
		return valor;
	}

	public void waitExpectElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3600);

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
		WebDriverWait wait = new WebDriverWait(driver, 3600);

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

		actions.dragAndDrop(element, hacia).perform();

	}

	public String fechaActual() {

		Date fecha = new Date();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		return df.format(fecha);

	}

	public String fechaAyer() {

		Date fecha = new Date();

		Date ayer = new Date(fecha.getTime() + TimeUnit.DAYS.toMillis(-1));

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

		return df.format(ayer);

	}
	

	public String fechaManana() {

		Date fecha = new Date();

		Date ayer = new Date(fecha.getTime() + TimeUnit.DAYS.toMillis(+1));

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

		return df.format(ayer);

	}

	public Double convertToDouble(String numero) {

		Double result = new Double(numero);

		return result;

	}
	
	public String getText(WebElement element) {

		String texto = element.getText();
		
		if (texto.isEmpty()==true) {
			texto = "vazio";
		}
		
		return texto;

	}
	
	public String textContent(WebElement element) {

		String texto = element.getAttribute("textContent");
		
		return texto;

	}
	
	public String getValue(WebElement element) {

		String texto = element.getAttribute("value");
		
		if (texto.isEmpty()==true) {
			texto = "vazio";
		}
		
		return texto;

	}
	
	
	public int convertToInt(String numero) {

		int result = new Integer(numero);

		return result;

	}

	public void attributoNotToBeEmptyElement(WebElement element, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, 360);

		wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}

	public void attributoNotToBeEmptyXpath(String xpath, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, 360);

		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.xpath(xpath)), attribute));
	}

	public void visibilityOfElementXpath(String xpath) {

		boolean isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();

		while (isPresent == false) {
			sleep(3000);
			isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();
		}

	}

	public Integer contarWebElementsList(List<WebElement> colunas) {

		int contar = -1;

		if (colunas.size() > 0) {

			for (int i = 0; i < colunas.size(); i++) {
				contar = contar + 1;
			}
		} else {
			contar = 0;
		}

		return contar;

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

	public void quit() {
		driver.close();
	}
	
	
	public String ordenar(String dato) {
		
		String recorrer = dato;
		
	    String[] recorrer2 = recorrer.split("");

	    Arrays.sort(recorrer2);

	    String sorted = "";

	    for(int i =0;i<recorrer2.length;i++){

	      sorted += recorrer2[i];
	    
	    }
		
		return sorted; 
	}
	
	public void closeSelectTypeCheckbox(WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
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
	
	
}

