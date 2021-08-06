package com.sap.timp.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestBaseKenssy extends TestBaseSteven{
	
	TestBaseSteven testeBaseSteven = new TestBaseSteven();

	public WebDriver initializationKen() {
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
	
	
	
	public String diaDespues() {
		DateFormat df = new SimpleDateFormat ("dd");
		Calendar cal = Calendar.getInstance();
		cal.add (Calendar.DATE, +1);
		
		return df.format(cal.getTime());
	}

	public String capitalize(String cadena) {
		String[] split = cadena.split("");
        for (int i = 0; i < split.length; i++) {
            if(i == 0 || split[i-1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            }
        }
        
        return String.join("", split);
	}
	

	
	public String diaHoy() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar();
		
		String dia = Integer.toString(c2.get(Calendar.DATE));
		

		return dia;

	}
	
	public String diaActual() {
		// Obtienes el mes actual
		int anio = LocalDate.now().getDayOfMonth();
		
		String anioString = String.valueOf(anio);
		return anioString;
	}
	
	public String anioActual() {
		// Obtienes el mes actual
		int anio = LocalDate.now().getYear();
		
		String anioString = String.valueOf(anio);
		return anioString;
	}
	
	public String getCodeMonthByMonth(String mes){
	    Hashtable<String, String> meses = new Hashtable<String, String>();
        meses.put("Janeiro","01");
        meses.put("Fevereiro","02");
        meses.put("Março","03");
        meses.put("Abril","04");
        meses.put("Maio","05");
        meses.put("Junho","06");
        meses.put("Julho","07");
        meses.put("Agosto","08");
        meses.put("Setembro","09");
        meses.put("Outubro","10");
        meses.put("Novembro","11");
        meses.put("Dezembro","12");
        return meses.get(mes);
	}
	
	public String dataanterior() {
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add (Calendar.DAY_OF_MONTH, -1);
		
		return df.format(cal.getTime());
		
	}
	
	public void idInserir5(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR1", idRegistro);

	}

	public String idObter5() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR1", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}

	public void idInserir6(String idRegistro) {

		Preferences id = Preferences.userRoot();

		id.put("idR1", idRegistro);

	}

	public String idObter6() {

		Preferences id = Preferences.userRoot();

		long idRegistro = id.getLong("idR1", 1);

		String idReturn = String.valueOf(idRegistro);

		return idReturn;

	}
	

	public void closeSelectTypeCheckbox(WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
	}
	

}
