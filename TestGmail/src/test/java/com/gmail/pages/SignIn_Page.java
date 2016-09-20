package com.gmail.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.gmail.constants.ConstantValues;
import com.gmail.utils.Excel;

public class SignIn_Page implements ConstantValues {

    public WebDriver driver = null;
	Excel excel_Instance = null;

	
	
/*	class constructor 
	set driver, create Excel class instance and set obtain Array Row and Column Length*/
	public SignIn_Page(WebDriver driver) throws IOException{
		this.driver = driver;
		//REMOVED: excel_Instance = new Excel();
	}

	
	//set Elements
	@FindBy(how = How.XPATH, using = ".//*[@id='Email']")    //PropUtils_Instance.GetValue("signinpage_enteremail_xpath"));
	private WebElement setEmail_Element;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='next']")    //PropUtils_Instance.GetValue("signinpage_enteremail_xpath"));
	private WebElement clickNext_Element;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='Passwd']")    //PropUtils_Instance.GetValue("signinpage_enteremail_xpath"));
	private WebElement setPassword_Element;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='signIn']")    //PropUtils_Instance.GetValue("signinpage_enteremail_xpath"));
	private WebElement clickSignIn_Element;
	

	
	//data entering into EnterEmail Control
	public void setEmail(String email){                                            
		 setEmail_Element.clear();
		 setEmail_Element.sendKeys(email);	
	}
	
	  public void clickNext(){
		  clickNext_Element.click();;
	  }
	  
	  
	  public void setPassword(String password){                                                                               
		       setPassword_Element.clear();
		       setPassword_Element.sendKeys(password);                                                                             
	  }
	  
	  public void clickSignIn(){
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}      
		  clickSignIn_Element.click();
	  }
	  
	  
	  public WebElement getErrorMessage(){
		  WebElement elementErr = 	driver.findElement(By.id("errormsg_0_Passwd"));
	      return elementErr;                                                                 
	  }
}











