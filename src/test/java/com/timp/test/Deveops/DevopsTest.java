package com.timp.test.Deveops;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sap.timp.base.DevopsMain;
import com.sap.timp.pageObjectModel.Deveops.CoronaTracker;

public class DevopsTest extends DevopsMain{
	
	 //LoginTC loginTC; 
	String url = "";
	CoronaTracker corona = new CoronaTracker();
	
	@BeforeClass
	public void beforeClass() throws IOException {
		 url = getPropValues();
		driver = initialization();	
    // 	loginTC = new LoginTC();
//		acessarBPMAPO = new AcessarBPMAPO();
//		ativadorDeProcessosPesquisaPorNomeDoProcessoPO = new AtivadorDeProcessosPesquisaPorNomeDoProcessoPO();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	//@Test
	public void login() throws InterruptedException {
		driver.get(url);
		Thread.sleep(8000);
		
	}
	
	@Test
	public void checkDataForIndia() throws InterruptedException {
		login();
		System.out.println("current URL "+driver.getCurrentUrl()+"\n");
		corona.changeCountry("India");
		corona.getData();
	}
}
