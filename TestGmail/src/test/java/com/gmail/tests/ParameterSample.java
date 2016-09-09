package com.gmail.tests;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gmail.constants.ConstantValues;
import com.gmail.pages.SignIn_Page;
import com.gmail.utils.Excel;

public class ParameterSample implements ConstantValues{

	
	/*	------------------------------
	Implementing the SELENIUM GRID
	------------------------------*/
	
	private WebDriver driver;
	
	SoftAssert softAssert = new SoftAssert();
	public Excel excel_Instance;
	public SignIn_Page SignIn_PageInstance;
	public boolean b;

	@BeforeClass
	public void SetUpFF() throws IOException{
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.VISTA);
		capabilities.setBrowserName(BrowserType.IE);


		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);*/
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1#identifier");
		
		
	}
	
	
	@Test()
	public void Test_SignInToEnteringEmailWithFF() throws InterruptedException{
		
		//Thread.sleep(12000);
		//JOptionPane.showMessageDialog(null, "TRIGGERING @TEST NOW --->   " );
		
		SignIn_PageInstance = PageFactory.initElements(driver,
				SignIn_Page.class);

		excel_Instance = new Excel();

		for (int i = 1; i < excel_Instance.arrayContainer.length; i++) {
			String userName = excel_Instance.arrayContainer[i][0];
			String password = excel_Instance.arrayContainer[i][1];
			String errorMsg = excel_Instance.arrayContainer[i][2];

			SignIn_PageInstance.setEmail(userName);
			SignIn_PageInstance.clickNext();
			SignIn_PageInstance.setPassword(password);
			SignIn_PageInstance.clickSignIn();
			Thread.sleep(5000);
			b = SignIn_PageInstance.getErrorMessage().getText()
					.contains(errorMsg);
			softAssert.assertEquals(b, true,
					"Invalid message incomparison to page!---->    " + errorMsg
							+ "Data at Row -->  " + i);
			SignIn_PageInstance.driver.navigate().to(Url);
		}
	}
	
	
	
}
