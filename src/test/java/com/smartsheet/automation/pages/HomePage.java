package com.smartsheet.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.smartsheet.automation.utils.WebDriverHelper;

/**
 * This class is created to declare the variables of the Home Page. Class also
 * consists of the methods for the actions to be performed on the HomePage.
 * 
 * @author ravimaddali
 *
 */
public class HomePage extends BasePage {

	WebDriver driver;
	@FindBy(css = ".button.solutionsCenterButton")
	private WebElement _btnNewSheet;

	@FindBy(xpath = "//*[@id='foid:18']/div[2]/div")
	private WebElement _gridSheetType;

	@FindBy(id = "foid:39")
	private WebElement _txtSheetName;

	@FindBy(xpath = "//*[@id='foid:40']/div/span")
	private WebElement _btnOk;

	@FindBy(className = "title")
	private WebElement _txtTitle;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Create a new sheet
	 */
	public void createNewSheet() {
		WebDriverHelper.implicitWaits();
		_btnNewSheet.click();
	}

	/**
	 * Select the type to be created
	 */
	public void selectGrid() {
		_gridSheetType.click();
	}

	/**
	 * Provide a name to the sheet which is passed a parameter
	 * 
	 * @param Name
	 */
	public void enterSheetName(String Name) {
		_txtSheetName.sendKeys(Name);
	}

	/**
	 * Navigate to created sheet. Returns the driver.
	 * 
	 * @return
	 */
	public SheetPage clickOnOK() {
		_btnOk.click();
		return new SheetPage(getDriver());
	}
}
