package com.andres.app.Soat;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CotizacionSoat {
	
	WebDriver driver;
	WebElement accion;
	String url = "https://compratusoat.com.co/";
	
	public void seleccionar(String xpatch) {
		
		WebDriverWait myWaitVar = new WebDriverWait(driver, 40);
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpatch)));
		accion=driver.findElement(By.xpath(xpatch));
		accion.click();
	}
	
	public void ponerDatos(String localizador, String texto) throws InterruptedException {
		WebDriverWait myWaitVar = new WebDriverWait(driver, 40);
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localizador)));
		//Thread.sleep(500);
		WebElement accion5 = driver.findElement(By.xpath(localizador));
		accion5.clear();
		Thread.sleep(500);
		accion5.sendKeys(texto);
		//Thread.sleep(500);
	}
	

	
	@Before
	public void inicio() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() throws InterruptedException {
	//	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		ponerDatos("//*[@id=\"pro2\"]/div[2]/input", "OHL87D");
		ponerDatos("//input[@id=\"mail\"]","fabianpaezh2@gmail.com");
		ponerDatos("//input[@id=\"name\"]", "Edwin");
		ponerDatos("//input[@id=\"apellidos\"]", "Herrera");
		ponerDatos("//input[@id=\"phone\"]", "3174528976");
		seleccionar("//input[@id=\"accept\"]");
		seleccionar("//button[@class=\"gotit\"]");
		seleccionar("//div[@id=\"modalTerminos\"]//button[@class=\"btn btn-primary\"]");
		
		WebElement accion2 = driver.findElement(By.xpath("//input[@id=\"btsubmit\"]"));
		accion2.submit();
		
		seleccionar("//input[@class=\"btn btn-primary btn-green btn-interno fw-700\"]");
		
		
	//	ponerDatos("//input[@id='cedula']", "1024567897");
	
		//ponerDatos("//input[@id='addres']", "Calle 69A sur #64-46");
		
		ponerDatos("//input[@id='inputSelect']", "Bogota D.C.");
		
		seleccionar("//input[@class='btn btn-primary btn-green btn-interno fw-700']");
		
		WebDriverWait myWaitVar = new WebDriverWait(driver, 40);
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='text_tot']")));
		WebElement accion7 = driver.findElement(By.xpath("//span[@id='text_tot']"));
		System.out.println(accion7.getText());
		assertEquals("491,900", accion7.getText());

		
		
	}
	
	@After
	public void cierre() {
		
		
	}

}
