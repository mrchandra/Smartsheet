package com.smartsheet.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.smartsheet.automation.pages.HomePage;
import com.smartsheet.automation.pages.LoginPage;
import com.smartsheet.automation.pages.SheetPage;
import com.smartsheet.automation.utils.BaseTest;

/**
 * Class consists of the tests to be executed
 * 
 * @author ravimaddali
 *
 */
public class HomeTests extends BaseTest {
	BaseTest test;
	LoginPage loginPage;
	HomePage homePage;
	SheetPage sheetPage;
	WebDriver driver;

	SoftAssert assertion = new SoftAssert();

	/**
	 * Test method to add and delete column
	 */
	@Test(priority = 0)
	public void verify_add_colum() {
		loginPage.enterUserName("ravichandra.maddali@gmail.com");
		loginPage.clickOnConitnueBtn();
		loginPage.enterPassword("Ravi@1990");
		homePage = loginPage.clickOnLoginBtn();
		homePage.createNewSheet();
		homePage.selectGrid();
		homePage.enterSheetName("Sheet1");
		sheetPage = homePage.clickOnOK();
		sheetPage.addColumnLeft();
		sheetPage.clickOkButton();
		sheetPage.addColumnRight();
		sheetPage.clickOkButton();
		sheetPage.deleteColumn();
		assertion.assertAll();

	}

	@BeforeClass
	public void setup() {
		loginPage = new LoginPage(getDriver());
	}

}
