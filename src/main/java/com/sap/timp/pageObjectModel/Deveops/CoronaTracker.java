package com.sap.timp.pageObjectModel.Deveops;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.sap.timp.base.DevopsMain;

public class CoronaTracker extends DevopsMain{
	
	public void changeCountry(String country) throws InterruptedException {
		Thread.sleep(8000);
		Select countryDropdown = new Select(driver.findElement(By.xpath("//select")));
		countryDropdown.selectByVisibleText(country);
		Thread.sleep(5000);
		
	}
	
	
	public void getData() throws InterruptedException {
		Thread.sleep(5000);
		String infected = driver.findElement(By.xpath("//div[@class='MuiCardContent-root']/p[text()='Infected']/following-sibling::h2/span")).getText();
		String recovered = driver.findElement(By.xpath("//div[@class='MuiCardContent-root']/p[text()='Recovered']/following-sibling::h2/span")).getText();
		String Deaths = driver.findElement(By.xpath("//div[@class='MuiCardContent-root']/p[text()='Deaths']/following-sibling::h2/span")).getText();
		
	    System.out.println("The current state of Corona In India is as follows:\n");
	    System.out.println("Number of active cases = "+infected);
	    System.out.println("Number of recoveries = "+recovered);
	    System.out.println("Number of deaths = "+Deaths);
	}

}
