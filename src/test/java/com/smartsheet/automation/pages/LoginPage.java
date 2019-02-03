package com.smartsheet.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is created to declare all the variables on the login Page. Class
 * also consists of the methods to perform actions on the elements
 * 
 * @author ravimaddali
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "loginEmail")
	private WebElement _txtEMail;

	@FindBy(id = "formControl")
	private WebElement _btnContinue;

	@FindBy(id = "loginPassword")
	private WebElement _txtPassword;

	@FindBy(id = "divFormTitleImage")
	private WebElement _lblTitle;

	/**
	 * Input username
	 * 
	 * @param userName
	 */
	public void enterUserName(String userName) {
		_txtEMail.sendKeys(userName);
	}

	/**
	 * Navigate to input password
	 */
	public void clickOnConitnueBtn() {
		_btnContinue.click();
	}

	/**
	 * Input password. Due to timing error, explicit wait is being used.
	 * 
	 * @param Password
	 * 
	 */
	public void enterPassword(String Password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginPassword")));
		_txtPassword.sendKeys(Password);
	}

	/**
	 * Navigate to the Home Page.
	 * 
	 * @return Driver
	 */

	public HomePage clickOnLoginBtn() {
		_btnContinue.click();
		return new HomePage(getDriver());

	}

}
